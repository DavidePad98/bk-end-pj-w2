package org.example;

import period.Periodicità;

import java.time.LocalDate;

public class Riviste {
    private int ISBN;
    private String title;
    private LocalDate pubblication;
    private int pagesnumber;
    private Periodicità periodicità;

    public Riviste(int ISBN, String title, LocalDate pubblication, int pagesnumber, Periodicità periodicità){
        this.ISBN = ISBN;
        this.title = title;
        this.pubblication = pubblication;
        this.pagesnumber = pagesnumber;
        this.periodicità = periodicità;

    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPubblication() {
        return pubblication;
    }

    public int getPagesnumber() {
        return pagesnumber;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", pubblication=" + pubblication +
                ", pagesnumber=" + pagesnumber +
                '}';
    }
}
