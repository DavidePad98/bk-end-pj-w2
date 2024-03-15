package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import period.Periodicita;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ENGLISH);
        Random rndm = new Random();
        Scanner scn = new Scanner(System.in);
        Libri libro1 = new Libri(1, faker.book().title(), LocalDate.of(2023, 4, 4), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), faker.book().genre());
        Libri libro2 = new Libri(2, faker.book().title(), LocalDate.of(2023, 5, 14), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), faker.book().genre());
        Libri libro3 = new Libri(3, faker.book().title(), LocalDate.of(2022, 7, 3), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), faker.book().genre());
        Libri libro4 = new Libri(4, faker.book().title(), LocalDate.of(2021, 12, 6), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), faker.book().genre());
        Libri libro5 = new Libri(5, faker.book().title(), LocalDate.of(2018, 8, 17), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), faker.book().genre());
        Libri libro6 = new Libri(6, faker.book().title(), LocalDate.of(2016, 10, 30), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), faker.book().genre());

        Riviste riv1 = new Riviste(101, faker.book().title(), LocalDate.of(2020, 5, 5), rndm.nextInt(50, 500), Periodicita.MENSILE);
        Riviste riv2 = new Riviste(102, faker.book().title(), LocalDate.of(2021, 1, 15), rndm.nextInt(50, 500), Periodicita.SEMESTRALE);
        Riviste riv3 = new Riviste(103, faker.book().title(), LocalDate.of(2016, 10, 6), rndm.nextInt(50, 500), Periodicita.SETTIMANALE);
        Riviste riv4 = new Riviste(104, faker.book().title(), LocalDate.of(2000, 7, 25), rndm.nextInt(50, 500), Periodicita.MENSILE);
        Riviste riv5 = new Riviste(105, faker.book().title(), LocalDate.of(2005, 8, 30), rndm.nextInt(50, 500), Periodicita.SETTIMANALE);
        Riviste riv6 = new Riviste(106, faker.book().title(), LocalDate.of(1998, 3, 19), rndm.nextInt(50, 500), Periodicita.SETTIMANALE);

        List<Libri> bookList = new ArrayList<>();
        bookList.add(libro1);
        bookList.add(libro2);
        bookList.add(libro3);
        bookList.add(libro4);
        bookList.add(libro5);
        bookList.add(libro6);

        List<Riviste> magazineList = new ArrayList<>();
        magazineList.add(riv1);
        magazineList.add(riv2);
        magazineList.add(riv3);
        magazineList.add(riv4);
        magazineList.add(riv5);
        magazineList.add(riv6);

        List<Prodotto> prodottoList = new ArrayList<>();
        prodottoList.addAll(bookList);
        prodottoList.addAll(magazineList);


        magazineList.forEach(magazine -> System.out.println(magazine));
        System.out.println("------------------------------------------");
        bookList.forEach(book -> System.out.println(book));


