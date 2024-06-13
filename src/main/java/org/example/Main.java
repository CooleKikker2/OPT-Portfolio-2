package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends MenuChoice{
    ArrayList<Lied> liederen;
    ArrayList<Boek> boeken;

    public Factory<Lied> liedFactory = new LiedFactory();
    public Factory<Boek> boekFactory = new BoekFactory();

    public Main() {
        liederen = new ArrayList<>();
        boeken = new ArrayList<>();
    }

    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.run();
    }

    public void loadData()
    {
        dbEncoder dbEncoder = new dbEncoder();
        this.boeken.clear();
        this.liederen.clear();


        // Liederen
        ArrayList<String[]> liedData = loadFile(this.liedFactory.getFilePath());
        for (String[] lied : liedData) {
            Lied dbLied = this.liedFactory.create(Integer.parseInt(lied[0]), dbEncoder.decode(lied[1]));
            this.liederen.add(dbLied);
        }


        // Boeken
        ArrayList<String[]> boekData = loadFile(this.boekFactory.getFilePath());
        for (String[] boek : boekData) {
            ArrayList<Lied> liederenInBoek = new ArrayList<Lied>();
            for(int l = 4; l < boek.length; l++)
            {
                for (Lied lied : this.liederen)
                {
                    if(lied.getId() == Integer.parseInt(boek[l]))
                    {
                        System.out.println(lied.getNaam());
                        liederenInBoek.add(lied);
                    }
                }
            }

            Boek dbBoek = this.boekFactory.create(Integer.parseInt(boek[0]), dbEncoder.decode(boek[1]), liederenInBoek, dbEncoder.decode(boek[2]), new Componist(boek[2]));

            this.boeken.add(dbBoek);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            this.loadData();
            System.out.println("Welkom bij je orgelboekencollectie");
            System.out.println("Maak een keuze om verder te gaan:");

            ArrayList<String> choices = new ArrayList<>();
            choices.add("Lied toevoegen aan database");
            choices.add("Boek toevoegen aan collectie");
            choices.add("Boeken zoeken op basis van lied");

            showChoices(choices);
            int keuze = waitForIntAnswer(scanner);

            switch (keuze) {
                case 1:
                    voegLiedToe voegLiedToe = new voegLiedToe() {};
                    voegLiedToe.run(scanner);
                    break;
                case 2:
                    voegBoekToe voegBoekToe = new voegBoekToe() {};
                    voegBoekToe.run(scanner, this.boeken, this.liederen);
                    break;
                case 3:
                    filterBoek filterBoek = new filterBoek() {};
                    filterBoek.run(scanner, this.boeken, this.liederen);
                    break;
            }
        }
    }

    public static ArrayList<String[]> loadFile(String fileName) {
        ArrayList<String[]> FileLines = new ArrayList<>();
        try {
            Path filePath = Paths.get(fileName);
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] parts = line.split(" ");
                FileLines.add(parts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileLines;
    }
}
