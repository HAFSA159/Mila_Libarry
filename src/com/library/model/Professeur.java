package com.library.model;

public class Professeur extends Utilisateur {
    private String departement;

    public Professeur(int id, String nom, String prenom, String departement) {
        super(id, nom, prenom);
        this.departement = departement;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
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
        return super.toString() + ", Professeur{" +
                "departement='" + departement + '\'' +
                '}';
    }
}
