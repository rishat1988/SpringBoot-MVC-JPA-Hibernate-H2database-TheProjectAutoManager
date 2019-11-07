package com.controllers.index;

//import com.itmo.spring.hello.model.User;
//import com.itmo.spring.hello.service.SecurityService;
//import com.itmo.spring.hello.service.UserService;
//import com.itmo.spring.hello.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {
    @GetMapping({"/"})
    public String welcome(Model model) {
        return "index";
    }
}
