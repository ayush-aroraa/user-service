package com.transferagent.userservice.service;


import com.transferagent.userservice.entities.UserDetails;
import com.transferagent.userservice.repo.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    public UserDetails addUserDetail(UserDetails userDetails){
        return userDetailRepo.save(userDetails);
    }

    public Optional<UserDetails> fetchUserDetail(String orderId)
    {
         return userDetailRepo.findById(orderId);
    }

}
