package com.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role",
//            joinColumns =@JoinColumn(name = "roleId"),
//            inverseJoinColumns = @JoinColumn(name = "username"))

    private Set<User> user;

    public Role() {
    }
    public Role(String roleName) {
        this.roleName=roleName;
    }

    public Role(Long roleId, String roleName, Set<User> user) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.user = user;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
