package com.library.model;

import resources.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Bibliotheque {
    private Scanner scanner = new Scanner(System.in);


    public static void addLivre(Livre livre) {

        String sql = "INSERT INTO Livre (titre, auteur, date_de_publication, nombre_de_pages, isbn) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, Date.valueOf(livre.getDatePublication()));
            stmt.setInt(4, livre.getNombreDePages());

            String isbn = livre.getIsbn();

            if (isbn.length() > 13) {
                throw new IllegalArgumentException("L'ISBN dépasse la longueur maximale autorisée.");
            }
            stmt.setString(5, isbn);


            stmt.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erreur lors de l'ajout du livre : " + e.getMessage());

        }


    }

    public void addMagazine(String titre, String auteur, LocalDate datePublication, int nombrePages, String numero) {
        String query = "INSERT INTO magazine (titre, auteur, date_publication, nombre_pages, numero) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, titre);
            statement.setString(2, auteur);
            statement.setDate(3, java.sql.Date.valueOf(datePublication));
            statement.setInt(4, nombrePages);
            statement.setInt(5, Integer.parseInt(numero));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addJournalScientifique(String titre, String auteur, LocalDate datePublication, int nombrePages, String domaineRecherche) {
        String query = "INSERT INTO journal_scientifique (titre, auteur, date_publication, nombre_pages, universite) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, titre);
            statement.setString(2, auteur);
            statement.setDate(3, java.sql.Date.valueOf(datePublication));
            statement.setInt(4, nombrePages);
            statement.setString(5, domaineRecherche);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTheseUniversitaire(String titre, String auteur, LocalDate datePublication, int nombrePages, String universite, String domaine) {
        String query = "INSERT INTO these_universitaire (titre, auteur, date_publication, nombre_pages, universite, domaine) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, titre);
            statement.setString(2, auteur);
            statement.setDate(3, java.sql.Date.valueOf(datePublication));
            statement.setInt(4, nombrePages);
            statement.setString(5, universite);
            statement.setString(6, domaine);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }


}
