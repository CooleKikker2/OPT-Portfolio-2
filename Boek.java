public class Boek {
    public String naam;
    public Componist componist;

    public Categorie categorie;

    public Boek(String naam)
    {
        this.naam = naam;
    }

    public String getNaam()
    {
        return this.naam;
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
