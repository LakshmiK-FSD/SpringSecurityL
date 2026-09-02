package com.agriculture.farmer.repository;

import com.agriculture.farmer.model.Farmers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmersRepo extends JpaRepository<Farmers,Integer> {
}
