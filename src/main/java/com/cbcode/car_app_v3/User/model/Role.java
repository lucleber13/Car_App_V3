package com.cbcode.car_app_v3.User.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
@SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Integer id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
