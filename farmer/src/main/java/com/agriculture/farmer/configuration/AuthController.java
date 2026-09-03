package com.agriculture.farmer.configuration;

import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.service.AuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Data
public class AuthController {
    private AuthService authserv;
    @PostMapping("/register")
    public String register(@RequestBody Users users){
       return authserv.saver(users);
    }
    @PostMapping("/login")
    public String loginUser(Users user){
        return
    }
}
