package com.LensCart.controller;

import com.LensCart.entity.User;
import com.LensCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3006)
public class UserController {
    @Autowired
    UserService  userService;


    @GetMapping("/all")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User users=userService.getUserById(id);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

}
