package com.backenddynamouser.controller;


import com.backenddynamouser.entity.UserAccount;
import com.backenddynamouser.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins="*")

public class UserAccountController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @PostMapping("/userAccount")
    public UserAccount saveUserAccount(@RequestBody UserAccount userAccount){
        return userAccountRepository.save(userAccount);
    }

    @GetMapping("/userAccount/all")
    public List <UserAccount> getUserAccount (){
        return userAccountRepository.getAllUsers();
    }

    @GetMapping("/userAccount/{id}")
    public UserAccount getUserAccount (@PathVariable("id") String userId){
        return userAccountRepository.getUserAccountById(userId);
    }

    @DeleteMapping ("/userAccount/{id}")
    public UserAccount deleteUserAccount(@PathVariable("id") String userId){
        return userAccountRepository.delete(userId);
    }

    @PutMapping ("/userAccount/{id}")
    public UserAccount updateUserAccount(@PathVariable("id") String userId, @RequestBody UserAccount userAccount){
        return userAccountRepository.update(userId, userAccount);
    }
}
