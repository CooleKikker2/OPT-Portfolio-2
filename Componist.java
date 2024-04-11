public class Componist extends Filter {
    private String naam;

    public Componist(String naam)
    {
        super("cp");
        this.naam = naam;
    }
    public String getNaam()
    {
        return this.naam;
    }
}
