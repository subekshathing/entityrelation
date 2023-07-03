package com.employeemployee.converter;
import com.employeemployee.dto.EmployeeDTO;
import com.employeemployee.model.Employee;
import com.employeemployee.repository.DepartmentRepository;
import org.springframework.stereotype.Component;

import javax.xml.stream.Location;


@Component
public class EmployeeConverter extends Convertable<Employee, EmployeeDTO> {
    private final DepartmentConverter departmentConverter;

    private final DepartmentRepository departmentRepository;

    public EmployeeConverter(DepartmentConverter departmentConverter, DepartmentRepository departmentRepository) {
        this.departmentConverter = departmentConverter;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Employee convertToEntity(EmployeeDTO dto) {
        return this.copyConvertToEntity(dto,new Employee());
    }

    @Override
    public EmployeeDTO convertToDto(Employee entity) {
        if(entity == null){
            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAge(entity.getAge());
        dto.setDesignation(entity.getDesignation());
        dto.setDto(departmentConverter.convertToDto(departmentRepository.findById(entity.getDepartment().getId()).orElse(null)));
        if(entity.getDepartment()!=null) {
        dto.setDepartmentId(entity.getDepartment().getId());
        }

        return dto;
    }

    @Override
    public Employee copyConvertToEntity(EmployeeDTO dto, Employee entity) {
        if(dto == null || entity == null){
            return entity;
        }
//        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
        entity.setDesignation(dto.getDesignation());
//        entity.setDepartment(departmentConverter.convertToEntity(dto.getDto()));
        entity.setDepartment(departmentRepository.findById(dto.getDepartmentId()).orElse(null));
        return entity;
    }
}
