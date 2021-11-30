package com.davernonapp.davernonapp.repository.mindSet;

import com.davernonapp.davernonapp.entity.MindSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MindSetRepository extends JpaRepository<MindSet, Integer> {

    public Optional<MindSet> findById(Integer id);


}

