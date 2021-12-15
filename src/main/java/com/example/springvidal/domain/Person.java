package com.example.springvidal.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person__animal", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "animal_id", referencedColumnName = "id"))
    private List<Animal> animals = new ArrayList<>();

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", adress=" + adress +
                ", animals=" + animals +
                '}';
    }



    public Person(){

    }

    public Person(Long id, String firstname, String lastname, int age, Adress adress, List<Animal> animals) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.adress = adress;
        this.animals = animals;
    }

    public Person(String firstname, String lastname, int age, Adress adress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.adress = adress;
    }

    public Person(String firstname, String lastname, int age, Adress adress, List<Animal> animals) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.adress = adress;
        this.animals = animals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
