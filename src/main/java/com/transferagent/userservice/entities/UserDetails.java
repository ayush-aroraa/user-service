package com.transferagent.userservice.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "userDetailsPII")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description= "User Details Schema")
public class UserDetails {
    @Id
    @Schema(description = "User Id in String", example = "AB-123")
    private String objectId;
    @Schema(description = "User First Name", example="Alexender")
    private String firstName;
    @Schema(description = "User Middle Name", example = "Brown")
    private String middleName;
    @Schema(description = "User Last Name", example = "2nd")
    private String lastName;
    @Schema(description = "User Email Id", example = "abc@xyz.com")
    private String emailId;
}
