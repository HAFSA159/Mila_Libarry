package com.library.presentation;

import com.library.model.Bibliotheque;
import com.library.model.Livre;
import com.library.model.Magazine;
import com.library.model.JournalScientifique;
import com.library.model.TheseUniversitaire;
import com.library.utilitaire.InputValidator;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);
    private Bibliotheque bibliotheque;
    private String userRole;

    public ConsoleUI(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public void startMenu() {
        afficherMenuRole();
        afficherMenuPrincipal();
    }

    private void afficherMenuRole() {
        System.out.println("=== Sélection du Rôle ===");
        System.out.println("1. Admin");
        System.out.println("2. Étudiant");
        System.out.println("3. Professeur");
        System.out.print("Choisissez votre rôle: ");
        int choix = InputValidator.getIntInput();

        switch (choix) {
            case 1:
                userRole = "Admin";
                break;
            case 2:
                userRole = "Étudiant";
                break;
            case 3:
                userRole = "Professeur";
                break;
            default:
                System.out.println("Choix invalide. Par défaut, vous êtes considéré comme Étudiant.");
                userRole = "Étudiant";
        }
    }

    private void afficherMenuPrincipal() {
        int choix;

        do {
            System.out.println("=== Menu Principal (" + userRole + ") ===");

            if ("Admin".equals(userRole)) {
                afficherMenuAdmin();
            } else if ("Professeur".equals(userRole)) {
                afficherMenuProfesseur();
            } else {
                afficherMenuEtudiant();
            }

            System.out.print("Choisissez une option: ");
            choix = InputValidator.getIntInput();

            switch (choix) {
                case 1:
                    if ("Admin".equals(userRole)) {
                        ajouterDocument();
                    } else {
                        //emprunterDocument();
                    }
                    break;
                case 2:
                   // rechercherDocument();
                    break;
                case 3:
                   // listerDocuments();
                    break;
                case 4:
                    if ("Admin".equals(userRole)) {
                        //supprimerDocument();
                    } else if ("Professeur".equals(userRole)) {
                       // reserverDocument();
                    } else {
                        System.out.println("Option non disponible pour ce rôle.");
                    }
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 5);
    }

    private void afficherMenuAdmin() {
        System.out.println("1. Ajouter un document");
        System.out.println("2. Rechercher un document");
        System.out.println("3. Lister tous les documents");
        System.out.println("4. Supprimer un document");
        System.out.println("5. Quitter");
    }

    private void afficherMenuProfesseur() {
        System.out.println("1. Emprunter un document");
        System.out.println("2. Rechercher un document");
        System.out.println("3. Lister tous les documents");
        System.out.println("4. Réserver un document");
        System.out.println("5. Quitter");
    }

    private void afficherMenuEtudiant() {
        System.out.println("1. Emprunter un document");
        System.out.println("2. Rechercher un document");
        System.out.println("3. Lister tous les documents");
        System.out.println("4. Quitter");
    }

    private void ajouterDocument() {
        System.out.println("=== Ajouter un Document ===");
        System.out.println("1. Ajouter un Livre");
        System.out.println("2. Ajouter un Magazine");
        System.out.println("3. Ajouter un Journal Scientifique");
        System.out.println("4. Ajouter une Thèse Universitaire");
        int choix = InputValidator.getIntInput();

        switch (choix) {
            case 1:
                Livre.enterLivre();
                break;
            case 2:
                Magazine.enterMagazine();
                break;
            case 3:
                JournalScientifique.enterJournalScientifique();
                break;
            case 4:
                TheseUniversitaire.enterTheseUniversitaire();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    /*private void emprunterDocument() {
        System.out.println("=== Emprunter un Document ===");
        System.out.print("Saisir le titre du document: ");
        String titre = scanner.nextLine();
        // Implement borrowing functionality here
        bibliotheque.emprunterDocument(titre, userRole);
    }

    private void reserverDocument() {
        System.out.println("=== Réserver un Document ===");
        System.out.print("Saisir le titre du document: ");
        String titre = scanner.nextLine();
        // Implement reservation functionality here
        bibliotheque.reserverDocument(titre, userRole);
    }

    private void rechercherDocument() {
        System.out.println("=== Rechercher un Document ===");
        System.out.print("Saisir le titre du document: ");
        String titre = scanner.nextLine();
        bibliotheque.rechercherDocumentParTitre(titre);  // Assuming the `Bibliotheque` class has this method.
    }

    private void listerDocuments() {
        System.out.println("=== Liste des Documents ===");
        bibliotheque.afficherTousLesDocuments();  // Assuming the `Bibliotheque` class has this method.
    }

    private void supprimerDocument() {
        System.out.println("=== Supprimer un Document ===");
        System.out.print("Saisir le titre du document à supprimer: ");
        String titre = scanner.nextLine();
        // Implement deletion functionality here
        bibliotheque.supprimerDocument(titre);
    }

     */
}
