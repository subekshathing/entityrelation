package com.employeemployee.converter;

import com.employeemployee.dto.DepartmentDTO;
import com.employeemployee.dto.EmployeeDTO;
import com.employeemployee.model.Department;
import com.employeemployee.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter extends Convertable<Department, DepartmentDTO>{
    public Department convertToEntity(DepartmentDTO dto) {
        return this.copyConvertToEntity(dto,new Department());
    }
    public DepartmentDTO convertToDto(Department entity) {
        if(entity == null){
            return null;
        }
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(entity.getId());
        dto.setDep_name(entity.getDep_name());
        dto.setLocation(entity.getLocation());
        return dto;
    }

    @Override
    public Department copyConvertToEntity(DepartmentDTO dto, Department entity) {
        if(dto == null || entity == null) {
            return entity;
        }
//        entity.setId(dto.getId());
        entity.setDep_name(dto.getDep_name());
        entity.setLocation(dto.getLocation());
        return entity;
    }
}
