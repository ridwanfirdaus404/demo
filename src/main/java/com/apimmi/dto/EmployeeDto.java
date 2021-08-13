package com.apimmi.dto;

import java.util.Date;

public class EmployeeDto {

    private String name;

    private Date birthDate;

    private int idNumber;

    private int gender;

    private Long position_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    // Employee employee;

    // List<Position> positionList;

    // public Employee getEmployee() {
    // return employee;
    // }

    // public void setEmployee(Employee employee) {
    // this.employee = employee;
    // }

    // public List<Position> getPositionList() {
    // return positionList;
    // }

    // public void setPositionList(List<Position> positionList) {
    // this.positionList = positionList;
    // }

}
