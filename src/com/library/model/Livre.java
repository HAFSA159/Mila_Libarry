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

    public static void enterBook(){

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


        DocumentDAO.addBook(livre);

    }

    public static void updateBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Saisir l'ID du livre à modifier : ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("L'ID doit être un entier valide.");
            return;
        }

        Livre livre = new Livre();

        System.out.print("Saisir le nouveau titre : ");
        livre.setTitre(scanner.nextLine());

        System.out.print("Saisir le nouvel auteur : ");
        livre.setAuteur(scanner.nextLine());

        System.out.print("Saisir la nouvelle date de publication (yyyy-mm-dd) : ");
        livre.setDatePublication(java.time.LocalDate.parse(scanner.nextLine()));

        System.out.print("Saisir le nouveau nombre de pages : ");
        livre.setNombreDePages(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Saisir le nouvel ISBN : ");
        livre.setIsbn(scanner.nextLine());

        DocumentDAO.updateLivre(livre, id);
    }






}
