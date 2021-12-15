package com.example.springvidal.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name = "code")
    private String code;

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }

    @Column(name = "rue")
    private String rue;

    @Column(name = "ville")
    private String ville;
    public Adress(){

    }
    public Adress(String code, String rue, String ville) {
        this.code = code;
        this.rue = rue;
        this.ville = ville;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
