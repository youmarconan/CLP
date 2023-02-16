package com.clp.ecommerce.daos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clp.ecommerce.models.User;

@Repository
public interface UserRepo extends JpaRepository<User,UUID>{
    
    public User findUserByEmailAndPassword(String email, String password);

}
