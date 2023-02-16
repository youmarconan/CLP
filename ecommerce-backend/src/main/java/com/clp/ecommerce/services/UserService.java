package com.clp.ecommerce.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clp.ecommerce.daos.ItemRepo;
//import com.clp.ecommerce.daos.ItemRepo;
import com.clp.ecommerce.daos.UserRepo;
import com.clp.ecommerce.models.Credentials;
import com.clp.ecommerce.models.Item;
import com.clp.ecommerce.models.User;


@Service
public class UserService {
    
    private final UserRepo userRepo;
    private final ItemRepo itemRepo;

    @Autowired
    public UserService(UserRepo userRepo, ItemRepo itemRepo) {
        this.userRepo = userRepo;
        this.itemRepo = itemRepo;
    }

    public List<User> allUsers(){
        return userRepo.findAll();
    }

    public User creatNewUser(User user){
        user.setId(UUID.randomUUID());
        return userRepo.save(user);
    }

    public User login(Credentials credentials){

        return userRepo.findUserByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
    }


    @Transactional
    public String order(UUID id){
       
        Item items = itemRepo.findById(id).orElseThrow(RuntimeException::new);

        return items.getName() + " has been ordered";
    }

}
