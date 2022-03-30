package com.case_study.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private Long employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @ManyToOne(targetEntity = Position.class)
    private Position position;
    @ManyToOne(targetEntity = EducationDegree.class)
    private EducationDegree educationDegree;
    @ManyToOne(targetEntity = Division.class)
    private Division division;

    @ManyToOne(targetEntity = User.class)
    private User user;
//     @ManyToOne(targetEntity = Customer.class)
//    private Customer customer;

//      @ManyToOne(targetEntity = Service.class)
//    private Service service;
      @OneToMany(mappedBy = "contractId")
    private Set<Contract> contract;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, Date employeeBirthday, String employeeIdCard, Double employeeSalary, Long employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree level, Division division, User user, Set<Contract> contract) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = level;
        this.division = division;
        this.user = user;
        this.contract = contract;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Long getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(Long employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree level) {
        this.educationDegree = level;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }
}
