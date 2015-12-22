package com.example;

import com.example.domain.Contact;
import com.example.service.ContactManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    @Autowired
    ContactManager contactManager;


    /**
     * If you want access to the raw command line arguments, or you need to run some specific code
     * once the SpringApplication has started you can implement the CommandLineRunner interface.
     * The run(String…​ args) method will be called on all Spring beans implementing this interface.
     */
    public void run(String... strings) throws Exception {

        contactManager.addContact(new Contact("Jack", "Bauer", "test@test.com"));
        contactManager.addContact(new Contact("Chloe", "O'Brian", "test@test.com"));
        contactManager.addContact(new Contact("Kim", "Bauer", "test@test.com"));
        contactManager.addContact(new Contact("David", "Palmer", "test@test.com"));
        contactManager.addContact(new Contact("Michelle", "Dessler", "test@test.com"));

        // fetch all customers
        LOGGER.info("Contacts found with findAll():");
        LOGGER.info("-------------------------------");
        for (Contact contact : contactManager.listAllContacts()) {
            LOGGER.info(contact.toString());
        }
        LOGGER.info("");





        // fetch an individual customer by ID
     /*   Contact contact = contactManager.findOne(1L);
        LOGGER.info("Contact found with findOne(1L):");
        LOGGER.info("--------------------------------");
        LOGGER.info(contact.toString());
        LOGGER.info("");

        // fetch customers by last name
        LOGGER.info("Customer found with findByLastName('Bauer'):");
        LOGGER.info("--------------------------------------------");
        for (Contact bauer : contactManager.findByLastName("Bauer")) {
            LOGGER.info(bauer.toString());
        }
        LOGGER.info("");

      */
    }
}
