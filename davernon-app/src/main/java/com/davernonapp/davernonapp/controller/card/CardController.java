package com.davernonapp.davernonapp.controller.card;

import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.entity.Card;
import com.davernonapp.davernonapp.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {


    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAll() {
        return cardService.getAll();
    }

    @GetMapping("/{id}")
    public Card get(@PathVariable("id") Integer id) throws NotFoundException {
        return cardService.getCard(id);
    }

    @PostMapping
    public Card create(@RequestBody Card card) {
        return cardService.create(card);
    }

    @PutMapping(path = "{id}")
    public Card update(@PathVariable Integer id, @RequestBody Card card) throws NotFoundException {
        return cardService.editCard(id, card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return cardService.deleteCard(id);
    }

}
