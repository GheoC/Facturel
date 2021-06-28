package com.Facturel;

import com.Facturel.Repository.Roles.Role;
import com.Facturel.Repository.Roles.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTests
{
    private final RoleRepository roleRepository;

    @Autowired
    public RoleRepositoryTests(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Test
    public void testCreateRoles()
    {
        Role user = new Role("user");
        Role admin = new Role("admin");
        Role customer = new Role("customer");

        roleRepository.saveAll(List.of(user, admin, customer));

        List<Role> listRoles = roleRepository.findAll();



        assertThat(listRoles.size()).isEqualTo(3);
    }
}
