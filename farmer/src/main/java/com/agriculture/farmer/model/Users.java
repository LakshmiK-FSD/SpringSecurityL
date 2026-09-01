package com.agriculture.farmer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
    private int id;
    private String username;
    private int password;

}
