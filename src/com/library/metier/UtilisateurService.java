package com.library.metier;

import com.library.dao.UtilisateurDAO;
import com.library.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public class UtilisateurService {
    private UtilisateurDAO utilisateurDAO;

    public UtilisateurService(UtilisateurDAO utilisateurDao) {
        this.utilisateurDAO = utilisateurDao;
    }

    // Ajouter un utilisateur
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.ajouter(utilisateur);
    }

    // Supprimer un utilisateur
    public void supprimerUtilisateur(int id) {
        utilisateurDAO.supprimer(id);
    }

    // Trouver un utilisateur par son ID
    public Optional<Utilisateur> trouverUtilisateurParId(int id) {
        return utilisateurDAO.trouverParId(id);
    }

    // Lister tous les utilisateurs
    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurDAO.trouverTous();
    }
}
