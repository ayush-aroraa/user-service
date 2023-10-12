package com.transferagent.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "UserDetailsPII")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails {
    @Id
    private String objectId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
}
