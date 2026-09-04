package com.agriculture.farmer.configuration;
import com.agriculture.farmer.service.AuthFilterChain;
import com.agriculture.farmer.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;
@Configuration
@EnableWebSecurity
public class FarmConfiguration {
    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthFilterChain authFilterChain){
        http.csrf(customize->customize.disable())
                .authorizeHttpRequests(request->request.requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/users/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()).addFilterBefore(authFilterChain, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
    @Bean
    public AuthenticationProvider provider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(12);
    }


//@Bean
//    public UserDetailsService userDetailsService(){
//    UserDetails user1 = User.withDefaultPasswordEncoder()
//                                   .username("fita")
//                                   .password("fita")
//                                   .roles("manager").build();
//    UserDetails user2 = User.withDefaultPasswordEncoder()
//            .username("admin")
//            .password("admin")
//            .roles("manager").build();
//    List <UserDetails> users = new ArrayList<>();
//    users.add(user1);
//    users.add(user2);
//    return new InMemoryUserDetailsManager(users);
//}
}
