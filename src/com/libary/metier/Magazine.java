package com.libary.metier;

import java.time.LocalDate;

public class Magazine extends Document {
    private String isbn;

    public Magazine(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        this.id = String.valueOf(id);
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {
        System.out.println("Le Magazine " + titre + " a été emprunté.");
    }

    @Override
    public void retourner() {
        System.out.println("Le Magazine " + titre + " a été retourné.");
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine [ID: " + id + ", Titre: " + titre + ", Auteur: " + auteur + ", Date de Publication: " + datePublication + ", Nombre de Pages: " + nombreDePages + ", ISBN: " + isbn + "]");
    }
}

