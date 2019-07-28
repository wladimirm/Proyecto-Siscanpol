package gob.ec.siscan.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import gob.ec.siscan.bussines.service.JwtService;
import gob.ec.siscan.domain.model.Usuario;
import gob.ec.siscan.dto.UserProfileDto;
import gob.ec.siscan.dto.output.TokenOutputDto;
import gob.ec.siscan.exceptions.BadRequestException;
import gob.ec.siscan.exceptions.NotFoundException;
import gob.ec.siscan.model.domain.repositoryjpa.UsuarioRepository;

@Controller
public class UserController {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public TokenOutputDto login(String mobile) {
        Usuario user = userRepository.findByUsername(mobile)
                .orElseThrow(() -> new RuntimeException("Unexpected!!. Mobile not found:" + mobile));
        String[] roles = user.getRoles().toArray(new String[user.getRoles().size()]);
        return new TokenOutputDto(jwtService.createToken(user.getCuentaUsuario(), user.getNombre(), roles));
    }

 /*   public UserDto readUser(String mobile, String claimMobile, List<String> claimRoles) {
        Usuario user = this.userRepository.findByUsername(mobile)
                .orElseThrow(() -> new NotFoundException("User mobile:" + mobile));
      
        this.authorized(claimMobile, claimRoles, mobile, user.getRoles());
        return new UserDto(user);
    }

    private void authorized(String claimMobile, List<String> claimRoles, String userMobile, List<String> userRoles) {
        if (claimRoles.contains(Role.ADMIN.roleName()) || claimMobile.equals(userMobile)) {
            return;
        }
        if (claimRoles.contains(Role.MANAGER.roleName())
                && !userRoles.contains(Role.ADMIN.roleName()) && !userRoles.contains(Role.MANAGER.roleName())) {
            return;
        }
        if (claimRoles.contains(Role.OPERATOR.roleName())
                && userRoles.stream().allMatch(role -> role.equals(Role.CUSTOMER.roleName()))) {
            return;
        }
        throw new ForbiddenException("User mobile (" + userMobile + ")");
    }

    public List<UserMinimumDto> readAll() {
        return this.userRepository.findAllUsers();
    }

    public UserMinimumDto createUserMinimum(UserMinimumDto userMinimumDto) {
        if(this.userRepository.findByMobile(userMinimumDto.getMobile()).isPresent()) {
            throw new BadRequestException("User mobile (" + userMinimumDto.getMobile() + ") already exist.");
        }

        User saved = User.builder().username(userMinimumDto.getUsername()).mobile(userMinimumDto.getMobile())
                .roles(new Role[]{Role.CUSTOMER}).build();

        this.userRepository.save(saved);
        return new UserMinimumDto(saved.getMobile(), saved.getUsername());
    }

    public UserDto create(UserDto userDto) {
        if(this.userRepository.findByMobile(userDto.getMobile()).isPresent()) {
            throw new BadRequestException("User mobile (" + userDto.getMobile() + ") already exist.");
        }
        User saved = User.builder().mobile(userDto.getMobile()).username(userDto.getUsername()).email(userDto.getEmail())
                .dni(userDto.getDni()).discount(userDto.getDiscount()).address(userDto.getAddress()).active(userDto.isActive()).roles(new Role[]{Role.CUSTOMER})
                .registrationDate(userDto.getRegistrationDate()).build();

        this.userRepository.save(saved);
        return new UserDto(saved);
    }

    public UserDto update(String mobile, UserDto userDto) {

        if(!mobile.equals(userDto.getMobile())) {
            throw new BadRequestException("User mobile (" + mobile + ")");
        }
        User userFound = this.userRepository.findByMobile(mobile)
                .orElseThrow(() -> new NotFoundException("User mobile (" + userDto.getMobile() + ") is not found."));

        User saved = User.builder().id(userFound.getId()).username(userDto.getUsername()).password(userFound.getPassword())
                .mobile(userDto.getMobile()).roles(userFound.getRoles()).dni(userDto.getDni()).discount(userDto.getDiscount()).address(userDto.getAddress())
                .email(userDto.getEmail()).registrationDate(userDto.getRegistrationDate()).active(userDto.isActive()).build();

        this.userRepository.save(saved);
        return new UserDto(saved);
    }

    public UserDto updateRoles(String mobile, UserRolesDto userRolesDto) {

    if (mobile == null || !mobile.equals(userRolesDto.getMobile()))
            throw new BadRequestException("User mobile (" + userRolesDto.getMobile() + ")");

        User user = this.userRepository.findByMobile(mobile).orElseThrow(() -> new NotFoundException("User mobile (" + mobile + ")"));;
        User result = this.userRepository.save(new User(user.getId(),user.getUsername(),user.getDni(),user.getDiscount(),user.getEmail(),user.getAddress(),user.getPassword(),userRolesDto));
        return new UserDto(result);
    }
*/
    public UserProfileDto updateProfile(String mobile, UserProfileDto userProfileDto) {

        if (mobile == null || !mobile.equals(userProfileDto.getMobile()))
            throw new BadRequestException("User mobile (" + userProfileDto.getMobile() + ")");

        Usuario user = this.userRepository.findByUsername(mobile).orElseThrow(() -> new NotFoundException("User mobile (" + mobile + ")"));;
        Usuario result = this.userRepository.save(user);
        return new UserProfileDto(result);
    }
    /*
    public List<UserMinimumDto> readAllByUsernameDniDiscountAddressRoles(String mobile,String username,String dni,String discount,String address,Role[] roles) {
       return this.userRepository.findByMobileUsernameDniDiscountAddressLikeNullSafeandRoles(mobile,username,dni,discount,address,roles);
    }*/

    public Boolean validatorPassword(String mobile, UserProfileDto userProfileDto) {
        if (mobile == null || !mobile.equals(userProfileDto.getMobile()))
            throw new BadRequestException("User mobile (" + userProfileDto.getMobile() + ")");

        Usuario user = this.userRepository.findByUsername(mobile).orElseThrow(() -> new NotFoundException("User mobile (" + mobile + ")"));;
        return new BCryptPasswordEncoder().matches(userProfileDto.getPassword(),user.getPassword());
    }
}
