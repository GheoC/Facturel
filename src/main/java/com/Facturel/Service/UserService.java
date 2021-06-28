package com.Facturel.Service;


import com.Facturel.Model.Adaptors.UserAdapter;
import com.Facturel.Model.RoleDTO;
import com.Facturel.Model.UserDTO;
import com.Facturel.Repository.Roles.Role;
import com.Facturel.Repository.Roles.RoleRepository;

import com.Facturel.Repository.Users.User;
import com.Facturel.Repository.Users.UserRepository;
import com.Facturel.Validator.Validations.OnCreate;
import com.Facturel.Validator.Validations.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        return this;
    }

    @Autowired
    public UserService setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        return this;
    }

    public List<UserDTO> getUsers()
    {
        return UserAdapter.userDTOList(userRepository.findAll());
    }

    @Validated(OnCreate.class)
    public void addDefaultUser(@Valid UserDTO userDTO)
    {
        Role roleUser = roleRepository.findByName("user");

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.addRole(roleUser);

        userRepository.save(user);
    }

    public void addRolesToUser(Integer id, List<@Valid RoleDTO> rolesDTO)
    {
        User user = userRepository.findById(id).orElseThrow();

        Set<Role> roles = rolesDTO
                .stream()
                .map(roleDTO -> roleRepository.findByName(roleDTO.getName()))
                .collect(Collectors.toSet());

       roles.forEach(role -> user.addRole(role));
       userRepository.save(user);
    }

    public void deleteUser(Integer id)
    {
        userRepository.deleteById(id);
    }

    @Validated(OnUpdate.class)
    public void updateUser(Integer id, @Valid UserDTO userDTO)
    {
        User user = userRepository.getById(id);
        user
                .setEmail(userDTO.getEmail())
                .setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName());
        userRepository.save(user);
    }
}
