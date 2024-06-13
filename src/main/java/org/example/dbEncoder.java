package org.example;

public class dbEncoder {

    public String encode(String tekst) {
        return tekst.replace(" ", "_");
    }

    public String decode(String encodedTekst) {
        return encodedTekst.replace("_", " ");
    }
}
