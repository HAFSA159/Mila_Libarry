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

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.ajouter(utilisateur);
    }

    public void supprimerUtilisateur(int id) {
        utilisateurDAO.supprimer(id);
    }

    public Optional<Utilisateur> trouverUtilisateurParId(int id) {
        return utilisateurDAO.trouverParId(id);
    }

    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurDAO.trouverTous();
    }
}
