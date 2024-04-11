
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BoekLoader {
    private String booksFile = "boek.txt";

    public void removeBook(ArrayList<String[]> boeken){
        try {
            FileWriter writer = new FileWriter(booksFile);
            writer.append("Id Naam Componist Categorie Liederen\n");

            for(int i = 0; i < boeken.size(); i++){
                boeken.get(i)[0] = String.valueOf(i + 1);
            }

            //voeg nieuwe gerefreshde ID game lijst toe aan games.txt
            for(String[] boek : boeken){
                String line = "";
                line = boek[0] + " " + boek[1] + " " + boek[2] + " " + boek[3] + " " + boek[4];
                writer.append(line + "\n");
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public int writeBoek(Boek b){
        try {
            FileWriter writer = new FileWriter(booksFile, true);
            dbEncoder dbEncoder = new dbEncoder();

            int new_id = loadBooks().size() + 1;
            String line = new_id + " " + dbEncoder.encode(b.getNaam()) + " " + dbEncoder.encode(b.getComponist().getNaam()) + " " + dbEncoder.encode(b.getCategorie()) + " " + b.getLiedIds();
            writer.append(line + "\n");
            writer.close();
            return new_id;
        } catch (IOException e){
            e.printStackTrace();
        }

        return 0;
    }
    public ArrayList<Boek> loadBooks()
    {
        dbEncoder dbEncoder = new dbEncoder();
        ArrayList<String[]> dbBoeken = this.loadFile(booksFile);
        ArrayList<Boek> result = new ArrayList<Boek>();
        for (String[] dbBoek : dbBoeken)
        {
            Componist componist = new Componist(dbEncoder.decode(dbBoek[2]));
            ArrayList<Lied> liederen = new ArrayList<Lied>();

            int index = 0;
            for(String lied_id : dbBoek)
            {
                if(index > 3)
                {
                    Lied lied = new Lied();
                    lied = lied.getById(Integer.parseInt(lied_id));
                    liederen.add(lied);
                }
                index = index + 1;
            }

            Boek boek = new Boek(dbEncoder.decode(dbBoek[1]), componist, dbEncoder.decode(dbBoek[3]), liederen);
            result.add(boek);
        }
        return result;
    }

    public ArrayList<String[]> loadFile(String fileName)
    {
        String[] parts = new String[4];
        ArrayList<String[]> gameLines = new ArrayList<>();
        try {
            // Bestandspad openen en opslaan om later het bestand te openen
            Path filePath = Paths.get(fileName);

            //Bestand uitlezen
            List<String> lines = Files.readAllLines(filePath);

            // Elke regel toevoegen aan de games-lijst. Eerste overslaan (header)
            String line;
            for (int i = 1; i < lines.size(); i++) {
                line = lines.get(i);
                parts = line.split(" ");

                gameLines.add(parts);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameLines;
    }
}