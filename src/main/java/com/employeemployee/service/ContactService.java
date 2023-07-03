package com.employeemployee.service;

import com.employeemployee.dto.ContactDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ContactService {
    List<ContactDTO> getAllContact();
    ContactDTO saveCon(ContactDTO contactDTO);
    ContactDTO getById(long id);
    ContactDTO updateCon(long id, ContactDTO dto);
    void deleteById(long id);
}