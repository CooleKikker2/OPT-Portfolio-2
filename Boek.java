import java.util.ArrayList;

public class Boek {
    private String naam;
    private Componist componist;

    private Categorie categorie;

    private ArrayList<Lied> liederen;

    public Boek(String naam, Componist componist, Categorie categorie, ArrayList<Lied> liederen)
    {
        this.naam = naam;
        this.componist = componist;
        this.categorie = categorie;
        this.liederen = liederen;
    }

    public String getNaam()
    {
        return this.naam;
    }

    public ArrayList<Lied> getLiederen()
    {
        return this.liederen;
    }

    public Componist getComponist()
    {
        return this.componist;
    }

    public Categorie getCategorie()
    {
        return this.categorie;
    }

    public String getBoekNamen()
    {
        return "";
    }
}
