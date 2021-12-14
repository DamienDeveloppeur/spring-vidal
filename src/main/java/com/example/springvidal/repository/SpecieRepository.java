package com.example.springvidal.repository;

import com.example.springvidal.domain.Specie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecieRepository extends CrudRepository<Specie, Long> {

}
