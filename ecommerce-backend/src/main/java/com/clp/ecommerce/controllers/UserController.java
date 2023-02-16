package com.clp.ecommerce.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clp.ecommerce.models.Credentials;
import com.clp.ecommerce.models.Response;
import com.clp.ecommerce.models.User;
import com.clp.ecommerce.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
public class UserController {
    private final UserService userService;
    private HttpSession userSession;
    

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity <List<User>> allUsers(){
        return ResponseEntity.ok(userService.allUsers());
    }

    @PostMapping(value = "/newuser")
    public ResponseEntity<User> creatNewUser(@RequestBody User user){
        
        User u = userService.creatNewUser(user);

        return ResponseEntity.ok().body(u);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody Credentials credentials, HttpServletRequest req){
        userSession = req.getSession();
        User user = userService.login(credentials);
        userSession.setAttribute("user", user);
        return ResponseEntity.ok().body(user);
    }


    @GetMapping(value = "/order/{id}")
    public ResponseEntity<Response> order(@PathVariable UUID id){
        //User user = (User) userSession.getAttribute("user");
        Response response = new Response(userService.order(id));
        return ResponseEntity.ok(response);
    }
}
