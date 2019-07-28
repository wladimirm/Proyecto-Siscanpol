package gob.ec.siscan.config;

import java.time.LocalDate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
//import gob.ec.siscan.domain.model.Role;
import gob.ec.siscan.domain.model.TimeClock;
import gob.ec.siscan.domain.model.Usuario;
import gob.ec.siscan.domain.model.UsuarioRol;
import gob.ec.siscan.model.domain.repositoryjpa.TimeClockRepository;
import gob.ec.siscan.model.domain.repositoryjpa.UsuarioRepository;
import org.springframework.security.core.userdetails.User;

@Component
@Aspect
public class UserAccessAspect {

    public enum RoleType {
        ROLE_AUTHENTICATED,
        ROLE_MANAGER,
        ROLE_OPERATOR;
    }

    @Autowired
    private TimeClockRepository timeClockRepository;

    @Autowired
    private UsuarioRepository userRepository;

    @Pointcut("execution(* gob.ec.siscan.rest.UserResource.logout(..))")
    public void saveLogoutTimeClock() {
        // Empty but necessary for the implementation
    }

    @Pointcut("execution(* gob.ec.siscan.rest.UserResource.login(..))")
    public void saveLoginTimeClock() {
        // Empty but necessary for the implementation
    }

    @Before("saveLogoutTimeClock()")
    public void logoutTimeClock(JoinPoint joinPoint) {
        Object[] lArgs = joinPoint.getArgs();
        Long activeUserMobile = (Long) lArgs[0];
       Usuario userLogged = this.userRepository.findByUserId(activeUserMobile).orElse(null);
        if (userLogged != null && hasActiveUserRolOperatorManager(userLogged)) {
            TimeClock timeClockActiveUser = this.timeClockRepository.findByTimeId(userLogged.getIdUsuario()).orElse(null);
            if (timeClockActiveUser != null && sameDay(timeClockActiveUser)) {
                timeClockActiveUser.clockout();
                LogManager.getLogger(joinPoint.getSignature().getDeclaringTypeName()).info(timeClockActiveUser.toString());
                this.timeClockRepository.save(timeClockActiveUser);
                toLogResult(joinPoint, timeClockActiveUser, "[LogoutTimeClock Return] ::: ");
            }
        }
    }

    private boolean sameDay(TimeClock timeClockActiveUser) {
        return timeClockActiveUser.getHorasalida().toLocalDate().isEqual(LocalDate.now());
    }

    private boolean isActiveUserAuthenticated(User activeUser) {
        List<GrantedAuthority> authorities = activeUser.getAuthorities().stream().filter(grantedAuthority -> grantedAuthority.getAuthority().matches(RoleType.ROLE_AUTHENTICATED.name())).collect(Collectors.toList());
        return !authorities.isEmpty();
    }

    @AfterReturning("saveLoginTimeClock()")
    public void loginTimeClock(JoinPoint joinPoint) {
        Object[] lArgs = joinPoint.getArgs();
        User activeUser = (User) lArgs[0];
        Usuario userLogged = this.userRepository.findByUsername(activeUser.getUsername()).orElse(null);
        if (userLogged != null && isActiveUserAuthenticated(activeUser) && hasActiveUserRolOperatorManager(userLogged)) {
            TimeClock firstTimeClockUser = this.timeClockRepository.findByTimeId(userLogged.getIdUsuario()).orElse(null);
            if (firstTimeClockUser == null || !sameDay(firstTimeClockUser)) {
                TimeClock timeClockCreated = this.timeClockRepository.save(new TimeClock(userLogged));
                toLogResult(joinPoint, timeClockCreated, "[LoginTimeClock Return] ::: ");
            }
        }
    }

    private boolean hasActiveUserRolOperatorManager(Usuario userLogged) {
    	List<UsuarioRol> roles = userLogged.getRoles();
    	UsuarioRol rol = roles.stream()
                .filter(Objects::nonNull).filter(role -> RoleType.ROLE_MANAGER.name().equals("ROLE_" +role.getRol().getNombre()) || RoleType.ROLE_OPERATOR.name().equals("ROLE_" +role.getRol().getNombre()))
                .findAny()
                .orElse(null);
        return rol != null;
    }

    private void toLogResult(JoinPoint joinPoint, TimeClock timeClockUpdated, String s) {
        String log = s + joinPoint.getSignature().getName() + ": " + timeClockUpdated.toString();
        LogManager.getLogger(joinPoint.getSignature().getDeclaringTypeName()).info(log);
    }
}