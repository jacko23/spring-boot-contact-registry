package com.example.service;

import com.example.domain.Contact;
import com.example.domain.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactManagerImpl implements ContactManager {

    @Autowired
    private ContactRepository contactRepository;

    public Contact addContact(Contact contact) {

        if (contact == null) {
            throw new IllegalArgumentException("Invalid Contact provided: NULL");
        }

        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> listAllContacts() {
        return contactRepository.findAll();
    }
}
