package com.backenddynamouser.controller;


import com.backenddynamouser.entity.UserAccount;
import com.backenddynamouser.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class UserAccountController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @PostMapping("/userAccount")
    public UserAccount saveUserAccount(@RequestBody UserAccount userAccount){
        return userAccountRepository.save(userAccount);
    }

    @GetMapping("/userAccount/all")
    public List<UserAccount> getUserAccount (){
        return List<UserAccount> userAccountRepository.getAllUsers();
    }

    @GetMapping("/userAccount/{id}")
    public UserAccount getUserAccount (@PathVariable("id") String userId){
        return userAccountRepository.getUserAccountById(userId);
    }

    @DeleteMapping ("/userAccount/{id}")
    public String deleteUserAccount(@PathVariable("id") String userId){
        return userAccountRepository.delete(userId);
    }

    @PutMapping ("/userAccount/{id}")
    public String updateUserAccount(@PathVariable("id") String userId, @RequestBody UserAccount userAccount){
        return userAccountRepository.update(userId, userAccount);
    }
}
