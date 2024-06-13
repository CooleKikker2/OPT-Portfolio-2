package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BoekFactory implements Factory<Boek> {
    private static String boekFile = "boek.txt";

    public Boek create(int id, String naam) {
        throw new UnsupportedOperationException("This method is not supported for Boek.");
    }

    public Boek create(int id, String naam, ArrayList<Lied> liederen, String categorie, Componist componist) {
        return new Boek(naam, componist, categorie, liederen);
    }

    public void write(Boek boek)
    {
        dbEncoder dbEncoder = new dbEncoder();

        // @todo nieuwe id berekenen
        int new_id = 1;
        String line = new_id + " " + dbEncoder.encode(boek.getNaam()) + " " + dbEncoder.encode(boek.getComponist().getNaam()) + " " + dbEncoder.encode(boek.getCategorie()) + " " + boek.getLiedIds();

        try (FileWriter writer = new FileWriter(boekFile, true)) {
            writer.append(line).append("\n");
            writer.flush();  // Ensure immediate writing
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    public String getFilePath()
    {
        return boekFile;
    }
}
