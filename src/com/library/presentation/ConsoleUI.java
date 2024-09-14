package com.library.presentation;

import com.library.dao.DocumentDAO;
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
                    rechercherDocument();
                    break;
                case 3:
                    //listerDocuments();
                    break;
                case 4:
                    if ("Admin".equals(userRole)) {
                        updateDocument();
                    } else if ("Professeur".equals(userRole)) {
                        //reserverDocument();
                    } else {
                        System.out.println("Option non disponible pour ce rôle.");
                    }
                    break;
                case 5:
                    if ("Admin".equals(userRole)) {
                        deleteDocument();
                    }
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 6);
    }

    private void afficherMenuAdmin() {
        System.out.println("1. Ajouter un document");
        System.out.println("2. Rechercher un document");
        System.out.println("3. Lister tous les documents");
        System.out.println("4. Mettre à jour un document");
        System.out.println("5. Supprimer un document");
        System.out.println("6. Quitter");
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
        System.out.println("4. Réserver un document");
        System.out.println("5. Quitter");
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

    private void updateDocument() {
        System.out.println("=== Mettre à jour un Document ===");
        System.out.println("1. Mettre à jour un Livre");
        System.out.println("2. Mettre à jour un Magazine");
        System.out.println("3. Mettre à jour un Journal Scientifique");
        System.out.println("4. Mettre à jour une Thèse Universitaire");
        int choix = InputValidator.getIntInput();

        switch (choix) {
            case 1:
                Livre.updateLivre();
                break;
            case 2:
                Magazine.updateMagazine();
                break;
            case 3:
                JournalScientifique.updateJournalScientifique();
                break;
            case 4:
                TheseUniversitaire.updateTheseUniversitaire();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    private void deleteDocument() {
        System.out.println("=== Supprimer un Document ===");
        System.out.println("1. Supprimer un Livre");
        System.out.println("2. Supprimer un Magazine");
        System.out.println("3. Supprimer un Journal Scientifique");
        System.out.println("4. Supprimer une Thèse Universitaire");
        int choix = InputValidator.getIntInput();

        String type = "";
        switch (choix) {
            case 1:
                type = "livre";
                break;
            case 2:
                type = "magazine";
                break;
            case 3:
                type = "journal_scientifique";
                break;
            case 4:
                type = "these_universitaire";
                break;
            default:
                System.out.println("Choix invalide.");
                return;
        }

        System.out.print("Entrez l'ID du document à supprimer: ");
        int id = InputValidator.getIntInput();

        DocumentDAO.supprimerDocument(id, type);
    }

    private void rechercherDocument() {
        System.out.println("=== Rechercher un Document ===");
        System.out.print("Entrez le titre du document à rechercher: ");
        String titre = scanner.nextLine();

        DocumentDAO.rechercherDocument(titre);
    }




}
