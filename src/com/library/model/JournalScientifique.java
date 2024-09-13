package com.library.model;

import java.time.LocalDate;

public class JournalScientifique extends Document {
    private final String domaineRecherche;
    private int nombreDePages;

    public JournalScientifique(String titre, String auteur, LocalDate datePublication, int nombreDePages, String domaineRecherche) {
        super(titre, auteur, datePublication);
        this.nombreDePages = nombreDePages;
        this.domaineRecherche = domaineRecherche;
    }

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
        System.out.println("Domaine de Recherche: " + domaineRecherche);
    }

}
