package com.example.integration;

import com.example.Application;
import com.example.domain.Contact;
import com.example.domain.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes=Application.class)
@IntegrationTest({"server.port=0"})
public class ContactControllerIT {

    @Value("${local.server.port}")
    private int port;

    private URL baseUrl;

    private RestTemplate clientTemplate;

    private static final String addContactUrl = "/add";
    private static final String listContactsUrl = "/contacts";

    @Autowired
    ContactRepository contactRepository;

    @Before
    public void setUp() throws Exception {

        this.baseUrl = new URL("http://localhost:" + this.port);
        this.clientTemplate = new TestRestTemplate();
        contactRepository.deleteAll();
    }

    @Test
    public void testAddNullContact() {

        Contact contact = null;
        ResponseEntity<Contact> response = clientTemplate.postForEntity(baseUrl + addContactUrl, contact, Contact.class);
        assertEquals(response.getStatusCode(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }


    @Test
    public void testAddValidContact() {

        Contact contact = new Contact("Alex", "Wessley", "alex.w@gmail.com");
        ResponseEntity<Contact> response = clientTemplate.postForEntity(baseUrl + addContactUrl, contact, Contact.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals("Alex", response.getBody().getFirstName());
        assertEquals("Wessley", response.getBody().getLastName());
        assertEquals("alex.w@gmail.com", response.getBody().getEmailAddress());
    }

    @Test
    public void testContactsEmpty() {

        ResponseEntity<List> response = clientTemplate.getForEntity(baseUrl + listContactsUrl, List.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void testContactsReturned() {

        // add a few contacts here
        Contact contact1 = new Contact("Alex", "Wessley", "alex.w@gmail.com");
        Contact contact2 = new Contact("Jason", "Manson", "jason.m@gmail.com");
        Contact contact3 = new Contact("Paul", "Linders", "paul.l@gmail.com");

        clientTemplate.postForEntity(baseUrl + addContactUrl, contact1, Contact.class);
        clientTemplate.postForEntity(baseUrl + addContactUrl, contact2, Contact.class);
        clientTemplate.postForEntity(baseUrl + addContactUrl, contact3, Contact.class);

        ResponseEntity<List> response = clientTemplate.getForEntity(baseUrl + listContactsUrl, List.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        assertEquals(3, response.getBody().size());
    }

}
