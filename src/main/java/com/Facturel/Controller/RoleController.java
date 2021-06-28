package com.Facturel.Controller;


import com.Facturel.Repository.Roles.Role;
import com.Facturel.Repository.Roles.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @GetMapping
    public ResponseEntity<List<Role>> getRoles()
    {
        return ResponseEntity.ok(roleRepository.findAll());

    }

    @GetMapping("/type")
    public ResponseEntity<Role> getRole(@RequestParam("role") String role)
    {

        Role roleDB = roleRepository.findByName(role);
        System.out.println(roleDB.getId()+" "+ roleDB.getName());
        return ResponseEntity.ok(roleDB);
    }

}
