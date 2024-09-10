package com.library.model;

import java.time.LocalDate;

public abstract class Document {
    protected int id;
    protected String titre;
    protected String auteur;
    protected int anneePublication;
    protected boolean disponible;

    public Document(int id, String titre, String auteur, int anneePublication) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.disponible = true;
    }

    public abstract String getType(); // chaque sous-classe devra implémenter cette méthode

    public boolean isDisponible() {
        return disponible;
    }

    protected void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", anneePublication=" + anneePublication +
                ", disponible=" + disponible +
                '}';
    }
}
