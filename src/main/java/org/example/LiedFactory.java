package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LiedFactory implements Factory<Lied> {
    public static String liedFile = "lied.txt";

    public Lied create(int id, String naam) {
        return new Lied(id, naam);
    }

    public Lied create(int id, String naam, ArrayList<Lied> liederen, String categorie, Componist componist) {
        return null;
    }

    public void write(Lied lied)
    {
        dbEncoder dbEncoder = new dbEncoder();
        // @todo 1 vervangen door ID (moet nog worden berekend)
        String line = "1 " + dbEncoder.encode(lied.getNaam());

        try (FileWriter writer = new FileWriter(liedFile, true)) {
            writer.append(line).append("\n");
            writer.flush();  // Ensure immediate writing
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public String getFilePath()
    {
        return liedFile;
    }
}
