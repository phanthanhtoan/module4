package com.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    private String username;

    private String password;

    //    @ManyToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "UserRole" ,
//            joinColumns = @JoinColumn(name = "role_id") ,
//            inverseJoinColumns = @JoinColumn(name = "username"))
//    private Set<Role> roles;

    @OneToMany(mappedBy = "employeeId")
    private Set<Employee> employees;

    public User() {
    }

    public User(String username, String password, Set<Role> roles, Set<Employee> employees) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.employees = employees;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
