package com.library.model;

import com.library.dao.DocumentDAO;
import com.library.utilitaire.InputValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class JournalScientifique extends Document {
    private String domaineRecherche;

    public JournalScientifique(String titre, String auteur, LocalDate datePublication, int nombreDePages, String domaineRecherche) {
        super(titre, auteur, datePublication);
        this.nombreDePages = nombreDePages;
        this.domaineRecherche = domaineRecherche;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public String getDomaineRecherche() {
        return domaineRecherche;
    }

    public void setDomaineRecherche(String domaineRecherche) {
        this.domaineRecherche = domaineRecherche;
    }

    @Override
    public void afficherDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Date de Publication: " + getDatePublication());
        System.out.println("Nombre de Pages: " + nombreDePages);
        System.out.println("Domaine de Recherche: " + domaineRecherche);
    }

    public static void enterScientificJournal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for Journal Scientifique:");
        System.out.print("Title: ");
        String journalTitre = scanner.nextLine();
        System.out.print("Author: ");
        String journalAuteur = scanner.nextLine();
        System.out.print("Publication Date (yyyy-mm-dd): ");
        LocalDate journalDatePublication = InputValidator.readDate();
        System.out.print("Number of Pages: ");
        int journalNombreDePages = InputValidator.getIntInput();
        System.out.print("Research Domain: ");
        String domaineRecherche = scanner.nextLine();

        JournalScientifique journalScientifique = new JournalScientifique(
                journalTitre, journalAuteur, journalDatePublication, journalNombreDePages, domaineRecherche
        );

        DocumentDAO.addScientificJournal(journalScientifique);
    }

    public static void updateScientificJournal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the Journal Scientifique to update: ");
        int id = InputValidator.getIntInput();

        System.out.println("Enter new details for the Journal Scientifique:");
        System.out.print("Title: ");
        String titre = scanner.nextLine();
        System.out.print("Author: ");
        String auteur = scanner.nextLine();
        System.out.print("Publication Date (yyyy-mm-dd): ");
        LocalDate datePublication = InputValidator.readDate();
        System.out.print("Number of Pages: ");
        int nombreDePages = InputValidator.getIntInput();
        System.out.print("Domaine de Recherche: ");
        String domaineRecherche = scanner.nextLine();

        JournalScientifique journalScientifique = new JournalScientifique(titre, auteur, datePublication, nombreDePages, domaineRecherche);
        journalScientifique.setId(String.valueOf(id));

        DocumentDAO.updateJournalScientifique(journalScientifique);
    }

}
