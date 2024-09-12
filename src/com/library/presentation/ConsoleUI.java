package com.library.presentation;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        System.out.println("************ Bienvenu a Mila Library ************");
        System.out.println("Veuillez vous identifier:");
        System.out.println("1. Étudiant");
        System.out.println("2. Professeur");
        System.out.println("3. Admin");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Choisissez une option: ");
        int role = scanner.nextInt();
        scanner.nextLine();

        switch (role) {
            case 1:
                afficherMenuEtudiant();
                break;
            case 2:
                afficherMenuProfesseur();
                break;
            case 3:
                afficherMenuAdmin();
                break;
            default:
                System.out.println("Choix non valide. Réessayez.");
                startMenu();
        }
    }

    private void afficherMenuEtudiant() {
        System.out.println("************ MENU ÉTUDIANT ************");
        System.out.println("1. Emprunter un document");
        System.out.println("2. Retourner un document");
        System.out.println("3. Afficher tous les documents");
        System.out.println("4. Rechercher un document");
        System.out.println("5. Quitter");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void afficherMenuProfesseur() {
        System.out.println("************ MENU PROFESSEUR ************");
        System.out.println("1. Emprunter un document");
        System.out.println("2. Retourner un document");
        System.out.println("3. Afficher tous les documents");
        System.out.println("4. Rechercher un document");
        System.out.println("5. Afficher les Thèses Universitaires");
        System.out.println("6. Afficher les Journaux Scientifiques");
        System.out.println("7. Quitter");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void afficherMenuAdmin() {
        System.out.println("************ MENU ADMIN ************");
        System.out.println("1. Ajouter un document");
        System.out.println("2. Modifier un document");
        System.out.println("3. Supprimer un document");
        System.out.println("4. Afficher tous les documents");
        System.out.println("5. Rechercher un document");
        System.out.println("6. Afficher les Thèses Universitaires");
        System.out.println("7. Afficher les Journaux Scientifiques");
        System.out.println("8. Gérer les utilisateurs");
        System.out.println("9. Quitter");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                ajouterDocument();
                break;
            case 2:
                modifierDocument();
                break;
            case 3:
                supprimerDocument();
                break;
            case 4:
                afficherTousLesDocuments();
                break;
            case 9:
                System.out.println("Fermeture du programme.");
                break;
            default:
                System.out.println("Choix non valide.");
                afficherMenuAdmin();
        }
    }

    // CRUD for Admin
    private void ajouterDocument() {
        System.out.println("Ajout d'un nouveau document:");
        System.out.print("Entrez le titre: ");
        String titre = scanner.nextLine();
        System.out.print("Entrez l'auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Entrez l'année de publication: ");
        int anneePublication = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Document ajouté avec succès!");
    }

    private void modifierDocument() {
        System.out.print("Entrez l'ID du document à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Modification du document avec ID: " + id);
    }

    private void supprimerDocument() {
        System.out.print("Entrez l'ID du document à supprimer: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Document avec ID " + id + " supprimé.");
    }

    private void afficherTousLesDocuments() {
        System.out.println("Affichage de tous les documents:");
    }
}
