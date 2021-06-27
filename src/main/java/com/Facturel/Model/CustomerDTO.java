package com.Facturel.Model;

import com.Facturel.Validator.ValidPhoneNumber;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerDTO
{
    private Integer id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Range(min = 0, max= Integer.MAX_VALUE, message = "Please enter valid integer Number")
    private Integer cui;

    @NotNull(message = "Owner is mandatory")
    @NotBlank(message = "Owner is mandatory")
    private String owner;

    @ValidPhoneNumber
    private String phone;

    public Integer getId() {
        return id;
    }

    public CustomerDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCui() {
        return cui;
    }

    public CustomerDTO setCui(Integer cui) {
        this.cui = cui;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public CustomerDTO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
