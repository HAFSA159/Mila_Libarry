package com.library.model;

import java.time.LocalDate;

public class TheseUniversitaire extends Document {
    private int nombreDePages;
    private String universite;
    private String domaine;

    public TheseUniversitaire(String titre, String auteur, LocalDate datePublication, int nombreDePages, String universite, String domaine) {
        super(titre, auteur, datePublication);  // Calling the parent constructor
        this.nombreDePages = nombreDePages;
        this.universite = universite;
        this.domaine = domaine;
    }

    // Getter and Setter methods
    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }


    @Override
    public void afficherDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Date de Publication: " + getDatePublication());
        System.out.println("Nombre de Pages: " + nombreDePages);
        System.out.println("Université: " + universite);
        System.out.println("Domaine: " + domaine);
    }


}
