import java.util.ArrayList;
import java.util.Scanner;

class Page
{
    public void menu(Scanner scanner)
    {
        System.out.println("Welkom bij je orgelboekencollectie");
        System.out.println("Maak een keuze om verder te gaan:");
        System.out.println("1. Lied toevoegen aan database");
        System.out.println("2. Boek toevoegen aan collectie");
        System.out.println("3. Boeken zoeken op basis van lied");
        int keuze = scanner.nextInt();
        scanner.nextLine();
        switch (keuze)
        {
            case 1:
                this.voegLiedToe(scanner);
                break;
            case 2:
                this.voegBoekToe(scanner);
                break;
            case 3:
                this.filterBoek(scanner);
                break;
        }
    }



    public void voegBoekToe(Scanner scanner)
    {
        BoekLoader bookLoader = new BoekLoader();
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
        for(Lied l : liedloader.loadLiederen())
        {
            System.out.println(lied_index + ". " + l.getNaam());
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

            Lied gekozenLied = liedloader.loadLiederen().get(liednummer - 1);
            String liednaam = gekozenLied.getNaam();
            int liedid = gekozenLied.getId();
            Lied lied = new Lied(liedid, liednaam);
            liederen.add(lied);
            System.out.printf("Lied %s toegevoegd aan %s \n", lied.getNaam(), boekje);
            System.out.println("Voeg nog een lied toe aan het boekje of typ '0'");
        }
    }

    public void voegLiedToe(Scanner scanner)
    {
        System.out.println("Voeg liederen toe door de naam van een lied in te voeren of typ 'stop' om het proces te stoppen");
        LiedLoader liedLoader = new LiedLoader();
        while(true)
        {
            System.out.println("Typ een liednaam of 'stop' om te stoppen:");
            String liednaam = scanner.nextLine();
            if(!liednaam.equals("stop"))
            {
                Lied lied = new Lied(liednaam);
                liedLoader.writeLied(lied);
                System.out.printf("Lied %s toegevoegd aan de database! \n", lied.getNaam());
            }
            else
            {
                this.menu(scanner);
            }
        }
    }

    public void filterBoek(Scanner scanner)
    {
        LiedLoader liedLoader = new LiedLoader();
        BoekLoader boekLoader = new BoekLoader();
        ArrayList<Lied> liederen = liedLoader.loadLiederen();
        Boek boekFilter = new Boek();
        Componist componistFilter = new Componist();
        System.out.println("Naar welke categorie muziek ben je op zoek?");
        ArrayList<String> categorieen = boekLoader.loadIdentiekeCategorieen();
        ArrayList<Boek> boeken = boekLoader.loadBooks();
        int categorie_index = 1;
        for(String categorie : categorieen)
        {
            System.out.println(categorie_index + ". " + categorie);
            categorie_index++;
        }
        int categorieIndex = scanner.nextInt();
        if(categorieIndex != categorieen.size())
        {
            boeken = boekFilter.filterBoek(boeken, categorieen.get(categorieIndex - 1));
        }

        System.out.println("Op welk lied wil je zoeken?");
        int lied_index = 1;
        for(Lied l : liederen)
        {
            System.out.println(lied_index + ". " + l.getNaam());
            lied_index++;
        }
        int gekozenliedindex = scanner.nextInt();
        scanner.nextLine();
        Lied gekozenlied = new Lied();
        gekozenlied = gekozenlied.getByIndex(gekozenliedindex);
        boeken = gekozenlied.filterBoek(boeken, "" + gekozenlied.getId());

        System.out.println("Ben je op zoek naar boekjes van een specefieke componist (Y/N)?");
        String keuze = scanner.nextLine();
        if(keuze.equals("Y"))
        {
            System.out.println("Zoek op een componist:");
            String componist = scanner.nextLine();
            boeken = componistFilter.filterBoek(boeken, componist);
        }

        System.out.println("Er voldoen " + boeken.size() + " boek(en) aan jouw zoekopdracht:");
        int boekIndex = 1;
        for(Boek b : boeken)
        {
            System.out.println(boekIndex + ". " + b.getNaam() + " - " + b.getComponist().getNaam());
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