package com.Facturel;

import com.Facturel.Repository.Roles.Role;
import com.Facturel.Repository.Roles.RoleRepository;
import com.Facturel.Repository.Users.User;
import com.Facturel.Repository.Users.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Test
    public void testAddRoleToNewUser() {
        Role roleAdmin = roleRepo.findByName("admin");

        User user = new User();
        user.setEmail("gheorghe.coanta@gmail.com");
        user.setPassword("gheo");
        user.setFirstName("Gheorghe");
        user.setLastName("Coanta");
        user.addRole(roleAdmin);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }

    @Test
    public void testAddRoleToExistingUser() {
        User user = userRepo.getById(1);
        Role roleUser = roleRepo.findByName("user");
        Role roleCustomer = roleRepo.findByName("customer");

        user.addRole(roleUser);
        user.addRole(roleCustomer);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(3);
    }
}
