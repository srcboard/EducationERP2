package com.example.controller;

import com.example.entity.Theme;
import com.example.entity.Trainer;
import com.example.repo.ThemeRepository;
import com.example.repo.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/theme/")
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public String showAllThemes(Model model) {
        model.addAttribute("AllThemes", themeRepository.findAll());
        return "theme/theme-index";
    }

    @RequestMapping(path = "/add/", method = RequestMethod.GET)
    public String addNewTheme(Model model) {
        model.addAttribute("theme", new Theme());
        model.addAttribute("trainersAll", trainerRepository.findAll());
        return "/theme/theme-add";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String editTheme(@PathVariable Integer id, Model model) {
        model.addAttribute("theme", themeRepository.findOne(id));
        model.addAttribute("trainersAll", trainerRepository.findAll());
        return "/theme/theme-edit";
    }

    @RequestMapping(path = {"/edit/{id}", "/add/"}, method = RequestMethod.POST)
    public String saveThemeChanges(@Valid Theme theme,
                                   @RequestParam(value = "id", required = false) Integer id,
                                   @RequestParam(value = "trainersList", required = false) Set<Integer> trainersList,
                                   BindingResult bindingResult) {

        if (id == null || id == 0) {
            themeRepository.save(theme);
        }

        if (trainersList != null) {

            Set<Trainer> trainers = new HashSet<>();
            for (Trainer t : trainerRepository.findAll(trainersList)) {
                trainers.add(t);
            }
            theme.setTrainerList(trainers);

        }

        themeRepository.save(theme);
        return "redirect:/theme/index";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTheme(Theme theme, @PathVariable Integer id) {
        theme.setTrainerList(null);
        themeRepository.delete(theme);
        return "redirect:/theme/index";
    }

}
