package com.example;

import com.example.domain.ContactRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // same as  @Configuration @EnableAutoConfiguration @ComponentScan
@EnableJpaRepositories(basePackages = "com.example.domain")  // required if repository is in a different package
public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class);

    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}