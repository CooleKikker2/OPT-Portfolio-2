import java.util.ArrayList;

public class Boek extends Filter{
    private String naam;
    private Componist componist;

    private String categorie;

    private ArrayList<Lied> liederen;

    public Boek()
    {
        super("bk");
    }
    public Boek(String naam, Componist componist, String categorie, ArrayList<Lied> liederen)
    {
        super("bk");
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

    @Override
    public ArrayList<Boek> filterBoek(ArrayList<Boek> boeken, String filter) {
        ArrayList<Boek> resultaat = new ArrayList<>();
        for(Boek boek : boeken)
        {
            if(boek.getCategorie().equals(filter))
            {
                resultaat.add(boek);
            }
        }
        return resultaat;
    }
}
