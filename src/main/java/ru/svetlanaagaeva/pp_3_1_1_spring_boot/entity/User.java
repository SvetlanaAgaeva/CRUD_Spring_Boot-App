package ru.svetlanaagaeva.pp_3_1_1_spring_boot.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "users_crud")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surName;

    public User() {
    }

    public User(Integer id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

//    public Long getId() {
//        return id;
//    }
}
