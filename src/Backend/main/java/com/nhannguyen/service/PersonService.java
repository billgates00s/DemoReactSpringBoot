package com.nhannguyen.service;

import com.nhannguyen.entities.Person;
import com.nhannguyen.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository repo;
    public List<Person> findAll() { return repo.findAll(); }
    public Person save(Person p) { return repo.save(p); }
}
