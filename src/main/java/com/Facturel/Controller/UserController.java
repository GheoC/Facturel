package com.Facturel.Controller;

import com.Facturel.Model.RoleDTO;
import com.Facturel.Model.UserDTO;
import com.Facturel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping

    public ResponseEntity getUsers()
    {
        return ResponseEntity.ok(userService.getUsers());
    }

    //adding a user
    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO)
    {
        userService.addDefaultUser(userDTO);
    }

    //adding more roles to a user
    @PostMapping("/roles/{id}")
    public void addRolesToUser(@PathVariable("id")Integer id, @RequestBody List<RoleDTO> rolesDTO)
    {
        userService.addRolesToUser(id, rolesDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id")Integer id)
    {
        userService.deleteUser(id);

    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id")Integer id, @RequestBody UserDTO userDTO)
    {

        userService.updateUser(id,userDTO);

    }

}
