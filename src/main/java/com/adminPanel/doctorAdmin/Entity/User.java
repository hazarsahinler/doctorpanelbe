package com.adminPanel.doctorAdmin.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Talep> taleps;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Rapor> rapors;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Talep> getTaleps() {
        return taleps;
    }

    public void setTaleps(List<Talep> taleps) {
        this.taleps = taleps;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taleps=" + taleps +
                '}';
    }
}
