package com.example.controller;

import com.example.entity.Student;
import com.example.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/rest/student")
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Set<Student> getAllStudents() {

        Set<Student> allStudents = new HashSet<>();
        studentRepo.findAll().forEach((t) -> allStudents.add(t));
        return allStudents;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Student addStudent(@RequestParam(value = "name") String name,
                              @RequestParam(value = "surname", defaultValue = "--") String surname,
                              @RequestParam(value = "birthday", defaultValue = "01-01-0001") String birthday) throws ParseException {

        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setSurname(surname);
        newStudent.setBirthday(new SimpleDateFormat("MM-dd-yyyy").parse(birthday));
        studentRepo.save(newStudent);
        return newStudent;

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student) {

        studentRepo.save(student);
        return student;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Student deleteStudent(@PathVariable Integer id) throws Exception {

        studentRepo.delete(id);
        return new Student();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable Integer id) {
        return studentRepo.findOne(id);
    }

}
