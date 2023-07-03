package com.employeemployee.dto;

public class ContactDTO {
    private long id;
    private int phone;
    private EmployeeDTO dto;
    private long EmployeeId;

    public EmployeeDTO getDto() {
        return dto;
    }

    public void setDto(EmployeeDTO dto) {
        this.dto = dto;
    }

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "id=" + id +
                ", phone=" + phone +
                '}';
    }
}