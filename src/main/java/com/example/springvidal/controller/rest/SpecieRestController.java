package com.example.springvidal.controller.rest;

import com.example.springvidal.domain.Specie;
import com.example.springvidal.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specie")
public class SpecieRestController {
    @Autowired
    SpecieService specieService;

    @GetMapping("")
    public List<Specie> init(Model model) {
        return specieService.list();
    }
    //@RequestBody : ce qu'il y a dans le body de la request post
    @PostMapping("")
    public Long create(@RequestBody Specie sp) {
        sp = specieService.create(sp);
        return sp.getId();
    }
    // update
    @PutMapping("/{theId}")
    public void update(@RequestBody Specie sp,@PathVariable("theId") long id) {
        sp.setId(id);
        specieService.update(sp);
    }
    // delete
    @DeleteMapping("/{theId}")
    public void delete(@PathVariable(name = "theId") long id) {
        specieService.delete(id);
    }

}
