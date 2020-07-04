package com.game.controller;

import com.game.model.Player;
import com.game.service.AttemptService;
import com.game.service.GameService;
import com.game.service.PlayerService;
import com.game.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class GameController {

    private GameService gameService;
    private AttemptService attemptService;
    private RatingService ratingService;

    @GetMapping("/new")
    public String startGame(@AuthenticationPrincipal Player player, Model model) {
        Long idGame = gameService.startNewGame(player);
        model.addAttribute("idGame", idGame);
        return "redirect:/game";
    }

    @GetMapping("/game")
    public String game(@RequestParam("idGame") Long idGame,
                       @RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "gameIsEnd", required = false) String gameIsEnd,
                       Model model) {
        model.addAttribute("idGame", idGame);
        model.addAttribute("error", error);
        model.addAttribute("gameIsEnd", gameIsEnd);
        model.addAttribute("stepList", attemptService.getAttemptListByGameId(idGame));
        model.addAttribute("ratingVOList",ratingService.findAllRatingList());
        return "index";
    }
}
