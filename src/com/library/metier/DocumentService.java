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

    public void ajouterDocument(Document document) {
        documentDao.ajouter(document);
    }

    public void supprimerDocument(int id) {
        documentDao.supprimer(id);
    }

    public Optional<Document> trouverDocumentParId(int id) {
        return documentDao.trouverParId(id);
    }

    public List<Document> listerDocuments() {
        return documentDao.trouverTous();
    }

    public List<Document> rechercherParTitre(String titre) {
        return documentDao.rechercherParTitre(titre);
    }
}
