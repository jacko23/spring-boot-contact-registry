package com.example.service;

import com.example.domain.Contact;
import com.example.domain.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactManagerImpl implements ContactManager {

    @Autowired
    private ContactRepository contactRepository;

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Iterable<Contact> listAllContacts() {
        return contactRepository.findAll();
    }
}
