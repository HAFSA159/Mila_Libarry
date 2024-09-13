package com.library.model;

import java.time.LocalDate;

public class Magazine extends Document {
    private int nombreDePages;
    private String numero;

    public Magazine(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String numero) {
        super(id, titre, auteur, datePublication);
        this.nombreDePages = nombreDePages;
        this.numero = numero;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public void afficherDetails() {

    }

}
