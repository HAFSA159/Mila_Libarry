package com.library.model;

public class JournalScientifique extends Document {
    private String domaineRecherche;

    public JournalScientifique(int id, String titre, String auteur, int anneePublication, String domaineRecherche) {
        super(id, titre, auteur, anneePublication);
        this.domaineRecherche = domaineRecherche;
    }

    @Override
    public String getType() {
        return "Journal Scientifique";
    }

    @Override
    public String toString() {
        return super.toString() + ", JournalScientifique{domaineRecherche='" + domaineRecherche + "'}";
    }
}