//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------
        System.out.println("-----------ES1-------------");
        System.out.println("vuoi aggiungere un libro o una rivista? l/r");
        String s = scn.nextLine();

        if (s.equalsIgnoreCase("l")) {
            System.out.println("aggiungi un libro partendo dal nuovo codice univoco (ISBN):");
            int newISBN = scn.nextInt();
            scn.nextLine();

            boolean isbnExists = bookList.stream()
                    .anyMatch(libro -> libro.getISBN() == newISBN);

            if (isbnExists) {
                System.out.println("esiste già un libro con questo codice ISBN, riprova.");
            } else {
                System.out.println("inserisci il titolo:");
                String newTitle = scn.nextLine();
                System.out.println("inserisci la data di pubblicazione:");
                System.out.println("giorno:");
                int day = scn.nextInt();
                System.out.println("mese:");
                int month = scn.nextInt();
                System.out.println("anno:");
                int year = scn.nextInt();
                System.out.println("quante pagine ha il prodotto?");
                int pages = scn.nextInt();
                scn.nextLine();

                System.out.println("ho trovato autore e genere del tuo libro.");
                String author = faker.dragonBall().character();
                String genres = faker.book().genre();

                Libri nuovoLibro = new Libri(newISBN, newTitle, LocalDate.of(year, month, day), pages, author, genres);
                System.out.println("ecco il tuo nuovo libro: " + nuovoLibro);
                bookList.add(nuovoLibro);
            }
        } else if (s.equalsIgnoreCase("r")) {
            System.out.println("aggiungi una rivista partendo dal nuovo codice univoco (ISBN):");
            int newMagISBN = scn.nextInt();
            scn.nextLine();

            boolean isbnExists = magazineList.stream()
                    .anyMatch(rivista -> rivista.getISBN() == newMagISBN);

            if (isbnExists) {
                System.out.println("esiste già una rivista con questo codice ISBN, riprova.");
            } else {
                System.out.println("inserisci il titolo:");
                String newMagTitle = scn.nextLine();
                System.out.println("inserisci la data di pubblicazione:");
                System.out.println("giorno:");
                int dayMag = scn.nextInt();
                System.out.println("mese:");
                int monthMag = scn.nextInt();
                System.out.println("anno:");
                int yearMag = scn.nextInt();
                System.out.println("quante pagine ha il prodotto?");
                int pagesMag = scn.nextInt();
                scn.nextLine();
                System.out.println("con che periodicità vuoi che sia l'uscita?");
                String periodOut = scn.nextLine();
                Periodicita periodicita;
                switch (periodOut.toUpperCase()){
                    case "SETTIMANALE":
                        periodicita = Periodicita.SETTIMANALE;
                        break;
                    case"MENSILE":
                        periodicita = Periodicita.MENSILE;
                        break;
                    case "SEMESTRALE":
                        periodicita = Periodicita.SEMESTRALE;
                        break;
                    default:
                        System.out.println("il periodo di uscita non è accettabile, abbiamo scelto per te settimanalemtne");
                        periodicita = Periodicita.SETTIMANALE;
                        break;
                }

                Riviste nuovaRivista = new Riviste(newMagISBN, newMagTitle, LocalDate.of(yearMag, monthMag, dayMag), pagesMag, periodicita);
                System.out.println("ecco la tua nuova rivista: " + nuovaRivista);
                magazineList.add(nuovaRivista);
            }
        } else {
            System.out.println("arrivederci.");

        System.out.println("-----------ES2-------------");
                System.out.println("vuoi rimuovere elemento? s/n");
        String a = scn.nextLine();

        boolean isbnExists = false;
        if (a.equalsIgnoreCase("s")){
            System.out.println("inserisci il codice univoco(ISBN):");
        int isbn = scn.nextInt();


            Iterator<Prodotto> iterator = prodottoList.iterator();
            while (iterator.hasNext()) {
                Prodotto product = iterator.next();
                if (isbn == product.getISBN()) {
                    isbnExists = true;
                    iterator.remove();
                    System.out.println("hai rimosso l'elemento: " + product);
                    break;
                }
            }
            if (!isbnExists) {
                System.out.println("errore: il libro con ISBN " + isbn + " non esiste nella lista.");
            }
        } else System.out.println("arrivederci");

        prodottoList.forEach(System.out::println);

        System.out.println("-----------ES3-------------");
        System.out.println("ricerca un elemento tramite il codice ISBN");
        int searchISBN = scn.nextInt();
        for (Prodotto product : prodottoList) {
            if (searchISBN == product.getISBN()) {
                isbnExists = true;
                System.out.println("Elemento trovato:");
                if (product instanceof Libri) {
                    Libri libro = (Libri) product;
                    System.out.println("Libro: " + libro);
                } else if (product instanceof Riviste) {
                    Riviste rivista = (Riviste) product;
                    System.out.println("Rivista: " + rivista);
                }
                break;
            }
        }

        if (!isbnExists) {
            System.out.println("Errore: l'elemento con ISBN " + searchISBN + " non esiste nella lista.");
        } else System.out.println("Arrivederci.");

        System.out.println("-----------ES4-------------");
        System.out.println("ricerca per anno pubblicazione");
        System.out.println("giorno:");
        int days = scn.nextInt();
        System.out.println("mese:");
        int months = scn.nextInt();
        System.out.println("anno:");
        int years = scn.nextInt();
        LocalDate searchDate = LocalDate.of(years, months, days);
        List<Prodotto> resultDate = prodottoList.stream()
                        .filter(prodotto -> prodotto.getLocalDate().equals(searchDate))
                                .collect(Collectors.toList());
        if (resultDate.isEmpty()){
            System.out.println("nessun riscontro per la data: " + searchDate);
        }else resultDate.forEach(System.out::println);

        System.out.println("-----------ES5-------------");
        System.out.println("ricerca per autore:");
        String author = scn.nextLine();

        List<Libri> resultAuthor = bookList.stream()
                .filter(libri -> libri.getAuthor().equalsIgnoreCase(author))
                        .collect(Collectors.toList());
        if (resultAuthor.isEmpty()){
            System.out.println("nessun autore trovato con il nome di: " + author);
        } else resultAuthor.forEach(System.out::println);

        System.out.println("-----------ES6/ES7-------------");
        File file = new File("src/fileLibrary.txt");
        try{
            //Prove scrittura:
//            System.out.println("cosa ti va di scrivere?");
//            String risp = scn.nextLine();
//            FileUtils.writeStringToFile(file, risp.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            //FileUtils.writeStringToFile(file, prodottoList.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            //FileUtils.writeStringToFile(file, bookList.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(file, magazineList.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            System.out.println("archivio scritto");
            System.out.println("--------------ES7-LETTURA---------------");
            String contenutoArchivio = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println(contenutoArchivio);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}}


