package com.game.VO;

import com.fasterxml.jackson.annotation.JsonView;
import com.game.model.Rating;
import com.game.view.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class RatingVO extends ModelVO {

    @JsonView(Views.Public.class)
    private Float avgAttempt;

    @JsonView(Views.Public.class)
    private PlayerVO player;

    public RatingVO(Rating rating) {
        super(rating.getId());
        this.player = new PlayerVO(rating.getPlayer());
        if (rating.getAvgAttempt() != null) {
            this.avgAttempt =(float) Math.round(rating.getAvgAttempt() *10)/10;
        }
    }
}
