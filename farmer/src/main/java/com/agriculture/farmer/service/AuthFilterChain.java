package com.agriculture.farmer.service;

import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.repository.UserRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
@Data
@RequiredArgsConstructor
public class AuthFilterChain implements OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String headr=  request.getHeader("Authorization");
       if(headr != null && headr.startsWith("Bearer ")){
           String token = headr.substring(7);
       }
    }
}
