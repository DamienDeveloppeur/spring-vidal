package com.example.springvidal.service;

import com.example.springvidal.domain.Animal;
import com.example.springvidal.domain.Specie;
import com.example.springvidal.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepo;

    public List<Animal> list(){
        return (List<Animal>) animalRepo.findAll();
    }

    public Animal get(Long id) {
        return this.animalRepo.findById(id).orElse(null);
    }

    public Animal create(Animal animal){
        if (animal.getId() != null) {
            throw new RuntimeException("id de l'entité doit être null");
        }
        //specie = this.specierepo.save(specie);
        return this.animalRepo.save(animal);
    }

    public Animal update(Animal animal){
        if (animal.getId() == null) {
            throw new RuntimeException("id de l'entité ne doit pas être null");
        }
        return this.animalRepo.save(animal);
    }
    public void delete(Long id) {
        this.animalRepo.deleteById(id);
    }

}
