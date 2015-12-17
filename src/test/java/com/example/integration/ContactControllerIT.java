package com.example.integration;

import com.example.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes=Application.class)
@IntegrationTest({"server.port=0"})
public class ContactControllerIT {

    @Value("${local.server.port}")
    private int port;

    private URL baseUrl;

    private RestTemplate clientTemplate;

    @Before
    public void setUp() throws Exception {

        this.baseUrl = new URL("http://localhost:" + this.port);
        this.clientTemplate = new TestRestTemplate();
    }

    public void testAdd() {



    }

    public void testContacts() {



    }





}
