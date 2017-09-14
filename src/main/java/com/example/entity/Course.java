package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
        @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
        @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String description;
    private Set<Theme> themeList;
    private List<StudentGroup> studentGroupList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JoinTable(name = "courses_has_themes", joinColumns = {
            @JoinColumn(name = "courses_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "themes_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany()
    @OrderBy("name ASC")
    public Set<Theme> getThemeList() {
        return themeList;
    }

    public void setThemeList(Set<Theme> themeList) {
        this.themeList = themeList;
    }

    @JoinTable(name = "student_groups_has_courses", joinColumns = {
            @JoinColumn(name = "courses_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "student_groups_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany()
    @OrderBy("number ASC")
    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public void setStudentGroupList(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entity.Course[ id=" + id + " ]";
    }

}
