package com.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String  username ;
    private String password;

    @ManyToMany(mappedBy = "user")
    private Set<Role> roles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "UserRole" ,
//            joinColumns = @JoinColumn(name = "role_id") ,
//            inverseJoinColumns = @JoinColumn(name = "username"))
//    private Set<Role> roles;


    public User() {
    }

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
