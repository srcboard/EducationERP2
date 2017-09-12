package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
        @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
        @NamedQuery(name = "Student.findBySurname", query = "SELECT s FROM Student s WHERE s.surname = :surname"),
        @NamedQuery(name = "Student.findByBirthday", query = "SELECT s FROM Student s WHERE s.birthday = :birthday")})
@JsonIgnoreProperties({"studentGroupList","historyOfLessonList"})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String surname;
    private Date birthday;
    private Set<StudentGroup> studentGroupList;
//    private Set<HistoryOfLesson> historyOfLessonList;
//    private UserInfo userInfo;

    public Student() {}

    public Student(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Size(min = 2, max = 255, message = "\"Name\" field must be between 2 and 255 characters long")
    @Column(name = "name", length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(max = 255)
    @Column(name = "surname", length = 255)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JoinTable(name = "student_groups_has_students", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "student_groups_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public void setStudentGroupList(Set<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

//    @JoinTable(name = "students_has_history_of_lessons", joinColumns = {
//            @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
//            @JoinColumn(name = "history_of_lessons_id", referencedColumnName = "id", nullable = false)})
//    @ManyToMany()
//    public Set<HistoryOfLesson> getHistoryOfLessonList() {
//        return historyOfLessonList;
//    }

//    public void setHistoryOfLessonList(Set<HistoryOfLesson> historyOfLessonList) {
//        this.historyOfLessonList = historyOfLessonList;
//    }
    
//    @OneToOne
//    @JoinColumn(name = "userinfo_id")
//    public UserInfo getUserInfo() {
//        return userInfo;
//    }

//    public void setUserInfo(UserInfo userInfo) {
//        this.userInfo = userInfo;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + '}';
    }

}
