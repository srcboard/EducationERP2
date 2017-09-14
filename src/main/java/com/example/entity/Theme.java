package com.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "themes")
public class Theme {
    private Integer id;
    private String name;
    private String description;
    private Set<Trainer> trainerList;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JoinTable(name = "trainers_has_themes", joinColumns = {
            @JoinColumn(name = "themes_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "trainers_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL)
    public Set<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(Set<Trainer> trainerList) {
        this.trainerList = trainerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theme that = (Theme) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
