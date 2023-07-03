package com.employeemployee.service;

import com.employeemployee.dto.EmployeeDTO;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {

    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO getById(long id);
    EmployeeDTO updateEmp(long id, EmployeeDTO employeeDTO);
    void deleteById(long id);
}