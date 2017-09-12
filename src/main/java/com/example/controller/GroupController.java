package com.example.controller;

import com.example.entity.StudentGroup;
import com.example.repository.StudentGroupRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository groupRepository;

    @ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public String getRoot() {
        System.out.println("group--root");
        return "redirect:/group/index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam(name = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("group/grouplist");

        mav.addObject("groupList", groupRepository.findAll());

        return mav;
    }

//    @Secured({"ROLE_USER"})
    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView getGroup(StudentGroup group,
                                 @PathVariable Integer id) {

        ModelAndView mav = new ModelAndView("group/groupedit");
        mav.addObject("group", groupRepository.findOne(id));

        return mav;
    }

    @RequestMapping(path = "/addnew", method = RequestMethod.POST)
    public String addGroup(StudentGroup studentgroup) {
        studentgroup.setBegin(new Date());
        groupRepository.save(studentgroup);
        return "redirect:/group";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String postGroup(StudentGroup studentgroup) {
        return postGroup(-1, studentgroup);
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String postGroup(@PathVariable Integer id, StudentGroup studentgroup) {
        if (id == null || id < 0) {
            return addGroup(studentgroup);
        }
        groupRepository.save(studentgroup);
        return "redirect:/group";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String getDelete(StudentGroup group, @PathVariable Integer id) {

//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.update("DELETE FROM student_groups_has_students WHERE student_groups_id = " + group.getId());

        groupRepository.delete(group);
        return "redirect:/group";
    }

}
