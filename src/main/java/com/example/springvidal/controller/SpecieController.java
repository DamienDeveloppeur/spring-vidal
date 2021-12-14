package com.example.springvidal.controller;

import com.example.springvidal.domain.Specie;
import com.example.springvidal.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpecieController {
    @Autowired
    SpecieService specieService;

    @Transactional
    @GetMapping("/")
    public String init(Model model){
        List<Specie> sps = specieService.list();
        // on renverra la variable, comme pour symfo
        model.addAttribute("species", sps);
        return "list_specie";
    }

    @Transactional
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") long id){
        System.out.println(id);
        specieService.delete(id);
        return "redirect:/";
    }


}
