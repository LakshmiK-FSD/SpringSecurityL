package com.agriculture.farmer.repository;

import com.agriculture.farmer.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{
    Users getByUsername(String username);
}
