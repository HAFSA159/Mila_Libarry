package com.library;

import com.library.dao.DocumentDAO;
import com.library.model.Bibliotheque;
import com.library.model.Livre;
import com.library.presentation.ConsoleUI;

public class Main {
    public static void main(String[] args) {
       /* Bibliotheque bibliotheque = new Bibliotheque();
        ConsoleUI consoleUI = new ConsoleUI(bibliotheque);
        consoleUI.startMenu();*/

        Livre.saisirEtModifierLivre();


    }
}
