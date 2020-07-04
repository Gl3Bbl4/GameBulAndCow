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
public class Attempt extends IdentifiableObject{

    private Byte[] value;

    private Byte colBul;

    private Byte colCow;

    @ManyToOne()
    @JoinColumn
    private Game game;

    public Attempt(Byte colBul, Byte colCow, Byte[] value) {
        this.colBul = colBul;
        this.colCow = colCow;
        this.value = value;
    }
}
