package com.library.model;

public class Etudiant extends Utilisateur {

    private String matricule;

    public Etudiant(int id, String nom, String prenom, String matricule) {
        super(id, nom, prenom);
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String getType() {
        return "Étudiant";
    }

    @Override
    public boolean peutEmprunter() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Etudiant{" +
                "matricule='" + matricule + '\'' +
                '}';
    }
}
