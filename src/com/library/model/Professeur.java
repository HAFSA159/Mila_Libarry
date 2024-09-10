package com.library.model;

public class Professeur extends Utilisateur {

    public Professeur(int id, String nom, String email) {
        super(id, nom, email);
    }

    @Override
    public String getType() {
        return "Professeur";
    }

    @Override
    public boolean peutEmprunter() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Professeur{}";
    }
}
