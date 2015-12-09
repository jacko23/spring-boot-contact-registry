package com.example;

import com.example.domain.Contact;
import com.example.domain.ContactRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // same as  @Configuration @EnableAutoConfiguration @ComponentScan
@EnableJpaRepositories(basePackages = "com.example.domain")  // required if repository is in a different package
public class Application implements CommandLineRunner{

    private static final Logger LOGGER = Logger.getLogger(Application.class);

    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {

        contactRepository.save(new Contact("Jack", "Bauer", "test@test.com"));
        contactRepository.save(new Contact("Chloe", "O'Brian", "test@test.com"));
        contactRepository.save(new Contact("Kim", "Bauer", "test@test.com"));
        contactRepository.save(new Contact("David", "Palmer", "test@test.com"));
        contactRepository.save(new Contact("Michelle", "Dessler", "test@test.com"));

        // fetch all customers
        LOGGER.info("Contacts found with findAll():");
        LOGGER.info("-------------------------------");
        for (Contact contact : contactRepository.findAll()) {
            LOGGER.info(contact.toString());
        }
        LOGGER.info("");

        // fetch an individual customer by ID
        Contact contact = contactRepository.findOne(1L);
        LOGGER.info("Contact found with findOne(1L):");
        LOGGER.info("--------------------------------");
        LOGGER.info(contact.toString());
        LOGGER.info("");

        // fetch customers by last name
        LOGGER.info("Customer found with findByLastName('Bauer'):");
        LOGGER.info("--------------------------------------------");
        for (Contact bauer : contactRepository.findByLastName("Bauer")) {
            LOGGER.info(bauer.toString());
        }
        LOGGER.info("");


    }
}