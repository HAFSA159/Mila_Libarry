package com.library.model;

import java.time.LocalDate;

public abstract class Document {
    private String id;
    private String titre;
    private String auteur;
    private LocalDate datePublication;

    public Document(String id, String titre, String auteur, LocalDate datePublication) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    // Abstract method or common method for all documents
    public abstract void afficherDetails();
}
