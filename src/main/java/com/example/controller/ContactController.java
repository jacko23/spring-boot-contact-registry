package com.example.controller;

import com.example.domain.Contact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    /**
     * define the service interactions here
     *
     * get all contacts
     * save a contact
     *
     * get a contact by firstname and lastname
     * get a contact by email address
     */

    @RequestMapping(method = RequestMethod.GET, path="/contacts")
    public Contact listContacts() {

        return null;
    }

    @RequestMapping(method = RequestMethod.PUT ,path = "/add")
    public Contact addContact(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName,
                              @RequestParam(value = "emailAddress") String emailAddress) {

        return null;

    }


}
