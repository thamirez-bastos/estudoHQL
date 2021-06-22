package com.example.demo_hql.service;

import com.example.demo_hql.dto.UserDTO;
import com.example.demo_hql.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAllUsers(){
        return userRepository.findAllUsers();
    }

    public List<UserDTO> findAllByNameContains(@PathVariable String s){ return userRepository.findAllByNameContains(s);}

    public UserDTO findUserById(@PathVariable Long id) { return userRepository.findUserById(id);}

    public UserDTO saveUser(UserDTO userDTO){
        return userRepository.save(userDTO);
    }

    public Integer deleteUser(@PathVariable Long id){ return userRepository.deleteUser(id);}


}

