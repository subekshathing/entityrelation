package com.employeemployee.service;

import com.employeemployee.converter.EmployeeConverter;
import com.employeemployee.dto.EmployeeDTO;
import com.employeemployee.model.Employee;
import com.employeemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeConverter employeeConverter;
    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeConverter.convertToDtoList(employeeRepository.findAll()) ;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {

            return employeeConverter.convertToDto(employeeRepository.save(employeeConverter.convertToEntity(employeeDTO)));


    }

    @Override
    public EmployeeDTO getById(long id) {

           EmployeeDTO employeeDTO= employeeConverter.convertToDto(employeeRepository.findById(id).orElse(null));
        return employeeDTO;
    }
    @Override
    public EmployeeDTO updateEmp(long id, EmployeeDTO employeeDTO){
        Employee employee=employeeRepository.findById(id).orElse(null);
        EmployeeDTO dto= employeeConverter.convertToDto(employeeRepository.save(employeeConverter.copyConvertToEntity(employeeDTO,employee)));
        return dto;
    }

    @Override
    public void deleteById(long id) {
if(Objects.nonNull(id)){
    employeeRepository.deleteById(id);
}
    }

  }


