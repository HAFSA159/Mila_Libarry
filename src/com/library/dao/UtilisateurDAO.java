package com.library.dao;

import com.library.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDAO {
    void ajouter(Utilisateur utilisateur);
    void supprimer(int id);
    Optional<Utilisateur> trouverParId(int id);
    List<Utilisateur> trouverTous();
    void mettreAJour(Utilisateur utilisateur);
}
