package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "trainers")
public class Trainer {
    private int id;
    private String name;
    private String surname;
    private String birthday;
    private Set<Theme> themeList;
    private Set<StudentGroup> studentGroupList;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Size(min = 2, max = 255)
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 2, max = 255)
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JoinTable(name = "trainers_has_themes", joinColumns = {
            @JoinColumn(name = "trainers_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "themes_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL)
    public Set<Theme> getThemeList() {
        return themeList;
    }

    public void setThemeList(Set<Theme> themeList) {
        this.themeList = themeList;
    }

    @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER)
    public Set<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public void setStudentGroupList(Set<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainer that = (Trainer) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trainer{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + '}';
    }

}
