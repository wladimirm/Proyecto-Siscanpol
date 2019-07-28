package gob.ec.siscan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import gob.ec.siscan.domain.model.Usuario;
import gob.ec.siscan.domain.model.UsuarioRol;

import javax.validation.constraints.Pattern;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class UserDto extends UserMinimumDto {

    @Pattern(regexp = gob.ec.siscan.dtos.validations.Pattern.EMAIL_PATTERN)
    private String email;

    private String name;

    private String lastname;

    private Boolean active;

   // private Role[] roles;
    private  List<UsuarioRol> roles;
  

    public UserDto() {
        // Empty for framework
    }

    public UserDto(Usuario user) {
        super(user.getIdUsuario(), user.getCuentaUsuario());
        this.name = user.getNombre();
        this.lastname = user.getApellidoPaterno();
        this.email = user.getEmail();
        this.active = true;
        this.roles = user.getRoles();
       
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public List<UsuarioRol> getRoles() {
		return roles;
	}

	public Boolean isActive() {
        return active;
    }



   

   
}
