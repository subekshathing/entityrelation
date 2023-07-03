package com.employeemployee.service;

import com.employeemployee.dto.DepartmentDTO;
import com.employeemployee.repository.DepartmentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface DepartmentService {
    List<DepartmentDTO> getAll();
    DepartmentDTO save(DepartmentDTO departmentDTO);
    DepartmentDTO getById(long id);
    void deleteById(long id);

    DepartmentDTO updateDep(long id, DepartmentDTO departmentDTO);
}
