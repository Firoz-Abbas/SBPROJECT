package com.onlyjavaboot.roz.controller;

import com.onlyjavaboot.roz.dao.UserDaoRepository;
import com.onlyjavaboot.roz.intities.User;
import com.onlyjavaboot.roz.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

@Autowired
private UserServices userServices;

@GetMapping("/users")
public List<User> getUseres(){
    return this.userServices.getUseres();
}

@PostMapping("/users")
public User addUser(@RequestBody User user){
    return this.userServices.addUser(user);
}

@PutMapping("/users")
    public User updateUser(@RequestBody User user){
    return this.userServices.updateUser(user);
}



@DeleteMapping("users/{userId}")
    public void deleteUser(@PathVariable String userId ){
    this.userServices.deleteUser(Integer.parseInt(userId));
}



}
