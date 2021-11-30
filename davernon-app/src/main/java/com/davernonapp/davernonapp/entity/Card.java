package com.davernonapp.davernonapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "card_mind_set",
            joinColumns = @JoinColumn(name = "cardId"),
            inverseJoinColumns = @JoinColumn(name = "mindSetId"))
    private List<MindSet> mindSetList;
    @ManyToMany
    @JoinTable(
            name = "card_stance",
            joinColumns = @JoinColumn(name = "cardId"),
            inverseJoinColumns = @JoinColumn(name = "stanceId"))
    private List<Stance> stanceList;


    @Column
    private Integer speed;

    @Column
    private String description;
    @Column
    private Integer stamina;
    @Column
    private Integer playerVitalityModifier;
    @Column
    private Integer playerStaminaModifier;
    @Column
    private Integer enemyVitalityModifier;
    @Column
    private Integer enemyStaminaModifier;

    @Column
    private String descriptionBax;
    @Column
    private Integer staminaBax;
    @Column
    private Integer playerVitalityModifierBax;
    @Column
    private Integer playerStaminaModifierBax;
    @Column
    private Integer enemyVitalityModifierBax;
    @Column
    private Integer enemyStaminaModifierBax;
}
