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
        System.out.println("Wat is de naam van het boekje?");
        String boekje = scanner.nextLine();
        System.out.println("Welke liederen staan er in het boekje? Typ 'stop' al je alle liederen hebt toegevoegd");
        while(true)
        {
            String lied = scanner.nextLine();
            if(lied.equals("stop"))
            {
                break;
            }

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