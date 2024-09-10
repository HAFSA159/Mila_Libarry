package com.library.interfaces;

import java.time.LocalDate;

public interface Empruntable {
    boolean emprunter(int utilisateurId, LocalDate dateEmprunt);
    boolean retourner(LocalDate dateRetour);
    LocalDate getDateRetourPrevue();
}
