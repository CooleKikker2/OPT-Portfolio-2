import java.util.ArrayList;

public class Filter {
    private String filterType;

    public Filter(String filterType)
    {
        this.filterType = filterType;
    }
    public ArrayList<Boek> filterBoek(ArrayList<Boek> boeken, int filter)
    {
        ArrayList<Boek> resultaat = new ArrayList<Boek>();
        String filtertype = this.filterType;
        ArrayList<Boek> result = new ArrayList<Boek>();
        if(filterType.equals("ld"))
        {
            for(Boek boek : boeken)
            {
                for(Lied lied : boek.getLiederen())
                {
                    if(lied.getId() == filter)
                    {
                        result.add(boek);
                    }
                }
            }
        }

        return result;
    }
}
