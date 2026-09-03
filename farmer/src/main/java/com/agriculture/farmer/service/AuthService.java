package com.agriculture.farmer.service;

import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.repository.UserRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class AuthService {
    private UserRepo userRepo;
    public String saver(Users users) {
        userRepo.save(users);
        return "Admin saved ";
    }
}
