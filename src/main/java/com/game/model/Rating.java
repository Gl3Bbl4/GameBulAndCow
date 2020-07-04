package com.game.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Rating extends IdentifiableObject{

    private Float avgAttempt;

    private boolean isСalculated;

    @OneToOne(cascade = CascadeType.ALL)
    private Player player;

    public Rating(Float avgAttempt, Player player, boolean isСalculated) {
        this.avgAttempt = avgAttempt;
        this.player = player;
        this.isСalculated = isСalculated;
    }
}
