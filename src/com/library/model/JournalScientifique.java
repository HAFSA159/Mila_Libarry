package com.library.model;

import java.time.LocalDate;

public class JournalScientifique extends Document {
    private String domaineRecherche;

    public JournalScientifique(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String domaineRecherche) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.domaineRecherche = domaineRecherche;
    }

    @Override
    public void emprunter() {
        System.out.println("Le journal scientifique '" + titre + "' a été emprunté.");
    }

    @Override
    public void retourner() {
        System.out.println("Le journal scientifique '" + titre + "' a été retourné.");
    }

    @Override
    public void afficherDetails() {
        System.out.println("ID: " + id);
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Date de Publication: " + datePublication);
        System.out.println("Nombre de Pages: " + nombreDePages);
        System.out.println("Domaine de Recherche: " + domaineRecherche);
    }

    public String getDomaineRecherche() {
        return domaineRecherche;
    }

    public void setDomaineRecherche(String domaineRecherche) {
        this.domaineRecherche = domaineRecherche;
    }
}
