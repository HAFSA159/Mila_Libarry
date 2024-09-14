package com.library.utilitaire;

import java.time.LocalDate;
import java.util.Scanner;

public class InputValidator {


    public static int getIntInput() {
         Scanner scanner = new Scanner(System.in);
        while (true) {
            try {

                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre:");
            }
        }
    }

    public static LocalDate readDate() {
      Scanner  scanner = new Scanner(System.in);
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter the date in the format yyyy-mm-dd.");
            }
        }
    }
}
