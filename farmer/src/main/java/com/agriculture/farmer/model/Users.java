package com.agriculture.farmer.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
    private String role;

}
