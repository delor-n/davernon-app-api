package com.davernonapp.davernonapp.repository;


import com.davernonapp.davernonapp.entity.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Integer> {

    public Optional<UserCard> findById(Integer id);


}
