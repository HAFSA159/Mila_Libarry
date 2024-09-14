package com.library.model;

import com.library.dao.DocumentDAO;
import com.library.utilitaire.InputValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class TheseUniversitaire extends Document {
    private String universite;
    private String domaine;

    public TheseUniversitaire(String titre, String auteur, LocalDate datePublication, int nombreDePages, String universite, String domaine) {
        super(titre, auteur, datePublication);
        this.nombreDePages = nombreDePages;
        this.universite = universite;
        this.domaine = domaine;
    }

    // Getter and Setter methods
    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public void afficherDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Date de Publication: " + getDatePublication());
        System.out.println("Nombre de Pages: " + nombreDePages);
        System.out.println("Université: " + universite);
        System.out.println("Domaine: " + domaine);
    }

    public static void enterUniversityThesis() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for Thèse Universitaire:");
        System.out.print("Title: ");
        String theseTitre = scanner.nextLine();
        System.out.print("Author: ");
        String theseAuteur = scanner.nextLine();
        System.out.print("Publication Date (yyyy-mm-dd): ");
        LocalDate theseDatePublication = InputValidator.readDate();
        System.out.print("Number of Pages: ");
        int theseNombreDePages = InputValidator.getIntInput();
        System.out.print("University: ");
        String universite = scanner.nextLine();
        System.out.print("Field of Study: ");
        String domaine = scanner.nextLine();

        TheseUniversitaire theseUniversitaire = new TheseUniversitaire(theseTitre, theseAuteur, theseDatePublication, theseNombreDePages, universite, domaine);

        DocumentDAO.addUniversityThesis(theseUniversitaire);
    }

    public static void updateUniversityThesis() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the Thèse Universitaire to update: ");
        int id = InputValidator.getIntInput();

        System.out.println("Enter new details for the Thèse Universitaire:");
        System.out.print("Title: ");
        String titre = scanner.nextLine();
        System.out.print("Author: ");
        String auteur = scanner.nextLine();
        System.out.print("Publication Date (yyyy-mm-dd): ");
        LocalDate datePublication = InputValidator.readDate();
        System.out.print("Number of Pages: ");
        int nombreDePages = InputValidator.getIntInput();
        System.out.print("University: ");
        String universite = scanner.nextLine();
        System.out.print("Field: ");
        String domaine = scanner.nextLine();

        TheseUniversitaire theseUniversitaire = new TheseUniversitaire(titre, auteur, datePublication, nombreDePages, universite, domaine);
        theseUniversitaire.setId(String.valueOf(id));

        DocumentDAO.updateTheseUniversitaire(theseUniversitaire);
    }

}
