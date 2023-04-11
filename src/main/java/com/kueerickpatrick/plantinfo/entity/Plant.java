package com.kueerickpatrick.plantinfo.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Plant.
 */
@Entity(name = "Plant")
@Table(name = "plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "perenualid")
    private Integer perenualid;

    @OneToMany(mappedBy = "plantid",cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Userplant> userplants = new LinkedHashSet<>();

    /**
     * Instantiates a new Plant.
     */
    public Plant() {
    }

    /**
     * Instantiates a new Plant.
     *
     * @param perenualid the perenualid
     */
    public Plant(Integer perenualid) {
        this.perenualid = perenualid;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets perenualid.
     *
     * @return the perenualid
     */
    public Integer getPerenualid() {
        return perenualid;
    }

    /**
     * Sets perenualid.
     *
     * @param perenualid the perenualid
     */
    public void setPerenualid(Integer perenualid) {
        this.perenualid = perenualid;
    }

    /**
     * Gets userplants.
     *
     * @return the userplants
     */
    public Set<Userplant> getUserplants() {
        return userplants;
    }

    /**
     * Sets userplants.
     *
     * @param userplants the userplants
     */
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