package com.example.springvidal.service;

import com.example.springvidal.domain.Person;
import com.example.springvidal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepo;

    public List<Person> list(){
        return (List<Person>) this.personRepo.findAll();
    }
}
