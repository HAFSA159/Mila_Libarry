package com.library.dao;

import com.library.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentDAO {
    void ajouter(Document document);
    void supprimer(int id);
    Optional<Document> trouverParId(int id);
    List<Document> trouverTous();
    List<Document> rechercherParTitre(String titre);
    void mettreAJour(Document document);
}
