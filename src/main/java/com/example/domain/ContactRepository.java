package com.example.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByFirstName(String firstName);

    List<Contact> findByLastName(String lastName);

    List<Contact> findByEmailAddress(String emailAddress);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
