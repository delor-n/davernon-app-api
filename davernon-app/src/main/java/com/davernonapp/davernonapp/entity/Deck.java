package com.davernonapp.davernonapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Deck implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(
            name = "deck_card_relation",
            joinColumns = @JoinColumn(name = "DeckId"),
            inverseJoinColumns = @JoinColumn(name = "CardId"))
    private List<Card> CardList;
}
