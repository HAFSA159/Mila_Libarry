package com.library.model;

public class Etudiant extends Utilisateur {

    public Etudiant(int id, String nom, String email) {
        super(id, nom, email);
    }

    @Override
    public String getType() {
        return "Etudiant";
    }

    @Override
    public boolean peutEmprunter() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Etudiant{}";
    }
}
