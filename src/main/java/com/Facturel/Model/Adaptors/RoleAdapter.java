package com.Facturel.Model.Adaptors;

import com.Facturel.Model.RoleDTO;
import com.Facturel.Repository.Roles.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RoleAdapter
{
    public static RoleDTO toDto(Role role)
    {
        return new RoleDTO()
                .setId(role.getId())
                .setName(role.getName());
    }

    public static Role fromDto(RoleDTO roleDTO)
    {
        return new Role().setName(roleDTO.getName());

    }

    public static Set<RoleDTO> roleDTOS(Set<Role> roles)
    {
        return roles.stream().map(role -> toDto(role)).collect(Collectors.toSet());
    }

}
