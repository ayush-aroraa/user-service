package com.transferagent.userservice.repo;

import com.transferagent.userservice.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserDetailRepo extends JpaRepository<UserDetails,String> {
}
