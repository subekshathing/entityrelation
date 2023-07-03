package com.employeemployee.service;

import com.employeemployee.converter.ContactConverter;
import com.employeemployee.dto.ContactDTO;
import com.employeemployee.model.Contact;
import com.employeemployee.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ContactImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactConverter contactConverter;
    @Override
    public List<ContactDTO> getAllContact() {
        return contactConverter.convertToDtoList(contactRepository.findAll()) ;
    }

    @Override
    public ContactDTO saveCon(ContactDTO contactDTO) {

        return contactConverter.convertToDto(contactRepository.saveAndFlush(contactConverter.convertToEntity(contactDTO)));

    }

    @Override
    public ContactDTO getById(long id) {

        ContactDTO contactDTO= contactConverter.convertToDto(contactRepository.findById(id).orElse(null));
        return contactDTO;
    }
    @Override
    public ContactDTO updateCon(long id, ContactDTO contactDTO) {
        Contact contact=contactRepository.findById(id).orElse(null);
        ContactDTO dto= contactConverter.convertToDto(contactRepository.save(contactConverter.copyConvertToEntity(contactDTO ,contact)));
        return dto;
    }
    @Override
    public void deleteById(long id) {
        if(Objects.nonNull(id)){
            contactRepository.deleteById(id);
        }
    }


}