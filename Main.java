import java.util.Scanner;

class Page
{
    public void menu(Scanner scanner)
    {
        System.out.println("Welkom bij je orgelboekencollectie");
        System.out.println("Maak een keuze om verder te gaan:");
        System.out.println("1. Boek toevoegen aan collectie");
        int keuze = scanner.nextInt();
        switch (keuze)
        {
            case 1:
                this.voegBoekToe(scanner);
                break;
        }
    }

    public void voegBoekToe(Scanner scanner)
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