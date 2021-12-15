package com.example.springvidal;

import com.example.springvidal.domain.Animal;
import com.example.springvidal.domain.Person;
import com.example.springvidal.domain.Specie;
import com.example.springvidal.service.AnimalService;
import com.example.springvidal.service.PersonService;
import com.example.springvidal.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringVidalApplication implements CommandLineRunner {
    @Autowired
    SpecieService service;
    @Autowired
    AnimalService aniService;
    @Autowired
    PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(SpringVidalApplication.class, args);
    }
    private void printlist(){
        List<Person> list = personService.list();
        list.stream().forEach(s -> System.out.println(s));
        System.out.println("*******************");
    }
    @Override
    public void run(String... args) throws Exception {
        //printlist();
        //Specie sp = new Specie("grenouille", "grenouilletest");
        // String name, String color, String sex, Specie specie
        //service.create(sp);
        //Animal ani = new Animal("tigre", "tigré", "M", sp);

        //aniService.create(ani);
        //System.out.println(service.findbyId(sp.getId()));
        //printlist();
        //sp.setCommonName("JETROLLLOL");
        //service.update(sp);
        //printlist();
        //service.delete(sp.getId());
        //printlist();
    }
}
