package com.codegym.customerprovince.model;

import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(targetEntity = User.class)
    private List<User> users;


    public Province(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public Province() {

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
