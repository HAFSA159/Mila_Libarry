package com.library.model;

import java.time.LocalDate;

public class TheseUniversitaire extends Document {
    private String universite;
    private String domaine;

    public TheseUniversitaire(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String universite, String domaine) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.universite = universite;
        this.domaine = domaine;
    }

    @Override
    public void emprunter() {
        // Logic for borrowing the thesis
        System.out.println("La thèse universitaire '" + titre + "' a été empruntée.");
    }

    @Override
    public void retourner() {
        // Logic for returning the thesis
        System.out.println("La thèse universitaire '" + titre + "' a été retournée.");
    }

    @Override
    public void afficherDetails() {
        // Display the details of the thesis
        System.out.println("ID: " + id);
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Date de Publication: " + datePublication);
        System.out.println("Nombre de Pages: " + nombreDePages);
        System.out.println("Université: " + universite);
        System.out.println("Domaine: " + domaine);
    }

    // Getters and setters for universite and domaine if needed
    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
}
