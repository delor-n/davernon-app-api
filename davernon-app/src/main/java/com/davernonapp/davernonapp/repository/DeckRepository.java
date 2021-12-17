package com.davernonapp.davernonapp.repository;


import com.davernonapp.davernonapp.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Integer> {

    public Optional<Deck> findById(Integer id);


}
