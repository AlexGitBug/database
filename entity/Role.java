package entity;

import java.util.Objects;

public class Role {
    private int id;
    private String roleInfo;

    public Role() {
    }

    public Role(int id, String role) {
        this.id = id;
        this.roleInfo = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id && Objects.equals(roleInfo, role1.roleInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleInfo);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + roleInfo + '\'' +
                '}';
    }
}

