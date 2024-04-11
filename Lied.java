import java.util.ArrayList;
import java.util.Scanner;

public class Lied extends Filter{
    private int id;
    private String naam;

    public Lied(){
        super("ld");
    }
    public Lied(String naam)
    {
        super("ld");
        this.naam = naam;
    }
    public Lied(int id, String naam)
    {
        super("ld");
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

    public void setId(int id){
        this.id = id;
    }

    public void setNaam(String naam)
    {
        this.naam = naam;
    }

    public Lied getByIndex(int index)
    {
        LiedLoader liedLoader = new LiedLoader();
        ArrayList<Lied> liederen = liedLoader.loadLiederen();
        return liederen.get(index - 1);
    }

    public Lied getById(int id)
    {
        LiedLoader liedLoader = new LiedLoader();
        ArrayList<Lied> liederen = liedLoader.loadLiederen();
        for(Lied lied : liederen)
        {
            if(lied.getId() == id)
            {
                return lied;
            }
        }
        return null;
    }

}
