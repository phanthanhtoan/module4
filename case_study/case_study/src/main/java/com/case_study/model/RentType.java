package com.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRentType;
    private String nameRentType;
    private Double rentTypeCost;

    @OneToMany(mappedBy = "serviceId")
    private Set<Service> services;

    public RentType() {
    }

    public RentType(Long idRentType, String nameRentType, Double rentTypeCost, Set<Service> services) {
        this.idRentType = idRentType;
        this.nameRentType = nameRentType;
        this.rentTypeCost = rentTypeCost;
        this.services = services;
    }

    public Long getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(Long idRentType) {
        this.idRentType = idRentType;
    }

    public String getNameRentType() {
        return nameRentType;
    }

    public void setNameRentType(String nameRentType) {
        this.nameRentType = nameRentType;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
