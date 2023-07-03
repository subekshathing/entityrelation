package com.employeemployee.dto;

import java.util.UUID;

public class EmployeeDTO {
    private long id;
    private String name;
    private String email;
    private int age;
    private String designation;

    private DepartmentDTO dto;

    private long departmentId;

    public DepartmentDTO getDto() {
        return dto;
    }

    public void setDto(DepartmentDTO dto) {
        this.dto = dto;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long department) {
        this.departmentId = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                '}';
    }
}
