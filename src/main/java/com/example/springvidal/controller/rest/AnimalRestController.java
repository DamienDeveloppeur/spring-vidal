package com.example.springvidal.controller.rest;

import com.example.springvidal.domain.Animal;
import com.example.springvidal.domain.Specie;
import com.example.springvidal.repository.AnimalRepository;
import com.example.springvidal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/animal")
public class AnimalRestController {
    @Autowired
    AnimalService animalService;

    @GetMapping("")
    public List<Animal> init(Model model) {
        return animalService.list();
    }
    // create
    //@RequestBody : ce qu'il y a dans le body de la request post
    @PostMapping("")
    public Long create(@RequestBody Animal sp) {
        sp = animalService.create(sp);
        return sp.getId();
    }
    // update
    @PutMapping("{id}")
    public Long update(@RequestBody Animal ani, @PathVariable("id") long id) {
        ani.setId(id);
        this.animalService.update(ani);
        return id;
    }
    @DeleteMapping("{id}")
    public Long delete(@PathVariable("id") long id) {
        this.animalService.delete(id);
        return id;
    }

}
