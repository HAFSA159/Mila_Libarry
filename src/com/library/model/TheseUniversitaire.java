package com.library.model;

public class TheseUniversitaire extends Document {
    private String universite;
    private String domaine;

    public TheseUniversitaire(int id, String titre, String auteur, int anneePublication, String universite, String domaine) {
        super(id, titre, auteur, anneePublication);
        this.universite = universite;
        this.domaine = domaine;
    }

    @Override
    public String getType() {
        return "Thèse Universitaire";
    }

    @Override
    public String toString() {
        return super.toString() + ", ThèseUniversitaire{universite='" + universite + "', domaine='" + domaine + "'}";
    }
}
