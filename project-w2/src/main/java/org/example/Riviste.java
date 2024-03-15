package org.example;

import period.Periodicita;

import java.time.LocalDate;

public class Riviste implements Prodotto{
    private int ISBN;
    private String title;
    private LocalDate pubblication;
    private int pagesnumber;
    private Periodicita periodicità;

    public Riviste(int ISBN, String title, LocalDate pubblication, int pagesnumber, Periodicita periodicita){
        this.ISBN = ISBN;
        this.title = title;
        this.pubblication = pubblication;
        this.pagesnumber = pagesnumber;
        this.periodicità = periodicita;

    }



    public int getISBN() {
        return ISBN;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public LocalDate getLocalDate() {
        return pubblication;
    }


    @Override
    public String toString() {
        return "Riviste{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", pubblication=" + pubblication +
                ", pagesnumber=" + pagesnumber +
                ", periodicità=" + periodicità +
                '}';
    }
}
