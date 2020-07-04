package com.game.controller;

import com.game.service.AttemptService;
import com.game.status.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class AttemptController {
    private AttemptService attemptService;

    @PostMapping("/enterValue")
    public String checkValueByPlayer(@RequestParam("value") String valuePlayer,
                                     @RequestParam("idGame") Long idGame,
                                     Model model) {
        Status statusAtt = attemptService.checkAnswer(valuePlayer, idGame);
        String error = null, gameIsEnd=null;
        if(statusAtt == Status.WRONG) {
            error = "Значение должно состоять из 4 чисел";
        } else if(statusAtt == Status.IS_END) {
            gameIsEnd = "Вы угадали! Начните новую игру.";
        }
        model.addAttribute("error", error);
        model.addAttribute("gameIsEnd", gameIsEnd);
        model.addAttribute("idGame", idGame);
        return "redirect:/game";
    }

}
