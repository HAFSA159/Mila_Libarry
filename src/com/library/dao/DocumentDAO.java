package com.library.dao;

import com.library.model.Livre;
import resources.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocumentDAO {
   /* private void ajouterDocument() {
        System.out.println("You want to add:");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        System.out.println("3. Journal Scientifique");
        System.out.println("4. Thèse Universitaire");
        int userChoice = getIntInput();

        switch (userChoice) {
            case 1:

                break;

            case 2:
                System.out.println("Enter details for Magazine:");
                System.out.print("Title: ");
                String magazineTitre = scanner.nextLine();
                System.out.print("Author: ");
                String magazineAuteur = scanner.nextLine();
                System.out.print("Publication Date (yyyy-mm-dd): ");
                LocalDate magazineDatePublication = readDate();
                System.out.print("Number of Pages: ");
                int magazineNombreDePages = getIntInput();
                System.out.print("Issue Number: ");
                String numero = scanner.nextLine();

                bibliotheque.addMagazine(magazineTitre, magazineAuteur, magazineDatePublication, magazineNombreDePages, numero);
                System.out.println("Magazine added successfully!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;

            case 3:
                System.out.println("Enter details for Journal Scientifique:");
                System.out.print("Title: ");
                String journalTitre = scanner.nextLine();
                System.out.print("Author: ");
                String journalAuteur = scanner.nextLine();
                System.out.print("Publication Date (yyyy-mm-dd): ");
                LocalDate journalDatePublication = readDate();
                System.out.print("Number of Pages: ");
                int journalNombreDePages = getIntInput();
                System.out.print("Research Domain: ");
                String domaineRecherche = scanner.nextLine();

                bibliotheque.addJournalScientifique(journalTitre, journalAuteur, journalDatePublication, journalNombreDePages, domaineRecherche);
                System.out.println("Journal Scientifique added successfully!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;

            case 4:
                System.out.println("Enter details for Thèse Universitaire:");
                System.out.print("Title: ");
                String theseTitre = scanner.nextLine();
                System.out.print("Author: ");
                String theseAuteur = scanner.nextLine();
                System.out.print("Publication Date (yyyy-mm-dd): ");
                LocalDate theseDatePublication = readDate();
                System.out.print("Number of Pages: ");
                int theseNombreDePages = getIntInput();
                System.out.print("University: ");
                String universite = scanner.nextLine();
                System.out.print("Domain: ");
                String domaine = scanner.nextLine();

                bibliotheque.addTheseUniversitaire(theseTitre, theseAuteur, theseDatePublication, theseNombreDePages, universite, domaine);
                System.out.println("Thèse Universitaire added successfully!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;

            default:
                System.out.println("Invalid choice. Please choose again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;
        }
    }*/



    public static void ajouterLivre(Livre livre) {
        String query = "INSERT INTO livre (titre, auteur, date_de_publication, nombre_de_pages, isbn) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set values from the Livre object
            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(livre.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getIsbn()); // L'index est corrigé ici (de 7 à 5)

            // Exécuter l'insertion
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livre ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }




    public static void modifierLivre(Livre livre, int id) {
        String query = "UPDATE livre SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, isbn = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set values from the Livre object
            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(livre.getDatePublication()));
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getIsbn());

            // Set the ID of the book to modify
            stmt.setInt(6, id);

            // Exécuter la mise à jour
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
