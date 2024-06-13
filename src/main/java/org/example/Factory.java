package org.example;
import java.util.ArrayList;

public interface Factory<T> {
    T create(int id, String naam);
    T create(int id, String naam, ArrayList<Lied> liederen, String categorie, Componist componist);
    public void write(T item);
    String getFilePath();
}
