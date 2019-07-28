package gob.ec.siscan.domain.model;

public enum Role {
    ADMIN, MANAGER, OPERATOR, CUSTOMER, AUTHENTICATED;

    public String roleName() {
        return "ROLE_" + this.toString();
    }

    public boolean isRole() {
        for(Role role: Role.values()) {
            if(!role.roleName().equals(this)) {
                return false;
            }
        }
        return true;
    }

}
