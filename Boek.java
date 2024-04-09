import java.util.ArrayList;

public class Boek {
    private String naam;
    private Componist componist;

    private String categorie;

    private ArrayList<Lied> liederen;

    public Boek(String naam, Componist componist, String categorie, ArrayList<Lied> liederen)
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

    public String getCategorie()
    {
        return this.categorie;
    }

    public String getLiedIds()
    {
        String returnString = "";
        for(Lied lied : this.liederen)
        {
            returnString += lied.getId() + " ";
        }

        return returnString;
    }
}
