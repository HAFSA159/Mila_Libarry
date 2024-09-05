package com.libary.metier;

import java.time.LocalDate;

public class Livre extends Document {
    private String isbn;

    public Livre(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        this.id = String.valueOf(id);
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {
        System.out.println("Le livre " + titre + " a été emprunté.");
    }

    @Override
    public void retourner() {
        System.out.println("Le livre " + titre + " a été retourné.");
    }

    @Override
    public void afficherDetails() {
        System.out.println("Livre [ID: " + id + ", Titre: " + titre + ", Auteur: " + auteur + ", Date de Publication: " + datePublication + ", Nombre de Pages: " + nombreDePages + ", ISBN: " + isbn + "]");
    }
}

