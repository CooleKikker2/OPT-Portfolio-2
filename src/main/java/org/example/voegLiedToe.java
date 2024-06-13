package org.example;

import java.util.Scanner;

public class voegLiedToe {

    public void run(Scanner scanner) {
        System.out.println("Voer de details van het nieuwe lied in:");

        System.out.print("Naam: ");
        String naam = scanner.nextLine();

        Lied nieuwLied = new Lied(naam);

        LiedFactory liedFactory = new LiedFactory();
        liedFactory.write(nieuwLied);
    }
}
