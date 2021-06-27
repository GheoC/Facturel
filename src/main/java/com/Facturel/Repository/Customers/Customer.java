package com.Facturel.Repository.Customers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer cui;
    private String owner;
    private String phone;

    public Integer getId() {
        return id;
    }

    public Customer setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCui() {
        return cui;
    }

    public Customer setCui(Integer cui) {
        this.cui = cui;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public Customer setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
