package com.davernonapp.davernonapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class UserCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @ManyToMany
    @JoinTable(
            name = "user_card_deck_relation",
            joinColumns = @JoinColumn(name = "UserCardId"),
            inverseJoinColumns = @JoinColumn(name = "DeckId"))
    private List<Deck> DeckList;
}
