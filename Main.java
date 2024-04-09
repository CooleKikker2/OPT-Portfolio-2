import java.util.ArrayList;
import java.util.Scanner;

class Page
{
    public void menu(Scanner scanner)
    {
        System.out.println("Welkom bij je orgelboekencollectie");
        System.out.println("Maak een keuze om verder te gaan:");
        System.out.println("1. Boek toevoegen aan collectie");
        System.out.println("2. Boeken zoeken op basis van lied");
        int keuze = scanner.nextInt();
        scanner.nextLine();
        switch (keuze)
        {
            case 1:
                this.voegBoekToe(scanner);
                break;
            case 2:
                this.filterBoek(scanner);
                break;
        }
    }



    public void voegBoekToe(Scanner scanner)
    {
        BookLoader bookLoader = new BookLoader();
        LiedLoader liedloader = new LiedLoader();

        ArrayList<String> categorieen = new ArrayList<String>();
        categorieen.add("Kerst");
        categorieen.add("Heilig Avondmaal");
        categorieen.add("Pasen");
        categorieen.add("Goede Vrijdag");
        categorieen.add("Jeugddienst");
        categorieen.add("Psalmen");

        ArrayList<Lied> liederen = new ArrayList<Lied>();
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
        int lied_index = 1;
        for(String[] l : liedloader.loadLiederen())
        {
            System.out.println(lied_index + ". " + l[1]);
            lied_index++;
        }
        while(true)
        {
            int liednummer = scanner.nextInt();
            scanner.nextLine();
            if(liednummer == 0)
            {
                Componist componist = new Componist(componistnaam);
                Boek boek = new Boek("Boekje", componist, categorie, liederen);
                bookLoader.writeBoek(boek);
                this.menu(scanner);
                break;
            }

            String[] gekozenLied = liedloader.loadLiederen().get(liednummer - 1);
            String liednaam = gekozenLied[1];
            int liedid = Integer.parseInt(gekozenLied[0]);
            Lied lied = new Lied(liedid, liednaam);
            liederen.add(lied);
            System.out.printf("Lied %s toegevoegd aan %s \n", lied.getNaam(), boekje);
            System.out.println("Voeg nog een lied toe aan het boekje of typ '0'");
        }
    }

    public void filterBoek(Scanner scanner)
    {

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Page page = new Page();

        page.menu(scanner);
    }
}