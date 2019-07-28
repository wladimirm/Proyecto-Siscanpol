package gob.ec.siscan.dto;

import java.util.Arrays;

import gob.ec.siscan.domain.model.Role;

public class UserRolesDto {

    private Long mobile;
    private Role[] roles;

    public UserRolesDto() {}

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRolesDto{" +
                ", mobile='" + mobile + '\'' +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }

}
