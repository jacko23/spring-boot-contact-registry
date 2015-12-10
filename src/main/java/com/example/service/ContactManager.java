package com.example.service;

import com.example.domain.Contact;

public interface ContactManager {

    public Contact addContact(Contact contact);

    public Iterable<Contact> listAllContacts();
}
