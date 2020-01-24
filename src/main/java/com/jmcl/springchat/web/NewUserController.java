package com.jmcl.springchat.web;

import com.jmcl.springchat.User;
import com.jmcl.springchat.data.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/newuser")
public class NewUserController {

    private final UserRepository userRepo;

    @Autowired
    public NewUserController(UserRepository uR) {
        userRepo = uR;
    }

    @GetMapping
    public String presentUserForm(Model model){
        model.addAttribute("user", new User(null, null));

        log.info(model.toString());

        return "newuser";
    }

    @PostMapping
    public String processNewUser(@Valid @ModelAttribute User user, Errors errors) {
        if (errors.hasErrors()){
            log.info(user.toString());
            return "newuser";
        }

        userRepo.save(user);
        log.info("i" + user.toString());

        return "newuser";
    }
}
