/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "schedules", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"lesson_time"}),
        @UniqueConstraint(columnNames = {"weak_days"})})
@NamedQueries({
        @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
        @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
        @NamedQuery(name = "Schedule.findByWeakDays", query = "SELECT s FROM Schedule s WHERE s.weakDays = :weakDays"),
        @NamedQuery(name = "Schedule.findByLessonTime", query = "SELECT s FROM Schedule s WHERE s.lessonTime = :lessonTime")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String weakDays;
    private Date lessonTime;
    private List<StudentGroup> studentGroupList;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, String weakDays, Date lessonTime) {
        this.id = id;
        this.weakDays = weakDays;
        this.lessonTime = lessonTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "weak_days", nullable = false, length = 255)
    public String getWeakDays() {
        return weakDays;
    }

    public void setWeakDays(String weakDays) {
        this.weakDays = weakDays;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "lesson_time", nullable = false)
    @Temporal(TemporalType.TIME)
    public Date getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Date lessonTime) {
        this.lessonTime = lessonTime;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public void setStudentGroupList(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Schedule other = (Schedule) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entity.Schedule[ id=" + id + " ]";
    }

}
