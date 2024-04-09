
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiedLoader {
    private String liedFile = "lied.txt";

    public void removeLied(ArrayList<String[]> games){
        try {
            FileWriter writer = new FileWriter(liedFile);
            writer.append("Id Naam Boek\n");

            //alle games hun ID's refreshen zodat het weer gesorteerd is(zodat je geen problemen krijgt met het toevoegen van nieuwe games en dan twee dezelfde ID's krijgt)
            for(int i = 0; i < games.size(); i++){
                games.get(i)[0] = String.valueOf(i + 1);
            }

            //voeg nieuwe gerefreshde ID game lijst toe aan games.txt
            for(String[] game : games){
                String line = "";
                line = game[0] + " " + game[1] + " " + game[2] + " " + game[3] + " " + game[4];
                writer.append(line + "\n");
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public int writeLied(Lied l){
        try {
            FileWriter writer = new FileWriter(liedFile, true);

            int new_id = loadLiederen().size() + 1;
            String line = new_id + " " + l.getNaam();
            writer.append(line + "\n");
            writer.close();
            return new_id;
        } catch (IOException e){
            e.printStackTrace();
        }

        return 0;
    }
    public ArrayList<String[]> loadLiederen()
    {
        //Games inladen (sorteeroptie / filteroptie later hier inbouwen)
        return this.loadFile(liedFile);
    }

    public ArrayList<String[]> loadFile(String fileName)
    {
        String[] parts = new String[4];
        ArrayList<String[]> liedLines = new ArrayList<>();
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

                liedLines.add(parts);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return liedLines;
    }
}