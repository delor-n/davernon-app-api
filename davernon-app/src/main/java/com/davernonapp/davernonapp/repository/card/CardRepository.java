package com.davernonapp.davernonapp.repository.card;

import com.davernonapp.davernonapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    public Optional<Card> findById(Integer id);


}

