package com.example.controller;


import com.example.domain.Contact;
import com.example.service.ContactManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)

//use of the MockServletContext to set up an empty WebApplicationContext so the ContactController
// can be created in the @Before and passed to MockMvcBuilders.standaloneSetup().
// An alternative would be to create the full application context using the Application class and
// @Autowired the ContactController into the test.
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ContactControllerTest {

    //The MockMvc comes from Spring Test and allows you, via a set of convenient builder classes,
    // to send HTTP requests into the DispatcherServlet and make assertions about the result.
    private MockMvc mockMvc;

    @Mock
    private ContactManager contactManager;

    private ObjectMapper mapper;

    @InjectMocks
    private ContactController controllerUnderTest;


    @Before
    public void setUp() throws Exception {
        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
        mapper = new ObjectMapper();
    }

    @Test
    public void testAddContact() throws Exception {

        Contact contact = new Contact("Anna", "Smith", "anna.smith@gmail.com");

        //Object to JSON in String
        String contactObjJson = mapper.writeValueAsString(contact);

        when(contactManager.addContact(any(Contact.class))).thenReturn(contact);

        mockMvc.perform(post("/add")
            .content(contactObjJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andExpect(content().string(contactObjJson));
    }

    @Test
    public void testListContacts() throws Exception{

        Contact contactA = new Contact("Anna", "Smith", "anna.smith@gmail.com");
        Contact contactB = new Contact("Richard", "Jackson", "richar.jackson@gmail.com");
        Contact contactC = new Contact("Christopher", "Schnider", "chris.schnider@gmail.com");

        List<Contact> contactList = new ArrayList<Contact>();
        contactList.addAll(Arrays.asList(contactA, contactB, contactC));

        String contactListJsonArray = mapper.writeValueAsString(contactList);

        when(contactManager.listAllContacts()).thenReturn(contactList);

        mockMvc.perform(get("/contacts")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andExpect(content().string(contactListJsonArray));
    }

}
