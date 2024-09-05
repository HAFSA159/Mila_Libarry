package com.libary.metier;

import java.time.LocalDate;

public abstract class Document {
    protected String id;
    protected String titre;
    protected String auteur;
    protected LocalDate datePublication;
    protected int nombreDePages;

    public abstract void emprunter();
    public abstract void retourner();
    public abstract void afficherDetails();


    public String getId() {
        return id;
    }
}

