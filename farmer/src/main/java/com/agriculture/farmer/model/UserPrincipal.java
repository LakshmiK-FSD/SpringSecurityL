package com.agriculture.farmer.model;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.agriculture.farmer.model.Users;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class UserPrincipal implements UserDetails {
    private Users users;
    public UserPrincipal(Users user) {
        this.users=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(("ROLE_"+users.getRole())));
    }

    @Override
    public @Nullable String getPassword() {

        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }
}
