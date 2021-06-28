package com.Facturel.Model;

import com.Facturel.Validator.Validations.OnCreate;
import com.Facturel.Validator.Validations.OnUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.HashSet;
import java.util.Set;

public class UserDTO
{
    @Null(message = "Must be null", groups = OnCreate.class)
    @Null(message = "Must be null", groups = OnUpdate.class)
    private Integer id;

    @Email
    @NotNull
    private String email;

    @Length(min = 3)
    @Null(message = "Must be null on Update user", groups = OnUpdate.class)
    @NotNull(message = "Password is required", groups = OnCreate.class)
    private String password;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @Null(message = "Must be null", groups = OnCreate.class)
    @Null(message = "Must be null", groups = OnUpdate.class)
    private Set<RoleDTO> dtoRoles = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<RoleDTO> getDtoRoles() {
        return dtoRoles;
    }

    public UserDTO setDtoRoles(Set<RoleDTO> dtoRoles) {
        this.dtoRoles = dtoRoles;
        return this;
    }
}
