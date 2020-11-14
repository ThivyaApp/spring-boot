package com.springboot.centreequestre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reprise")

public class Reprise {
    private long id;
    private String title;
    private String heure_deb;
    private String heure_fin;
    private int max_cavalier;
    private int niveau;

//horaire, de nombre maximum de cavalier, et du niveau enseigner (de 1 à 7 voir Galop) et optionnellement en ajoutant un titre
    public Reprise(){
    }

    public Reprise(String title,String heure_deb,String heure_fin, int max_cavalier, int niveau){
        this.title = title;
        this.heure_deb = heure_deb;
        this.heure_fin = heure_fin;
        this.max_cavalier = max_cavalier;
        this.niveau = niveau;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "heure_deb", nullable = false)
    public String getHeure_deb() {
        return heure_deb;
    }
    public void setHeure_deb(String heure_deb) {
        this.heure_deb = heure_deb;
    }

    @Column(name = "heure_fin", nullable = false)
    public String getHeure_fin() {
        return heure_fin;
    }
    public void setHeure_fin(String heure_fin) { this.heure_fin = heure_fin;}

    @Column(name = "max_cavalier", nullable = false)
    public int getMax_cavalier() {
        return max_cavalier;
    }
    public void setMax_cavalier(int max_cavalier) {
        this.max_cavalier = max_cavalier;
    }

    @Column(name = "niveau", nullable = false)
    public int getNiveau() {
        return niveau;
    }
    public void setNiveau(int niveau) { this.niveau = niveau;}

}
