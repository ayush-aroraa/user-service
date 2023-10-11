package com.transferagent.userservice.controller;

import com.transferagent.userservice.entities.UserDetails;
import com.transferagent.userservice.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserDetailController {

    private final UserDetailService userDetailService;

    @Autowired
    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService=userDetailService;
    }

    //sign up api
    @PostMapping("/users/signup")
    public ResponseEntity<Object> addUser(@RequestBody UserDetails userDetails){
        UserDetails user=null;
        try {
             user = userDetailService.addUserDetail(userDetails);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
