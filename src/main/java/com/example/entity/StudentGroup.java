package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student_groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"number"})})
@NamedQueries({
        @NamedQuery(name = "StudentGroup.findAll", query = "SELECT s FROM StudentGroup s"),
        @NamedQuery(name = "StudentGroup.findById", query = "SELECT s FROM StudentGroup s WHERE s.id = :id"),
        @NamedQuery(name = "StudentGroup.findByNumber", query = "SELECT s FROM StudentGroup s WHERE s.number = :number"),
        @NamedQuery(name = "StudentGroup.findByBegin", query = "SELECT s FROM StudentGroup s WHERE s.begin = :begin")})
public class StudentGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String number;
    private Date begin;
    private Set<Student> studentList;
    private Set<Course> courseList;
    //    private Set<HistoryOfLesson> historyOfLessonList;
    private Schedule schedule;
    private Trainer trainer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "number", nullable = false, length = 255)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "begin")
    @Temporal(TemporalType.DATE)
    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    @ManyToMany(mappedBy = "studentGroupList")
//    @JoinTable(name = "student_groups_has_students", joinColumns = {
//            @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
//            @JoinColumn(name = "student_groups_id", referencedColumnName = "id", nullable = false)})
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    @ManyToMany(mappedBy = "studentGroupList")
    public Set<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = courseList;
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentGroup")
//    public Set<HistoryOfLesson> getHistoryOfLessonList() {
//        return historyOfLessonList;
//    }
//
//    public void setHistoryOfLessonList(Set<HistoryOfLesson> historyOfLessonList) {
//        this.historyOfLessonList = historyOfLessonList;
//    }

    @JoinColumn(name = "schedules_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @JoinColumn(name = "trainers_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final StudentGroup other = (StudentGroup) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entity.StudentGroup[ id=" + id + " ]";
    }

}
