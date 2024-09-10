package com.library.model;

public class Livre extends Document {
    private String isbn;
    private int nombrePages;

    public Livre(int id, String titre, String auteur, int anneePublication, String isbn, int nombrePages) {
        super(id, titre, auteur, anneePublication);
        this.isbn = isbn;
        this.nombrePages = nombrePages;
    }

    @Override
    public String getType() {
        return "Livre";
    }

    @Override
    public String toString() {
        return super.toString() + ", Livre{isbn='" + isbn + "', nombrePages=" + nombrePages + '}';
    }
}
