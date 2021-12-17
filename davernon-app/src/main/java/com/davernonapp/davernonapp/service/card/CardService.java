package com.davernonapp.davernonapp.service.card;

import com.davernonapp.davernonapp.entity.Card;
import com.davernonapp.davernonapp.exception.BadRequestException;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.repository.card.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository repository;

    public List<Card> getAll() {
        return repository.findAll();
    }

    public Card create(Card card) {
        if (card.getName() == null ||
                card.getDescription() == null ||
                card.getDescriptionBax() == null ||
                card.getSpeed() == null ||
                card.getStamina() == null ||
                card.getPlayerStaminaModifier() == null ||
                card.getPlayerVitalityModifier() == null ||
                card.getEnemyStaminaModifier() == null ||
                card.getEnemyVitalityModifier() == null
        ) {
            throw new BadRequestException("L'une des valeurs obligatoire est nulle.");
        }
        Card newCard = card;

//        Card newCard = new Card();
//        newCard.setName(card.getName());
//        newCard.setDescription(card.getDescription());
//        newCard.setDescriptionBax(card.getDescriptionBax());
//        newCard.setSpeed(card.getSpeed());
//        newCard.setStamina(card.getStamina());
        repository.save(newCard);
        return newCard;
    }

    public Card getById(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));
    }


    public Card update(Integer id, Card card) throws NotFoundException {
        if (card.getName() == null || card.getName().isEmpty()) {
            throw new BadRequestException("Input values can't be empty");
        }
        Card modifiedCard = repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));

        modifiedCard.setName(card.getName());
        modifiedCard.setDescription(card.getDescription());
        modifiedCard.setDescriptionBax(card.getDescriptionBax());
        modifiedCard.setSpeed(card.getSpeed());
        modifiedCard.setStamina(card.getStamina());

        modifiedCard.setPlayerVitalityModifier(card.getPlayerVitalityModifier());
        modifiedCard.setPlayerVitalityModifier(card.getPlayerVitalityModifier());
        modifiedCard.setEnemyVitalityModifier(card.getEnemyVitalityModifier());
        modifiedCard.setEnemyVitalityModifier(card.getEnemyStaminaModifier());
        repository.save(modifiedCard);
        return modifiedCard;
    }


    public ResponseEntity<String> delete(Integer id) throws NotFoundException {
        Card card = this.getById(id);
        repository.delete(card);
        return ResponseEntity.status(HttpStatus.OK).body("La carte " + card.getName() + " a bien été supprimé");
    }


}
