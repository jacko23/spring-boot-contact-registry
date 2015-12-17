package com.example.domain;

import com.example.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
//@TestPropertySource(locations="classpath:application-test.properties")
public class ContactRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    @Before
    public void setUp() {
        contactRepository.deleteAll();
    }

    @Test
    public void testAddContactSuccessful() {

        // add contact, confirm contact is added
        Contact contact = new Contact("Anna", "Smith", "anna.smith@gmail.com");
        contactRepository.save(contact);

        assertNotNull(contactRepository.findAll());
        assertEquals(1, contactRepository.findAll().size());
        assertEquals("Anna", contactRepository.findAll().get(0).getFirstName());
    }

    @Test
    public void testFindingAllContactsSuccessful() {

        // confirm all existing contacts are returned
        Contact contact1 = new Contact("Anna", "Smith", "anna.smith@gmail.com");
        contactRepository.save(contact1);

        Contact contact2 = new Contact("Richard", "jackson", "richard.jackson@gmail.com");
        contactRepository.save(contact2);

        assertNotNull(contactRepository.findAll());
        assertEquals(2, contactRepository.findAll().size());
        assertEquals("Anna", contactRepository.findAll().get(0).getFirstName());
        assertEquals("Smith", contactRepository.findAll().get(0).getLastName());
        assertEquals("anna.smith@gmail.com", contactRepository.findAll().get(0).getEmailAddress());
        assertEquals("Richard", contactRepository.findAll().get(1).getFirstName());
        assertEquals("jackson", contactRepository.findAll().get(1).getLastName());
        assertEquals("richard.jackson@gmail.com", contactRepository.findAll().get(1).getEmailAddress());
    }

}
