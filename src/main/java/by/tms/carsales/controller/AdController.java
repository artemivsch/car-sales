package by.tms.carsales.controller;

import by.tms.carsales.entity.User;
import by.tms.carsales.model.AddAdModel;
import by.tms.carsales.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;


@Controller("/ad")
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("/ad")
    public String ad(String id) {
        return "add_ad";

    }

    @GetMapping("/add_ad")
    public String reg(Model model) {
        model.addAttribute("newAd", new AddAdModel());
        model.addAttribute("models", adService.findAllModels());
        return "add_ad";
    }

    @PostMapping("/add_ad")
    public String reg(@Valid @ModelAttribute("newAd") AddAdModel newAd,
                      BindingResult bindingResult,
                      Model model,
                      HttpSession httpSession
    ) throws IOException {


        if (bindingResult.hasErrors()) {
            model.addAttribute("models", adService.findAllModels());
            return "/add_ad";
        }
        User currentUser = (User) httpSession.getAttribute("user");
        newAd.setUser(currentUser);
        adService.save(newAd);
        return "redirect:/";
    }

    @GetMapping("/")
    public String ads(Model model) {
        model.addAttribute("ads", adService.findAllAds());
        return "/index";
    }
}
