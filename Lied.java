public class Lied {
    private String naam;

    private int boek_id;

    public Lied(String naam)
    {
        this.naam = naam;
    }

    public String getNaam()
    {
        return this.naam;
    }

    public int getBoekId()
    {
        return boek_id;
    }

    public void setBoekId(int boek_id)
    {
        this.boek_id = boek_id;
    }
}
