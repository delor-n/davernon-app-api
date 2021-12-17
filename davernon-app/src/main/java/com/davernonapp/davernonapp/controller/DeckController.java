package com.davernonapp.davernonapp.controller;

import com.davernonapp.davernonapp.entity.Deck;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deck")
public class DeckController {


    @Autowired
    private DeckService deckService;

    @GetMapping
    public List<Deck> getAll() {
        return deckService.getAll();
    }

    @GetMapping("/{id}")
    public Deck getById(@PathVariable("id") Integer id) throws NotFoundException {
        return deckService.getById(id);
    }

    @PostMapping
    public Deck create(@RequestBody Deck deck) {
        return deckService.create(deck);
    }

    @PutMapping(path = "{id}")
    public Deck update(@PathVariable Integer id, @RequestBody Deck deck) throws NotFoundException {
        return deckService.update(id, deck);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return deckService.delete(id);
    }

}
