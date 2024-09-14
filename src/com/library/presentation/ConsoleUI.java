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
        displayRoleMenu();
        displayMainMenu();
    }

    private void displayRoleMenu() {
        System.out.println("=== Select Role ===");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.println("3. Professor");
        System.out.print("Choose your role: ");
        int choice = InputValidator.getIntInput();

        switch (choice) {
            case 1:
                userRole = "Admin";
                break;
            case 2:
                userRole = "Student";
                break;
            case 3:
                userRole = "Professor";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Student.");
                userRole = "Student";
        }
    }

    private void displayMainMenu() {
        int choice;

        do {
            System.out.println("=== Main Menu (" + userRole + ") ===");

            if ("Admin".equals(userRole)) {
                displayAdminMenu();
            } else if ("Professor".equals(userRole)) {
                displayProfessorMenu();
            } else {
                displayStudentMenu();
            }

            System.out.print("Choose an option: ");
            choice = InputValidator.getIntInput();

            switch (choice) {
                case 1:
                    if ("Admin".equals(userRole)) {
                        addDocument();
                    } else {
                        borrowDocument();
                    }
                    break;
                case 2:
                    searchDocument();
                    break;
                case 3:
                    //listDocuments();
                    break;
                case 4:
                    if ("Admin".equals(userRole)) {
                        updateDocument();
                    } else if ("Professor".equals(userRole)) {
                        //reserveDocument();
                    } else {
                        System.out.println("Option not available for this role.");
                    }
                    break;
                case 5:
                    if ("Admin".equals(userRole)) {
                        deleteDocument();
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }

    private void displayAdminMenu() {
        System.out.println("1. Add a document");
        System.out.println("2. Search for a document");
        System.out.println("3. List all documents");
        System.out.println("4. Update a document");
        System.out.println("5. Delete a document");
        System.out.println("6. Exit");
    }

    private void displayProfessorMenu() {
        System.out.println("1. Borrow a document");
        System.out.println("2. Search for a document");
        System.out.println("3. List all documents");
        System.out.println("4. Reserve a document");
        System.out.println("5. Exit");
    }

    private void displayStudentMenu() {
        System.out.println("1. Borrow a document");
        System.out.println("2. Search for a document");
        System.out.println("3. List all documents");
        System.out.println("4. Reserve a document");
        System.out.println("5. Exit");
    }

    //CRUD DOC

    private void addDocument() {
        System.out.println("=== Add a Document ===");
        System.out.println("1. Add a Book");
        System.out.println("2. Add a Magazine");
        System.out.println("3. Add a Scientific Journal");
        System.out.println("4. Add a University Thesis");
        int choice = InputValidator.getIntInput();

        switch (choice) {
            case 1:
                Livre.enterBook();
                break;
            case 2:
                Magazine.enterMagazine();
                break;
            case 3:
                JournalScientifique.enterScientificJournal();
                break;
            case 4:
                TheseUniversitaire.enterUniversityThesis();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void updateDocument() {
        System.out.println("=== Update a Document ===");
        System.out.println("1. Update a Book");
        System.out.println("2. Update a Magazine");
        System.out.println("3. Update a Scientific Journal");
        System.out.println("4. Update a University Thesis");
        int choice = InputValidator.getIntInput();

        switch (choice) {
            case 1:
                Livre.updateBook();
                break;
            case 2:
                Magazine.updateMagazine();
                break;
            case 3:
                JournalScientifique.updateScientificJournal();
                break;
            case 4:
                TheseUniversitaire.updateUniversityThesis();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void deleteDocument() {
        System.out.println("=== Delete a Document ===");
        System.out.println("1. Delete a Book");
        System.out.println("2. Delete a Magazine");
        System.out.println("3. Delete a Scientific Journal");
        System.out.println("4. Delete a University Thesis");
        int choice = InputValidator.getIntInput();

        String type = "";
        switch (choice) {
            case 1:
                type = "book";
                break;
            case 2:
                type = "magazine";
                break;
            case 3:
                type = "scientific_journal";
                break;
            case 4:
                type = "university_thesis";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.print("Enter the ID of the document to delete: ");
        int id = InputValidator.getIntInput();

        DocumentDAO.deleteDocument(id, type);
    }

    private void searchDocument() {
        System.out.println("=== Search for a Document ===");
        System.out.print("Enter the title of the document to search for: ");
        String title = scanner.nextLine();

        DocumentDAO.searchDocument(title);
    }

    private void borrowDocument() {
        System.out.println("=== Borrow a Document ===");
        System.out.println("1. Borrow a Book");
        System.out.println("2. Borrow a Magazine");
        if ("Professor".equals(userRole)) {
            System.out.println("3. Borrow a Scientific Journal");
            System.out.println("4. Borrow a University Thesis");
        }
        int choice = InputValidator.getIntInput();

        String documentType = "";
        switch (choice) {
            case 1:
                documentType = "Livre";
                break;
            case 2:
                documentType = "Magazine";
                break;
            case 3:
                documentType = "JournalScientifique";
                break;
            case 4:
                documentType = "TheseUniversitaire";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.print("Enter the ID of the document to borrow: ");
        int documentId = InputValidator.getIntInput();

        // Call the method to borrow the document from the DAO
        boolean success = DocumentDAO.borrowDocument(documentId, documentType);
        if (success) {
            System.out.println("Document successfully borrowed.");
        } else {
            System.out.println("Failed to borrow the document. Please check the ID and try again.");
        }
    }

}
