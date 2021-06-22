package com.example.demo_hql.controller;

import com.example.demo_hql.dto.UserDTO;
import com.example.demo_hql.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{s}")
    public List<UserDTO> findAllByNameContais(@PathVariable String s){
        return userService.findAllByNameContains(s);
    }

    @GetMapping("/id/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }
//
//    @PostMapping("/create")
//    public UserDTO createUser(@RequestBody UserDTO userDTO){
//        return null;
//    }
//
    @PostMapping("/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Integer deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
//
//    @PutMapping
//    public UserDTO updateUserPassword(@RequestBody UserNewPasswordDTO userPasswordDTO){
//        return null;
//    }

}
