package com.example.service;

import com.example.domain.Contact;

import java.util.List;

public interface ContactManager {

    public Contact addContact(Contact contact);

    public List<Contact> listAllContacts();
}
