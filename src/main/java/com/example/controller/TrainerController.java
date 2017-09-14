package com.example.controller;

import com.example.entity.Theme;
import com.example.entity.Trainer;
import com.example.repo.ThemeRepository;
import com.example.repo.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/trainer/")
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private ThemeRepository themeRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Theme.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String id) throws IllegalArgumentException {
                setValue(themeRepository.findOne(Integer.parseInt(id)));
            }
        });
    }

//    @ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
//    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
//    public String getRoot() {
//        return "redirect:/trainer/index";
//    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView("trainers/index");
        mav.addObject("trainerList", trainerRepository.findAll());
        return mav;
    }

    @RequestMapping(path = "/add/", method = RequestMethod.GET)
    public ModelAndView getAdd() {
        ModelAndView mav = new ModelAndView("trainers/edit");
        mav.addObject("trainer", new Trainer());
        mav.addObject("themesAll", themeRepository.findAll());
        return mav;
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEdit(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("trainers/edit");
        mav.addObject("trainer", trainerRepository.findOne(id));
        mav.addObject("themesAll", themeRepository.findAll());
        return mav;
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String getDelete(Trainer trainer, @PathVariable Integer id) {

        trainer.setThemeList(null);
        trainerRepository.delete(trainer);

        return "redirect:/trainer/";
    }

    @RequestMapping(path = {"/edit/{id}", "/add/"}, method = RequestMethod.POST)
    public String postEdit(@Valid Trainer trainer,
                           @RequestParam(value = "id", required = false) Integer id,
                           @RequestParam(value = "themesList", required = false) Set<Integer> themesList) {

        if (id == null || id == 0) {
            trainerRepository.save(trainer);
        }

        if (themesList != null) {

            Set<Theme> themes = new HashSet<>();
            for (Theme group : themeRepository.findAll(themesList)) {
                themes.add(group);
            }
            trainer.setThemeList(themes);

        }

        trainerRepository.save(trainer);

        return "redirect:/trainer/";
    }

}
