package com.agriculture.farmer.controller;

import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.repository.UserRepo;
import com.agriculture.farmer.service.JwtUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Data
public class AuthController {
    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users users){
       String usrUnAth = users.getUsername();
       if (userRepo.findByUsername(usrUnAth).isPresent()){
         return ResponseEntity.status(HttpStatus.OK).body("username Already Exists");
       }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("username Not Found");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user){
        String usrUnAth = user.getUsername();
        Optional <Users> userop=userRepo.findByUsername(usrUnAth);
        if (userop.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("username Not Found");
//           Users checkUser = userop.get();
        }
        Users checkUser = userop.get();
            if (!bCryptPasswordEncoder.matches(user.getPassword(),checkUser.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unautherized");
            }

        String token = jwtUtil.tokenGener(usrUnAth);
        return ResponseEntity.ok(Map.of("token",token));
    }
}
