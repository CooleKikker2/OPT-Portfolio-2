package org.example;

import java.util.ArrayList;

public class Boek{
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

    public Boolean filter(Componist componist, String categorie, Lied lied)
    {
        if(categorie.equals(this.categorie) && this.liederen.contains(lied))
        {
            if(componist != null)
            {
                if(componist.equals(this.componist))
                {
                    return true;
                }
            }
            return true;
        }

        return false;
    }
}
