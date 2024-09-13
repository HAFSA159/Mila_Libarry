package com.library.dao;

import com.library.model.JournalScientifique;
import com.library.model.Livre;
import com.library.model.Magazine;
import com.library.model.TheseUniversitaire;
import resources.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocumentDAO {

    public static void ajouterLivre(Livre livre) {
        String query = "INSERT INTO livre (titre, auteur, date_de_publication, nombre_de_pages, isbn) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(livre.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getIsbn()); // L'index est corrigé ici (de 7 à 5)

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livre ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }

    public static void ajouterMagazine(Magazine magazine) {
        String query = "INSERT INTO magazine (titre, auteur, date_de_publication, nombre_de_pages, numero) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(magazine.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setString(5, magazine.getNumero());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Magazine ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du magazine : " + e.getMessage());
        }
    }

    public static void ajouterJournalScientifique(JournalScientifique journalScientifique) {
        String query = "INSERT INTO journalscientifique (titre, auteur, date_de_publication, nombre_de_pages, domaine_recherche) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, journalScientifique.getTitre());
            stmt.setString(2, journalScientifique.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(journalScientifique.getDatePublication()));
            stmt.setInt(4, journalScientifique.getNombreDePages());
            stmt.setString(5, journalScientifique.getDomaineRecherche());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Journal Scientifique ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du Journal Scientifique : " + e.getMessage());
        }
    }

    public static void ajouterTheseUniversitaire(TheseUniversitaire theseUniversitaire) {
        String query = "INSERT INTO theseuniversitaire (titre, auteur, date_de_publication, nombre_de_pages, universite, domaine) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, theseUniversitaire.getTitre());
            stmt.setString(2, theseUniversitaire.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(theseUniversitaire.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            stmt.setInt(4, theseUniversitaire.getNombreDePages());
            stmt.setString(5, theseUniversitaire.getUniversite());
            stmt.setString(6, theseUniversitaire.getDomaine());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thèse Universitaire ajoutée avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la thèse universitaire : " + e.getMessage());
        }
    }

    public static void modifierLivre(Livre livre, int id) {
        String query = "UPDATE livre SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, isbn = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(livre.getDatePublication()));
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getIsbn());

            stmt.setInt(6, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Livre modifié avec succès !");
            } else {
                System.out.println("Aucun livre trouvé avec l'ID spécifié.");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du livre : " + e.getMessage());
        }
    }


}
