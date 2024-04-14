import java.util.ArrayList;

public class Filter {
    private String filterType;

    public Filter(String filterType)
    {
        this.filterType = filterType;
    }
    public ArrayList<Boek> filterBoek(ArrayList<Boek> boeken, String filter)
    {
        String filtertype = this.filterType;
        ArrayList<Boek> result = new ArrayList<Boek>();
        if(filterType.equals("ld"))
        {
            int filterInt = Integer.parseInt(filter);
            for(Boek boek : boeken)
            {
                for(Lied lied : boek.getLiederen())
                {
                    if(lied.getId() == filterInt)
                    {
                        result.add(boek);
                    }
                }
            }
        }

        if(filterType.equals("cp"))
        {
            for(Boek boek : boeken)
            {
                if(boek.getComponist().getNaam().equals(filter))
                {
                    result.add(boek);
                }
            }
        }
        return result;
    }
}
