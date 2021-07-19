package com.Facturel.Repository.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    public User getByEmail(String email);
    Optional<User> findByEmail(String email);
}

