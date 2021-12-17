package com.davernonapp.davernonapp.service;

import com.davernonapp.davernonapp.entity.Deck;
import com.davernonapp.davernonapp.exception.BadRequestException;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    @Autowired
    DeckRepository repository;

    public List<Deck> getAll() {
        return repository.findAll();
    }

    public Deck create(Deck deck) {
        if (deck.getName() == null) {
            throw new BadRequestException("L'une des valeurs obligatoire est nulle.");
        }

        repository.save(deck);
        return deck;
    }

    public Deck getById(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));
    }


    public Deck update(Integer id, Deck deck) throws NotFoundException {
        if (deck.getName() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Deck modifiedDeck = repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));

        modifiedDeck.setName(deck.getName());
        repository.save(modifiedDeck);
        return modifiedDeck;
    }


    public ResponseEntity<String> delete(Integer id) throws NotFoundException {
        Deck deck = this.getById(id);
        repository.delete(deck);
        return ResponseEntity.status(HttpStatus.OK).body("L'utilisateur " + deck.getName() + " a bien été supprimé");
    }


}
