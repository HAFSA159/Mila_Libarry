package com.library.model;

public class Magazine extends Document {
    private int numeroEdition;

    public Magazine(int id, String titre, String auteur, int anneePublication, int numeroEdition) {
        super(id, titre, auteur, anneePublication);
        this.numeroEdition = numeroEdition;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public String toString() {
        return super.toString() + ", Magazine{numeroEdition=" + numeroEdition + '}';
    }
}
