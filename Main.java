import java.util.ArrayList;
import java.util.Scanner;

class Page
{
    public void menu(Scanner scanner)
    {
        System.out.println("Welkom bij je orgelboekencollectie");
        System.out.println("Maak een keuze om verder te gaan:");
        System.out.println("1. Boek toevoegen aan collectie");
        int keuze = scanner.nextInt();
        scanner.nextLine();
        switch (keuze)
        {
            case 1:
                this.voegBoekToe(scanner);
                break;
        }
    }

    public void voegBoekToe(Scanner scanner)
    {
        ArrayList<Lied> liederen = new ArrayList<Lied>();
        System.out.println("Wat is de naam van het boekje?");
        String boekje = scanner.nextLine();
        System.out.println("Wie is de componist van het boekje?");
        String componistnaam = scanner.nextLine();
        System.out.println("Onder welke categorie valt het boekje?");
        String categorienaam = scanner.nextLine();
        System.out.println("Welke liederen staan er in het boekje? Typ 'stop' al je alle liederen hebt toegevoegd");
        while(true)
        {
            String liednaam = scanner.nextLine();
            if(liednaam.equals("stop"))
            {
                Componist componist = new Componist(componistnaam);
                Categorie categorie = new Categorie(categorienaam);
                Boek boek = new Boek("Boekje", componist, categorie, liederen);
                BookLoader bookLoader = new BookLoader();
                LiedLoader liedloader = new LiedLoader();
                int boek_id = bookLoader.writeBoek(boek);
                for(Lied l : boek.getLiederen())
                {
                    l.setBoekId(boek_id);
                    liedloader.writeLied(l);
                }
                break;
            }

            Lied lied = new Lied(liednaam);
            liederen.add(lied);
            System.out.printf("Lied %s toegevoegd aan %s \n", lied, boekje);
            System.out.println("Voeg nog een lied toe aan het boekje of typ 'stop'");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Page page = new Page();

        page.menu(scanner);
    }
}