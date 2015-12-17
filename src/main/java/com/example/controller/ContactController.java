package com.example.controller;

import com.example.domain.Contact;
import com.example.service.ContactManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactManager contactManager;

    /**
     * define the service interactions here
     *
     * get all contacts
     * save a contact
     */

    @RequestMapping(method = RequestMethod.GET, path="/contacts")
    public List<Contact> listContacts() {

        return contactManager.listAllContacts();
    }


    @RequestMapping(method = RequestMethod.POST ,path = "/add")
    public Contact addContact(@RequestBody Contact contact) {

        return contactManager.addContact(contact);
    }

}
