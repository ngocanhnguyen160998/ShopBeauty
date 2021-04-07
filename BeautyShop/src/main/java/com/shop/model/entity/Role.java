package com.shop.model.entity;

import com.shop.common.annotation.Column;
import com.shop.common.annotation.Entity;
import com.shop.common.annotation.Id;

@Entity(name = "role")
public class Role {
    @Id(value = "ID")
    private int id;
    @Column(value = "name")
    private String name;

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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
