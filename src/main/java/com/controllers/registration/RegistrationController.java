package com.controllers.registration;

import com.models.User;
import com.services.security.SecurityService;
import com.services.user.UserService;
import com.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationController {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;


    @GetMapping({"/login"})


    public String login(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.create(userForm);

        securityService.autoLogin(userForm.getUserName(), userForm.getPasswordConfirm());

        return "redirect:/auto/list";
    }

    @GetMapping("/signin")
    public String getSignIn(@NonNull Model model) {
        model.addAttribute("userForm", new User());
        return "signin";
    }

    @PostMapping("/signin")
    public String signIn(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validateUserAuth(userForm.getUserName(), userForm.getPassword(), bindingResult);
        if (bindingResult.hasErrors()) {
            return "signin";
        }
        securityService.autoLogin(userForm.getUserName(), userForm.getPassword());
        return "redirect:/auto/list";
    }

    @GetMapping("/logout")
    public String logout(@NonNull Model model) {
        return "redirect:/login";
    }
}
