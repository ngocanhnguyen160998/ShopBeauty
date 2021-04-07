package com.shop.model.entity;

import com.shop.common.annotation.Column;
import com.shop.common.annotation.Entity;
import com.shop.common.annotation.Id;

import java.time.LocalDate;

@Entity(name = "EmailSubsribe")
public class EmailSubEntity {
    @Id(value = "Id_Email")
    private Integer id;
    @Column(value = "Email")
    private String email;
    @Column(value = "CreatedDate")
    private LocalDate createdDate;

    public EmailSubEntity(Integer id, String email, LocalDate createdDate) {
        this.id = id;
        this.email = email;
        this.createdDate = createdDate;
    }

    public EmailSubEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
