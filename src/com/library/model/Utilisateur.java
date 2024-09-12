package com.library.model;

public abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;

    public Utilisateur(int id, String nom, String email) {
        this.id = id;
        this.nom = formatNom(nom); // Format the name upon construction
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = formatNom(nom); // Format the name when setting it
    }

    public String getEmail() {
        return email;
    }

    public abstract String getType();

    public abstract boolean peutEmprunter();

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Helper method to format the name correctly
    private String formatNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            return nom;
        }

        String[] parts = nom.trim().split("\\s+");
        StringBuilder formattedName = new StringBuilder();

        for (String part : parts) {
            if (!part.isEmpty()) {
                String capitalized = part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
                formattedName.append(capitalized).append(" ");
            }
        }

        return formattedName.toString().trim();
    }
}
