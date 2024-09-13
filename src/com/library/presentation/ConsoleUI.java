package com.library.presentation;

import com.library.model.Bibliotheque;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);
    private Bibliotheque bibliotheque;

    public ConsoleUI(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
/*
    public void startMenu() {
        boolean continueRunning = true;
        while (continueRunning) {
            afficherMenu();
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    afficherMenuEtudiant();
                    break;
                case 2:
                    afficherMenuProfesseur();
                    break;
                case 3:
                    afficherMenuAdmin();
                    break;
                case 4:
                    continueRunning = false;
                    System.out.println("Fermeture du programme.");
                    break;
                default:
                    System.out.println("Choix non valide. Réessayez.");
            }
        }
    }

    private void afficherMenu() {
        System.out.println("************ Bienvenu à Mila Library ************");
        System.out.println("Veuillez vous identifier:");
        System.out.println("1. Étudiant");
        System.out.println("2. Professeur");
        System.out.println("3. Admin");
        System.out.println("4. Quitter");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Choisissez une option: ");
    }

    private void afficherMenuEtudiant() {
        boolean continueEtudiant = true;
        while (continueEtudiant) {
            System.out.println("************ MENU ÉTUDIANT ************");
            System.out.println("1. Emprunter un document");
            System.out.println("2. Retourner un document");
            System.out.println("3. Afficher tous les documents");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Quitter");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            int choix = getIntInput();

            switch (choix) {
                case 1:
                    // TODO: Implement emprunter document logic
                    break;
                case 2:
                    // TODO: Implement retourner document logic
                    break;
                case 3:
                    // TODO: bibliotheque.afficherTousLesDocuments();
                    break;
                case 4:
                    // TODO: Implement rechercher document logic
                    break;
                case 5:
                    continueEtudiant = false;
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix non valide. Réessayez.");
            }
        }
    }

    private void afficherMenuProfesseur() {
        // Similar to afficherMenuEtudiant, implement professor-specific options
    }

    private void afficherMenuAdmin() {
        boolean continueAdmin = true;
        while (continueAdmin) {
            System.out.println("************ MENU ADMIN ************");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Modifier un document");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Afficher tous les documents");
            System.out.println("5. Rechercher un document");
            System.out.println("6. Gérer les utilisateurs");
            System.out.println("7. Quitter");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            int choix = getIntInput();

            switch (choix) {
                case 1:
                    ajouterDocument();
                    break;
                case 2:
                    //modifierDocument();
                    break;
                case 3:
                    //supprimerDocument();
                    break;
                case 4:
                    // TODO: bibliotheque.afficherTousLesDocuments();
                    break;
                case 5:
                    // TODO: Implement rechercher document logic
                    break;
                case 6:
                    // TODO: Implement gérer les utilisateurs logic
                    break;
                case 7:
                    continueAdmin = false;
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix non valide.");
            }
        }
    }

    //*****************************************************

*/


}