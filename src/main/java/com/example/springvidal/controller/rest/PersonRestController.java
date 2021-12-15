package com.example.springvidal.controller.rest;

import com.example.springvidal.domain.Person;
import com.example.springvidal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonRestController {
    @Autowired
    PersonService personService;

    @GetMapping("")
    public List<Person> init(Model model) {
        return personService.list();
    }
}
