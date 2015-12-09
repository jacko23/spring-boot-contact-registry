package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    /**
     * If you want access to the raw command line arguments, or you need to run some specific code
     * once the SpringApplication has started you can implement the CommandLineRunner interface.
     * The run(String…​ args) method will be called on all Spring beans implementing this interface.
     */
    public void run(String... strings) throws Exception {

       // System.err.println("Running this thing");

    }
}
