package com.game.controller;

import com.game.model.Player;
import com.game.service.PlayerService;
import com.game.status.Status;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
public class PlayerController {
    private PlayerService playerService;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("player", new Player());
        return "reg";
    }

//    @GetMapping("/")
//    public String login() {
//        return "login";
//    }

    @PostMapping("/reg")
    public String submitForm(@ModelAttribute("player") Player player, Model model) {
        Status statusReg = playerService.save(player);
        if (statusReg == Status.WRONG) {
            model.addAttribute("message", "Пользователь существует");
            return "reg";
        }
        return "login";
    }

    @GetMapping("/")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String message = null;
        if(error != null) {
            message = "Почта или пароль не корректны!";
        }
        if(logout != null) {
            message = "Вы успешно покинули свой аккаунт!";
        }
        model.addAttribute("message", message);
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }
}
