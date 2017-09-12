package com.example.controller;

import com.example.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/schedule/")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getRoot() {
        return "redirect:/schedule/index";
    }
    
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("scheduleList", scheduleRepository.findAll());
   
        return "schedules/schedule";
    }
}