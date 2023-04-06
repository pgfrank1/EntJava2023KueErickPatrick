package com.kueerickpatrick.plantinfo.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Plant")
@Table(name = "plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "perenualid")
    private Integer perenualid;

    @OneToMany(mappedBy = "plantid")
    private Set<Userplant> userplants = new LinkedHashSet<>();

    public Plant() {
    }

    public Plant(Integer perenualid) {
        this.perenualid = perenualid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerenualid() {
        return perenualid;
    }

    public void setPerenualid(Integer perenualid) {
        this.perenualid = perenualid;
    }

    public Set<Userplant> getUserplants() {
        return userplants;
    }

    public void setUserplants(Set<Userplant> userplants) {
        this.userplants = userplants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return id.equals(plant.id) &&
                perenualid.equals(plant.perenualid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, perenualid);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", perenualid=" + perenualid +
                '}';
    }
}