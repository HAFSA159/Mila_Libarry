package com.library.interfaces;

import java.time.LocalDate;

public interface Reservable {
    boolean reserver(int utilisateurId, LocalDate dateReservation);
    boolean annulerReservation(int utilisateurId);
    LocalDate getDateDisponibilite();
}