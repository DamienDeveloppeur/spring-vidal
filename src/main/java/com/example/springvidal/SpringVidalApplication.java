package com.example.springvidal;

import com.example.springvidal.domain.Specie;
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
    public static void main(String[] args) {
        SpringApplication.run(SpringVidalApplication.class, args);
    }
    private void printlist(){
        List<Specie> list = service.list();
        list.stream().forEach(s -> System.out.println(s));
        System.out.println("*******************");
    }
    @Override
    public void run(String... args) throws Exception {
        printlist();
        Specie sp = new Specie("grenouille", "grenouilletest");
        service.create(sp);
        //System.out.println(service.findbyId(sp.getId()));
        printlist();
        //sp.setCommonName("JETROLLLOL");
        //service.update(sp);
        printlist();
        //service.delete(sp.getId());
        //printlist();
    }
}
