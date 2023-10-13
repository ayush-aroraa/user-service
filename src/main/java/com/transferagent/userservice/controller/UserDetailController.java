package com.transferagent.userservice.controller;

import com.transferagent.userservice.entities.UserDetails;
import com.transferagent.userservice.service.UserDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userdetails")
@Tag(name="UserDetails", description = "User Details Services API's")
public class UserDetailController {

    private final UserDetailService userDetailService;

    @Autowired
    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService=userDetailService;
    }

    //sign up api
    @PostMapping("/signup")
    @Operation(
    		summary = "Add a user providing all user details",
    		description = "Add a User with all Properties",
    		tags = "signup"
    		)
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
    
    @GetMapping("/signIn/{id}")
    @Operation(
    		summary = "Get a Single User Details",
    		description = "Get a Single User Details",
    		tags = "signin"
    		)
    public ResponseEntity<UserDetails> getUser(@PathVariable String id){
    	
    	Optional<UserDetails> fetchUserDetail = userDetailService.fetchUserDetail(id);
    	if(fetchUserDetail.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}else {
    		return ResponseEntity.status(HttpStatus.CREATED).body(fetchUserDetail.get());
    	}
    }
}
