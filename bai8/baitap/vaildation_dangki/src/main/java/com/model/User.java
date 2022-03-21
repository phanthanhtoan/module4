package com.model;

import org.springframework.validation.BindingResult;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min=5, max =45)
    private String firstName;

    @Size(min=5, max =45)
    @NotEmpty
    private String lastName ;

    @Pattern(regexp = "(|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Nhap lai di")
    private String phoneNumber;

    @Size(min = 18)
    private String age;

    private String email;

    @ManyToOne(targetEntity = CategoryUser.class)
    private CategoryUser categoryUser;


    public void validate(User user, BindingResult bindingResult) {
    }

    public User() {
    }

    public User(Long id, String firstName, String lastName, String phoneNumber, String age, String email, CategoryUser categoryUser) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.categoryUser = categoryUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CategoryUser getCategoryUser() {
        return categoryUser;
    }

    public void setCategoryUser(CategoryUser categoryUser) {
        this.categoryUser = categoryUser;
    }
}
