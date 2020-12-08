package com.tyresshop.repository;

import com.tyresshop.entity.Tyres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TyresRepository extends JpaRepository<Tyres, Integer> {



}
