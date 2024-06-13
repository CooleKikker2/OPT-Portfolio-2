package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class voegBoekToe extends MenuChoice{
    public void run(Scanner scanner, ArrayList<Boek> boeken, ArrayList<Lied> liederen)
    {
        BoekFactory boekFactory = new BoekFactory();

        ArrayList<String> categorieen = new ArrayList<String>();
        categorieen.add("Kerst");
        categorieen.add("Heilig Avondmaal");
        categorieen.add("Pasen");
        categorieen.add("Goede Vrijdag");
        categorieen.add("Jeugddienst");
        categorieen.add("Psalmen");

        ArrayList<Lied> selectedLiederen = new ArrayList<Lied>();
        System.out.println("Wat is de naam van het boekje?");
        String boekje = scanner.nextLine();
        System.out.println("Wie is de componist van het boekje?");
        String componistnaam = scanner.nextLine();
        System.out.println("Onder welke categorie valt het boekje?");
        int cat_index = 1;
        for(String categorie : categorieen)
        {
            System.out.println(cat_index + ". " + categorie);
            cat_index++;
        }

        int categorienummer = scanner.nextInt();
        String categorie = categorieen.get(categorienummer - 1);
        scanner.nextLine();
        System.out.println("Welke liederen staan er in het boekje? Typ '0' al je alle liederen hebt toegevoegd");
        ArrayList<String> choices = new ArrayList<String>();
        for(Lied lied : liederen)
        {
            System.out.println(lied.getNaam());
            choices.add(lied.getNaam());
        }
        showChoices(choices);


        while(true)
        {
            int liednummer = waitForIntAnswer(scanner);
            if(liednummer == 0)
            {
                Componist componist = new Componist(componistnaam);
                Boek boek = new Boek(boekje, componist, categorie, selectedLiederen);
                boekFactory.write(boek);
                break;
            }

            Lied gekozenLied = liederen.get(liednummer - 1);
            selectedLiederen.add(gekozenLied);
            System.out.printf("Lied %s toegevoegd aan %s \n", gekozenLied.getNaam(), boekje);
            System.out.println("Voeg nog een lied toe aan het boekje of typ '0'");
        }
    }
}
