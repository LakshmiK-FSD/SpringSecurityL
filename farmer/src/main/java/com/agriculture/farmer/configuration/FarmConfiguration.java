package com.agriculture.farmer.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.util.ArrayList;
import java.util.List;
@Configuration
@EnableWebSecurity
public class FarmConfiguration {
@Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
    http.csrf(customize->customize.disable())
    .authorizeHttpRequests(request->request.anyRequest().authenticated())
    .httpBasic(Customizer.withDefaults())
    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    return http.build();
}
@Bean
    public UserDetailsService userDetailsService(){
    UserDetails user1 = User.withDefaultPasswordEncoder()
                                   .username("fita")
                                   .password("fita")
                                   .roles("manager").build();
    UserDetails user2 = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("manager").build();
    List <UserDetails> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);
    return new InMemoryUserDetailsManager(users);
}
}
