package com.Facturel.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class RoleDTO
{
    @Null
    private Integer id;

    @NotNull
    @NotBlank
    private String name;

    public Integer getId() {
        return id;
    }

    public RoleDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }
}
