package com.employeemployee.converter;

import com.employeemployee.dto.ContactDTO;
import com.employeemployee.model.Contact;
import com.employeemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter extends Convertable<Contact, ContactDTO> {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    public Contact convertToEntity(ContactDTO dto) {
        return this.copyConvertToEntity(dto, new Contact());
    }

    public ContactDTO convertToDto(Contact entity) {
        if (entity == null) {
            return null;
        }
        ContactDTO dto = new ContactDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setEmployeeId(entity.getEmployee().getId());
        dto.setDto(employeeConverter.convertToDto(employeeRepository.findById(entity.getEmployee().getId()).orElse(null)));
        return dto;
    }

    @Override
    public Contact copyConvertToEntity(ContactDTO dto, Contact entity) {
        if (dto == null || entity == null) {
            return entity;
        }
        entity.setPhone(dto.getPhone());
        entity.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElse(null));
        return entity;
    }
}