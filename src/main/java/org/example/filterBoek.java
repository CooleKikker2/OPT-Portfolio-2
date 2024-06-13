package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class filterBoek extends MenuChoice{

    public void run(Scanner scanner, ArrayList<Boek> boeken, ArrayList<Lied> liederen) {
        System.out.println("Naar welke categorie muziek ben je op zoek?");
        ArrayList<String> categorieen = new ArrayList<String>();

        for(Boek boek : boeken)
        {
            if(!categorieen.contains(boek.getCategorie()))
            {
                categorieen.add(boek.getCategorie());
            }
        }

        showChoices(categorieen);
        int gelecteerdeCategorie = waitForIntAnswer(scanner);

        System.out.println("Op welk lied wil je zoeken?");
        ArrayList<String> liedNamen = new ArrayList<String>();
        for(Lied lied : liederen)
        {
            liedNamen.add(lied.getNaam());
        }

        showChoices(liedNamen);
        int gekozenLied = waitForIntAnswer(scanner);

        Componist componist = null;
        System.out.println("Ben je op zoek naar boekjes van een specefieke componist (Y/N)?");
        String keuze = scanner.nextLine();
        if(keuze.equals("Y"))
        {
            System.out.println("Zoek op een componist:");
            String componistNaam = scanner.nextLine();
            componist = new Componist(componistNaam);
        }

        ArrayList<Boek> gefilterdeBoeken = new ArrayList<Boek>();
        for(Boek boek : boeken)
        {
            if(boek.filter(componist, categorieen.get(gelecteerdeCategorie - 1), liederen.get(gekozenLied - 1)))
            {
                gefilterdeBoeken.add(boek);
            }
        }

        System.out.println("Er voldoen " + gefilterdeBoeken.size() + " boek(en) aan jouw zoekopdracht:");
        int boekIndex = 1;
        for(Boek b : gefilterdeBoeken)
        {
            System.out.println(boekIndex + ". " + b.getNaam() + " - " + b.getComponist().getNaam());
        }

    }
}
