package com.kueerickpatrick.plantinfo.entity;

import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

import static javax.persistence.AccessType.PROPERTY;

@Entity
@Table(name = "userplant")
public class Userplant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Access(value = PROPERTY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "userid")
    private User userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "plantid")
    private Plant plantid;

    public Userplant() {

    }

    public Userplant(User userid, Plant plantid) {
        this.userid = userid;
        this.plantid = plantid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Plant getPlantid() {
        return plantid;
    }

    public void setPlantid(Plant plantid) {
        this.plantid = plantid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userplant userplant = (Userplant) o;
        return Objects.equals(id, userplant.id) &&
                Objects.equals(userid, userplant.userid) &&
                Objects.equals(plantid, userplant.plantid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, plantid);
    }
}