package com.library.presentation;

import com.library.model.Bibliotheque;
import com.library.model.Livre;
import com.library.model.Magazine;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);
    private Bibliotheque bibliotheque;

    public ConsoleUI(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public void startMenu() {
        boolean continueRunning = true;
        while (continueRunning) {
            afficherMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                case 9:
                    continueRunning = false;
                    System.out.println("Fermeture du programme.");
                    break;
                default:
                    System.out.println("Choix non valide. Réessayez.");
            }
        }
    }

    private void afficherMenu() {
        System.out.println("************ Bienvenu a Mila Library ************");
        System.out.println("Veuillez vous identifier:");
        System.out.println("1. Étudiant");
        System.out.println("2. Professeur");
        System.out.println("3. Admin");
        System.out.println("9. Quitter");
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
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    // Implement emprunter document logic
                    break;
                case 2:
                    // Implement retourner document logic
                    break;
                case 3:
                    // Implement afficher tous les documents logic
                    break;
                case 4:
                    // Implement rechercher document logic
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
        boolean continueProfesseur = true;
        while (continueProfesseur) {
            System.out.println("************ MENU PROFESSEUR ************");
            System.out.println("1. Emprunter un document");
            System.out.println("2. Retourner un document");
            System.out.println("3. Afficher tous les documents");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Afficher les Thèses Universitaires");
            System.out.println("6. Afficher les Journaux Scientifiques");
            System.out.println("7. Quitter");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    // Implement emprunter document logic
                    break;
                case 2:
                    // Implement retourner document logic
                    break;
                case 3:
                    // Implement afficher tous les documents logic
                    break;
                case 4:
                    // Implement rechercher document logic
                    break;
                case 5:
                    // Implement afficher les Thèses Universitaires logic
                    break;
                case 6:
                    // Implement afficher les Journaux Scientifiques logic
                    break;
                case 7:
                    continueProfesseur = false;
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix non valide. Réessayez.");
            }
        }
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
                    //afficherTousLesDocuments();
                    break;
                case 9:
                    continueAdmin = false;
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix non valide.");
            }
        }
    }

    private void ajouterDocument() {
        System.out.println("You want to add:");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        int userChoice = scanner.nextInt();
        scanner.nextLine();

        if (userChoice == 1) {
            System.out.println("Enter details for Livre:");
            System.out.print("Title: ");
            String titre = scanner.nextLine();
            System.out.print("Author: ");
            String auteur = scanner.nextLine();
            System.out.print("Publication Date (yyyy-mm-dd): ");
            LocalDate datePublication = readDate(scanner);
            System.out.print("Number of Pages: ");
            int nombreDePages = scanner.nextInt();
            scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            bibliotheque.ajouterLivre(titre, auteur, datePublication, nombreDePages, isbn);
            System.out.println("Livre added successfully!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } else if (userChoice == 2) {
            System.out.println("Enter details for Magazine:");
            System.out.print("Title: ");
            String titre = scanner.nextLine();
            System.out.print("Author: ");
            String auteur = scanner.nextLine();
            System.out.print("Publication Date (yyyy-mm-dd): ");
            LocalDate datePublication = readDate(scanner);
            System.out.print("Number of Pages: ");
            int nombreDePages = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Issue Number: ");
            String numero = scanner.nextLine();

            bibliotheque.ajouterMagazine(titre, auteur, datePublication, nombreDePages, numero);
            System.out.println("Magazine added successfully!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } else {
            System.out.println("Invalid choice. Please choose again.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    private void modifierDocument() {
        System.out.println("Enter the title of the document you want to modify:");
        String titre = scanner.nextLine();
        Object document = bibliotheque.rechercherDocumentParTitre(titre);

        if (document != null) {
            System.out.println("Document found. What would you like to modify?");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. Publication Date");
            System.out.println("4. Number of Pages");
            if (document instanceof Livre) {
                System.out.println("5. ISBN");
            } else if (document instanceof Magazine) {
                System.out.println("5. Number");
            }
            int choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {
                System.out.print("Enter new title: ");
                String nouveauTitre = scanner.nextLine();
                if (document instanceof Livre) {
                    ((Livre) document).setTitre(nouveauTitre);
                } else if (document instanceof Magazine) {
                    ((Magazine) document).setTitre(nouveauTitre);
                }
                System.out.println("Title updated successfully.");
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Document not found.");
        }
    }

    private void supprimerDocument() {
        System.out.println("Enter the title of the document you want to delete:");
        String titre = scanner.nextLine();
        Object document = bibliotheque.rechercherDocumentParTitre(titre);

        if (document != null) {
            bibliotheque.supprimerDocument(titre);
            System.out.println("Document deleted successfully.");
        } else {
            System.out.println("Document not found.");
        }
    }


    private LocalDate readDate(Scanner scanner) {
        System.out.print("Enter date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        return LocalDate.parse(dateInput); // Parse date from string
    }
}
