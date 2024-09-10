package com.library.metier;

import com.library.dao.DocumentDAO;
import com.library.model.Document;

import java.util.List;
import java.util.Optional;

public class DocumentService {
    private DocumentDAO documentDao;

    public DocumentService(DocumentDAO documentDao) {
        this.documentDao = documentDao;
    }

    // Ajouter un nouveau document
    public void ajouterDocument(Document document) {
        documentDao.ajouter(document);
    }

    // Supprimer un document
    public void supprimerDocument(int id) {
        documentDao.supprimer(id);
    }

    // Rechercher un document par son ID
    public Optional<Document> trouverDocumentParId(int id) {
        return documentDao.trouverParId(id);
    }

    // Lister tous les documents
    public List<Document> listerDocuments() {
        return documentDao.trouverTous();
    }

    // Rechercher un document par son titre
    public List<Document> rechercherParTitre(String titre) {
        return documentDao.rechercherParTitre(titre);
    }
}
