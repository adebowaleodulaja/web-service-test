/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalsoft.restwebservices.restfulwebservices.user.controller;

import com.globalsoft.restwebservices.restfulwebservices.post.model.Post;
import com.globalsoft.restwebservices.restfulwebservices.repository.PostRepository;
import com.globalsoft.restwebservices.restfulwebservices.repository.UserRepository;
import com.globalsoft.restwebservices.restfulwebservices.user.model.User;
import java.net.URI;
import java.util.List;
import java.util.Optional;
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
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{userId}")
    public Optional<User> retrieveUser(@PathVariable int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User with id " + userId + " Not found");
        }
        return user;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }

    @GetMapping("/jpa/users/{userId}/posts")
    public List<Post> retrieveAllPostOfUser(@PathVariable int userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("user with id " + userId + " was not found");
        }

        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{userId}/post")
    public ResponseEntity<Object> createPost(@PathVariable int userId, @RequestBody Post post) {
        //Get the user
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with id " + userId + " Not found");
        }

        User user = userOptional.get();
        //Map the user to the post
        post.setUserId(user);
        postRepository.save(post);//Save the post to DB.
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(post.getPostId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
