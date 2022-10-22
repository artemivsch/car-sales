package by.tms.carsales.controller;

import by.tms.carsales.entity.User;
import by.tms.carsales.model.LoginUserModel;
import by.tms.carsales.model.RegistrationUserModel;
import by.tms.carsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("userModel", new User());
        return "reg";
    }

    @PostMapping("/test")
    public String test() {

        return "reg";
    }


    @PostMapping("/reg")
    public String reg(@Valid @ModelAttribute("userModel") RegistrationUserModel user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userModel", new LoginUserModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userModel") LoginUserModel userModel,
                        BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Optional<User> byUsername = userService.findByUsername(userModel.getUsername());
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            if (user.getPassword().equals(userModel.getPassword())) {
                session.setAttribute("currentUser", user);
                System.out.println(user.getName() + " login succ");
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password!");
                System.out.println("wrnog pwd");
            }
        } else {
            model.addAttribute("message", "User not found!");
            System.out.println("not found userModel");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
