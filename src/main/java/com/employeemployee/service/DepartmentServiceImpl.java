package com.employeemployee.service;

import com.employeemployee.converter.DepartmentConverter;
import com.employeemployee.dto.DepartmentDTO;
import com.employeemployee.dto.EmployeeDTO;
import com.employeemployee.model.Department;
import com.employeemployee.model.Employee;
import com.employeemployee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentConverter departmentConverter;
    @Override
    public List<DepartmentDTO> getAll() {
        return departmentConverter.convertToDtoList(departmentRepository.findAll()) ;
    }

    @Override
    public DepartmentDTO save(DepartmentDTO departmentDTO) {

        return departmentConverter.convertToDto(departmentRepository.saveAndFlush(departmentConverter.convertToEntity(departmentDTO)));

    }

    @Override
    public DepartmentDTO getById(long id) {

        DepartmentDTO departmentDTO= departmentConverter.convertToDto(departmentRepository.findById(id).orElse(null));
        return departmentDTO;
    }
    @Override
    public DepartmentDTO updateDep(long id, DepartmentDTO departmentDTO){
        Department department=departmentRepository.findById(id).orElse(null);
        DepartmentDTO dto= departmentConverter.convertToDto(departmentRepository.save(departmentConverter.copyConvertToEntity(departmentDTO,department)));
        return dto;
    }
    @Override
    public void deleteById(long id) {
        if(Objects.nonNull(id)){
            departmentRepository.deleteById(id);
        }
    }


}
