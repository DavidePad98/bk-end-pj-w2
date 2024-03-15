package org.example;

import java.time.LocalDate;

public class Libri implements Prodotto{
    private int ISBN;
    private String title;
    private LocalDate pubblication;
    private int pagesnumber;
    private String author;
    private String genere;
    public Libri(int ISBN, String title, LocalDate pubblication, int pagesnumber, String author, String genere){
        this.ISBN = ISBN;
        this.title = title;
        this.pubblication = pubblication;
        this.pagesnumber = pagesnumber;
        this.author = author;
        this.genere = genere;
    }

    public int getISBN() {
        return ISBN;
    }


    public String getAuthor() {
        return author;
    }

    @Override
    public LocalDate getLocalDate() {
        return pubblication;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", pubblication=" + pubblication +
                ", pagesnumber=" + pagesnumber +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
