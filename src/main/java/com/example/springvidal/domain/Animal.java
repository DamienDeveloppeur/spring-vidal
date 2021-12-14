package com.example.springvidal.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name= "color")
    private String color;

    @Column(name = "sex")
    private String sex;

    @ManyToOne
    @JoinColumn(name = "id_specie")
    private Specie specie;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getColor() {return color;}

    public void setColor(String color) {this.color = color;}

    public String getSex() {return sex;}

    public void setSex(String sex) {this.sex = sex;}

    public Specie getSpecie() {return specie;}

    public void setSpecie(Specie specie) {this.specie = specie;}
}
