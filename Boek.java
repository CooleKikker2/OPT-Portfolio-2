public class Boek {
    public String naam;
    public Componist componist;

    public Categorie categorie;

    public Boek(String naam, Componist componist, Categorie categorie)
    {
        this.naam = naam;
        this.componist = componist;
        this.categorie = categorie;
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
