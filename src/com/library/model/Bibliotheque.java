package com.library.model;

import java.time.LocalDate;
import java.util.*;

public class Bibliotheque {
    private List<Document> documents;
    private List<Document> borrowedDocuments;
    private HashMap<String, Document> titleMap;
    private int idCounter = 1;

    public Bibliotheque() {
        this.documents = new ArrayList<>();
        this.borrowedDocuments = new ArrayList<>();
        this.titleMap = new HashMap<>();
    }

    public List<Document> getDocuments() {
        return new ArrayList<>(documents);
    }

    public void ajouterLivre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        Livre livre = new Livre(String.valueOf(generateId()), titre, auteur, datePublication, nombreDePages, isbn);
        documents.add(livre);
        titleMap.put(titre.toLowerCase(), livre);
    }

    public void ajouterMagazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, String numero) {
        Magazine magazine = new Magazine(String.valueOf(generateId()), titre, auteur, datePublication, nombreDePages, numero);
        documents.add(magazine);
        titleMap.put(titre.toLowerCase(), magazine);
    }

    public Document rechercherDocumentParTitre(String titre) {
        return titleMap.get(titre.toLowerCase());
    }

    public void supprimerDocument(String titre) {
        Document document = rechercherDocumentParTitre(titre);
        if (document != null) {
            documents.remove(document);
            titleMap.remove(titre.toLowerCase());
            System.out.println("Document removed successfully.");
        } else {
            System.out.println("Document not found.");
        }
    }

    public void afficherTousLesDocuments() {
        if (documents.isEmpty()) {
            System.out.println("No documents in the library.");
        } else {
            for (Document doc : documents) {
                doc.afficherDetails();
            }
        }
    }

    public void afficherDocumentsEmpruntes() {
        if (borrowedDocuments.isEmpty()) {
            System.out.println("No documents have been borrowed.");
        } else {
            for (Document doc : borrowedDocuments) {
                doc.afficherDetails();
            }
        }
    }

    public boolean emprunterDocumentParId(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                documents.remove(doc);
                borrowedDocuments.add(doc);
                return true;
            }
        }
        return false;
    }

    public boolean retournerDocumentParId(String id) {
        for (Document doc : borrowedDocuments) {
            if (doc.getId().equals(id)) {
                borrowedDocuments.remove(doc);
                documents.add(doc);
                return true;
            }
        }
        return false;
    }

    private int generateId() {
        return idCounter++;
    }
}
