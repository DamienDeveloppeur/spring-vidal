package com.example.springvidal.service;

import com.example.springvidal.domain.Specie;
import com.example.springvidal.repository.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
// devient un objet spring
@Service
public class SpecieService {
    // autowired = instancie automatiquement une classe
    @Autowired
    SpecieRepository specierepo;

    public List<Specie> list(){
        return (List<Specie>)specierepo.findAll();
    }

    public Specie findbyId(Long id) {
        return this.specierepo.findById(id).orElse(null);
    }

    public Specie create(Specie specie){
        if (specie.getId() != null) {
            throw new RuntimeException("id de l'entité doit être null");
        }
        return this.specierepo.save(specie);
    }

    public Specie update(Specie specie) {
        return this.specierepo.save(specie);
    }

    public void delete(Long id) {
        this.specierepo.deleteById(id);
    }
}
