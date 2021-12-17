package com.davernonapp.davernonapp.repository;


import com.davernonapp.davernonapp.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

    public Optional<Privilege> findById(Integer id);


}
