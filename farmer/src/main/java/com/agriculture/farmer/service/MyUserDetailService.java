package com.agriculture.farmer.service;
import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.repository.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.agriculture.farmer.model.UserPrincipal;

import java.util.Optional;

@Component
@Data
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = repo.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User Not Found");
        }
        Users userFinal = user.get();
        return new UserPrincipal(userFinal);
    }
}