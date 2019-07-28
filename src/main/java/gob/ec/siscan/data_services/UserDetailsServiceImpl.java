package gob.ec.siscan.data_services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.ec.siscan.domain.model.Role;
import gob.ec.siscan.domain.model.Usuario;
import gob.ec.siscan.model.domain.repositoryjpa.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String P_TOKEN = "";

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String mobile) {
        Usuario user = userRepository.findByUsername(mobile)
                .orElseThrow(() -> new UsernameNotFoundException("mobile not found. " + mobile));
        return this.userBuilder(user.getCuentaUsuario(), user.getPassword(), new Role[]{Role.AUTHENTICATED}, true);

    }

    private org.springframework.security.core.userdetails.User userBuilder(String mobile, String password, Role[] roles,
                                                                           boolean active) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.roleName()));
        }
        return new org.springframework.security.core.userdetails.User(mobile, password, active, true,
                true, true, authorities);
    }
}
