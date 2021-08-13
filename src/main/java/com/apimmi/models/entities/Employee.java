package com.apimmi.models.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "T2_EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "Nama is Required")
    private String name;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private java.util.Date birthDate;

    @Column(unique = true, nullable = false)

    private int idNumber;

    private int gender;

    private int isDelete;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee() {
    }

    public Employee(Long id, String name, Date birthDate, int idNumber, int gender, int isDelete) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.idNumber = idNumber;
        this.gender = gender;
        this.isDelete = isDelete;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.util.Date date) {
        this.birthDate = date;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
