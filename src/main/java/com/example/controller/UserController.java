package com.example.controller;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PreAuthorize(value = "ROLE_ADMIN")
@Secured(value = "ROLE_ADMIN")
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize(value = "ROLE_ADMIN")
    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getRoot() {
        return "redirect:/user/index";
    }

    @PreAuthorize(value = "ROLE_ADMIN")
    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "user/index";
    }

}
