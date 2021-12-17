package com.davernonapp.davernonapp.repository;


import com.davernonapp.davernonapp.entity.Stance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StanceRepository extends JpaRepository<Stance, Integer> {

    public Optional<Stance> findById(Integer id);


}
