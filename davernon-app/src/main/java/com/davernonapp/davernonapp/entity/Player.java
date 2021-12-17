package com.davernonapp.davernonapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private UserCard userCard;
    @Column
    private String lifePoint;
    @Column
    private String staminaPoint;
    @Column
    private Stance stance;
    @Column
    private Stance MindSet;
}
