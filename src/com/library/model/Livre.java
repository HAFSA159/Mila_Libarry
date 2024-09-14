package com.library.model;

import com.library.dao.DocumentDAO;
import com.library.utilitaire.InputValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class Livre extends Document {
    private String isbn;

    public Livre() {
        super("", "", LocalDate.now());
        this.nombreDePages = 0;
        this.isbn = "";
    }



    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        super(titre, auteur, datePublication);
        this.nombreDePages = nombreDePages;
        this.isbn = isbn;
    }


    // Getter and Setter methods
    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void afficherDetails() {

    }

    public static void enterLivre(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for Livre:");
        System.out.print("Title: ");
        String livreTitre = scanner.nextLine();
        System.out.print("Author: ");
        String livreAuteur = scanner.nextLine();
        System.out.print("Publication Date (yyyy-mm-dd): ");
        LocalDate livreDatePublication = InputValidator.readDate();
        System.out.print("Number of Pages: ");
        int livreNombreDePages = InputValidator.getIntInput();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Livre livre = new Livre(livreTitre,livreAuteur,livreDatePublication,livreNombreDePages,isbn);


        DocumentDAO.ajouterLivre(livre);

    }

    public static void updateLivre() {
        Scanner scanner = new Scanner(System.in);

        // Demander l'ID du livre à modifier
        System.out.print("Saisir l'ID du livre à modifier : ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine()); // Convertir l'ID en entier
        } catch (NumberFormatException e) {
            System.out.println("L'ID doit être un entier valide.");
            return; // Arrêter l'exécution si l'ID n'est pas valide
        }

        // Créer un nouvel objet Livre pour la modification
        Livre livre = new Livre();

        // Saisir les nouvelles informations pour le livre
        System.out.print("Saisir le nouveau titre : ");
        livre.setTitre(scanner.nextLine());

        System.out.print("Saisir le nouvel auteur : ");
        livre.setAuteur(scanner.nextLine());

        System.out.print("Saisir la nouvelle date de publication (yyyy-mm-dd) : ");
        livre.setDatePublication(java.time.LocalDate.parse(scanner.nextLine()));

        System.out.print("Saisir le nouveau nombre de pages : ");
        livre.setNombreDePages(scanner.nextInt());
        scanner.nextLine(); // Consommer la nouvelle ligne restante

        System.out.print("Saisir le nouvel ISBN : ");
        livre.setIsbn(scanner.nextLine());

        // Appeler la méthode pour modifier le livre dans la base de données
        DocumentDAO.updateLivre(livre, id);
    }






}
