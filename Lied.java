public class Lied {
    private int id;
    private String naam;

    public Lied(String naam)
    {
        this.naam = naam;
    }
    public Lied(int id, String naam)
    {
        this.id = id;
        this.naam = naam;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNaam()
    {
        return this.naam;
    }
}
