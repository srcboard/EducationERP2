package com.example.controller;

import com.example.entity.Course;
import com.example.entity.StudentGroup;
import com.example.entity.Theme;
import com.example.repo.CourseRepository;
import com.example.repo.StudentGroupRepository;
import com.example.repo.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;

@Controller
@RequestMapping("/course/")
public class CourseController {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private ThemeRepository themeRepo;

    @Autowired
    private StudentGroupRepository groupRepo;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Theme.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String id) throws IllegalArgumentException {
                setValue(themeRepo.findOne(Integer.parseInt(id)));
            }
        });

        binder.registerCustomEditor(StudentGroup.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String id) throws IllegalArgumentException {
                setValue(groupRepo.findOne(Integer.parseInt(id)));
            }
        });
    }

    @ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getRoot() {
        return "redirect:/course/index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("AllCourses", courseRepo.findAll());
        return "course/course-index";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String addNewTheme(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "course/course-add";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String editCourse(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseRepo.findOne(id));
        return "course/course-edit";
    }

    @RequestMapping(path = "/edit/{id}/save", method = RequestMethod.POST)
    public String saveChangesAfterEditing(@PathVariable Integer id,
                                          @Valid Course course,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "course/course-edit";
        }

        courseRepo.save(course);
        return "redirect:/course/index";
    }

    @RequestMapping(path = "/new/save", method = RequestMethod.POST)
    public String saveNewCourse(@Valid Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "course/course-edit";
        }

        courseRepo.save(course);
        return "redirect:/course/index";
    }

    @RequestMapping(path = "/edit/{id}/groups", method = RequestMethod.POST)
    public String addGroupsInCourseEdit(@PathVariable Integer id, Model model, Course course) {
        model.addAttribute("allGroups", groupRepo.findAll());
        model.addAttribute("course", course);
        model.addAttribute("addGroup", true);
        return "course/course-edit";
    }

    @RequestMapping(path = "/new/groups", method = RequestMethod.POST)
    public String addGroupsInNewCourse(Model model, Course course) {
        System.out.println(course.getStudentGroupList());
        model.addAttribute("allGroups", groupRepo.findAll());
        model.addAttribute("course", course);
        model.addAttribute("addGroup", true);
        return "course/course-add";
    }

    @RequestMapping(path = "/edit/{id}/themes", method = RequestMethod.POST)
    public String addThemesInCourseEdit(@PathVariable Integer id, Model model, Course course) {
        model.addAttribute("allThemes", themeRepo.findAll());
        model.addAttribute("course", course);
        model.addAttribute("addTheme", true);
        return "course/course-edit";
    }

    @RequestMapping(path = "/new/themes", method = RequestMethod.POST)
    public String addThemesInNewCourse(Model model, Course course) {
        model.addAttribute("allThemes", themeRepo.findAll());
        model.addAttribute("course", course);
        model.addAttribute("addTheme", true);
        return "course/course-add";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable Integer id) {
        courseRepo.delete(id);
        return "redirect:/course/index";
    }
}
