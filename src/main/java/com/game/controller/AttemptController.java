package com.game.controller;

import com.game.service.AttemptService;
import com.game.status.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class AttemptController {
    private AttemptService attemptService;

    @PostMapping("/enterValue")
    public ModelAndView checkValueByPlayer(@RequestParam("value") String valuePlayer,
                                     @RequestParam("idGame") Long idGame,
                                     ModelMap model) {
        String error = null, gameIsEnd=null;

        Status statusAtt = attemptService.checkAnswer(valuePlayer, idGame);

        if(statusAtt == Status.WRONG) {
            error = "true";
        } else if(statusAtt == Status.IS_END) {
            gameIsEnd = "true";
        }

        model.addAttribute("error", error);
        model.addAttribute("gameIsEnd", gameIsEnd);
        model.addAttribute("idGame", idGame);
        return new ModelAndView("redirect:/game", model);
    }

}
