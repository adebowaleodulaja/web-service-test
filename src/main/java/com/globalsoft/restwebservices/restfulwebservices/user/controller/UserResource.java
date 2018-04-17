/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalsoft.restwebservices.restfulwebservices.user.controller;

import com.globalsoft.restwebservices.restfulwebservices.user.model.User;
import com.globalsoft.restwebservices.restfulwebservices.user.model.UserDaoService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author adebowale.odulaja
 */
@RestController
public class UserResource {
    
    @Autowired //Since we have defined UserDao to be a component using @Component, Autowired will allow us not have to intantiate the class.
    private UserDaoService service;
    
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }
    
    @GetMapping("/users/{userId}")
    public User retrieveUser(@PathVariable int userId){
        User user = service.findOne(userId);
        if(user==null){
            throw new UserNotFoundException("User with id "+ userId+" Not found");
        }
        return user;
    }
    
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/users/{userId}")
    public User deleteUser(@PathVariable int userId){
        User user = service.deleteById(userId);
        if(user==null){
            throw new UserNotFoundException("User with id "+ userId+" Not found");
        }
        return user;
    }
    
}
