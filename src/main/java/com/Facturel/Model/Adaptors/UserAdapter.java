package com.Facturel.Model.Adaptors;

import com.Facturel.Model.UserDTO;
import com.Facturel.Repository.Users.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserAdapter
{
    public static User fromDto(UserDTO userDTO)
    {
        return new User()
                .setEmail(userDTO.getEmail())
                .setPassword(userDTO.getPassword())
                .setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName());
    }

    public static UserDTO toDto(User user)
    {
        return new UserDTO()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setDtoRoles(RoleAdapter.roleDTOS(user.getRoles()));
    }

    public static List<UserDTO> userDTOList(List<User> users)
    {
        return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }

}
