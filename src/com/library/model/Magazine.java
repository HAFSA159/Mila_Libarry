package com.library.model;

import com.library.dao.DocumentDAO;
import com.library.utilitaire.InputValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class Magazine extends Document {
    private String numero;

    public Magazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, String numero) {
        super(titre, auteur, datePublication);
        this.nombreDePages = nombreDePages;
        this.numero = numero;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public void afficherDetails() {

    }
    public static void enterMagazine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for Magazine:");
        System.out.print("Title: ");
        String magazineTitre = scanner.nextLine();
        System.out.print("Author: ");
        String magazineAuteur = scanner.nextLine();
        System.out.print("Publication Date (yyyy-mm-dd): ");
        LocalDate magazineDatePublication = InputValidator.readDate();
        System.out.print("Number of Pages: ");
        int magazineNombreDePages = InputValidator.getIntInput();
        System.out.print("Issue Number: ");
        String numero = scanner.nextLine();

        Magazine magazine = new Magazine(magazineTitre, magazineAuteur, magazineDatePublication, magazineNombreDePages, numero);

        DocumentDAO.addMagazine(magazine);
    }

    public static void updateMagazine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the Magazine to update: ");
        int id = InputValidator.getIntInput();

        System.out.println("Enter new details for the Magazine:");
        System.out.print("Title: ");
        String titre = scanner.nextLine();
        System.out.print("Author: ");
        String auteur = scanner.nextLine();
        System.out.print("Publication Date (yyyy-mm-dd): ");
        LocalDate datePublication = InputValidator.readDate();
        System.out.print("Number of Pages: ");
        int nombreDePages = InputValidator.getIntInput();
        System.out.print("Number: ");
        String numero = scanner.nextLine();

        Magazine magazine = new Magazine(titre, auteur, datePublication, nombreDePages, numero);
        magazine.setId(String.valueOf(id));

        DocumentDAO.updateMagazine(magazine);
    }


}
