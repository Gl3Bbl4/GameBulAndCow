package com.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Game extends IdentifiableObject {

    private Byte[] trueValue;

    private boolean isEnd;

    @ManyToOne()
    @JoinColumn
    private Player player;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private List<Attempt> attemptList;
}
