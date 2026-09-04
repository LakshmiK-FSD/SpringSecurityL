package com.agriculture.farmer.service;

import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.repository.UserRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class AuthFilterChain extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String headr=  request.getHeader("Authorization");
       if(headr != null && headr.startsWith("Bearer ")) {
           String token = headr.substring(7);
           if (jwtUtil.validation(token)) {
               String userName = jwtUtil.unWrap(token);
               Optional<Users> userOpt=userRepo.findByUsername(userName);
               if(userOpt.isPresent()){
                   Users userR = userOpt.get();
                   UsernamePasswordAuthenticationToken userT= new UsernamePasswordAuthenticationToken(userR,null, Collections.singleton(new SimpleGrantedAuthority("ROLE_"+ userR.getRole())));
                   SecurityContextHolder.getContext().setAuthentication(userT);
               }

           }
       }
        filterChain.doFilter(request,response);
    }
}
