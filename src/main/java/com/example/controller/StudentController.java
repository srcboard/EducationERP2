package com.example.controller;

import com.example.entity.Student;
import com.example.entity.StudentGroup;
import com.example.repository.StudentGroupRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository groupRepository;

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(StudentGroup.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String id) throws IllegalArgumentException {
//                setValue(groupRepository.findOne(Integer.parseInt(id)));
//            }
//        });
//    }

    @ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public String getRoot() {
        return "redirect:/student/index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView("student/student-index-vue");
        mav.addObject("studentList", studentRepository.findAll());
        return mav;
    }

    @RequestMapping(path = "/add/", method = RequestMethod.GET)
    public ModelAndView getAdd() {
        ModelAndView mav = new ModelAndView("student/edit");
        mav.addObject("student", new Student());
        mav.addObject("groupsAll", groupRepository.findAll());
        return mav;
    }

//    @RequestMapping(path = "/add/", method = RequestMethod.POST)
//    public String postAdd(Student student) {
//        studentRepository.save(student);
//        return "redirect:/student/";
//    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView openForEdit(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("student/edit");
        mav.addObject("student", studentRepository.findOne(id));
        mav.addObject("groupsAll", groupRepository.findAll());
        return mav;
    }

    @RequestMapping(path = {"/edit/{id}", "/add/"}, method = RequestMethod.POST)
    public String sendToSave(Student student,
                             @RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "studentGroupsList", required = false) Set<Integer> studentGroupsList) {

        if (id == null || id == 0) {
            studentRepository.save(student);
        }

        if (studentGroupsList != null) {

            Set<StudentGroup> set = new HashSet<>();
            for (StudentGroup group : groupRepository.findAll(studentGroupsList)) {
                set.add(group);
            }
            student.setStudentGroupList(set);

        }

        studentRepository.save(student);

        return "redirect:/student/";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String sendToRemove(Student student, @PathVariable Integer id) {

        studentRepository.delete(student);

        return "redirect:/student/";
    }

//    @ExceptionHandler
//    public void handleException(Exception ex) {
//        ex.printStackTrace();
//    }

}
