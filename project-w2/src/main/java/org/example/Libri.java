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

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPubblication(LocalDate pubblication) {
        this.pubblication = pubblication;
    }

    public void setPagesnumber(int pagesnumber) {
        this.pagesnumber = pagesnumber;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
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

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", pubblication=" + pubblication +
                ", pagesnumber=" + pagesnumber +
                ", author='" + author + '\'' +
                '}';
    }
}
