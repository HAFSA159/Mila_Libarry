package com.library.model;

import java.time.LocalDate;

public class Livre extends Document {
    private int nombreDePages;
    private String isbn;

    public Livre(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        super(id, titre, auteur, datePublication);
        this.nombreDePages = nombreDePages;
        this.isbn = isbn;
    }

    // Getter and Setter methods
    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Override other methods if needed
}
