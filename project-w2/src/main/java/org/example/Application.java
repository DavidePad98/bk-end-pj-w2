package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import period.Periodicita;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ENGLISH);
        Random rndm = new Random();
        Scanner scn = new Scanner(System.in);
        Libri libro1 = new Libri(1, faker.book().title(), LocalDate.of(2023, 4, 4), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), faker.book().genre());
        Libri libro2 = new Libri(2, faker.book().title(), LocalDate.of(2023, 5, 14), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), "fantasy");
        Libri libro3 = new Libri(3, faker.book().title(), LocalDate.of(2022, 7, 3), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), "horror");
        Libri libro4 = new Libri(4, faker.book().title(), LocalDate.of(2021, 12, 6), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), "thriller");
        Libri libro5 = new Libri(5, faker.book().title(), LocalDate.of(2018, 8, 17), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), "action");
        Libri libro6 = new Libri(6, faker.book().title(), LocalDate.of(2016, 10, 30), rndm.nextInt(50, 400), faker.lordOfTheRings().character(), "action");

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

        System.out.println("-----------ES1-------------");
        boolean isbnExists = false;
//        System.out.println("vuoi aggiungere un libro o una rivista? l/r");
//        String s = scn.nextLine();


//        if (s.equals("l")){
//            System.out.println("aggiungi un libro partendo dal nuovo codice univoco(ISBN):");
//            int newISBN = scn.nextInt();
//            scn.nextLine();
//            Iterator<Libri> isbniter = bookList.iterator();
//            while(isbniter.hasNext()){
//                Libri libroAdd = isbniter.next();
//                if (newISBN == libroAdd.getISBN()) {
//                    isbnExists = true;
//                    System.out.println("esiste già questo codice, riprova");
//                    break;
//                }
//                }
//            if (!isbnExists){
//                System.out.println("Inserisci il titolo:");
//                String newTitle = scn.nextLine();
//                System.out.println("inserisci la data di pubblicazione:");
//                System.out.println("giorno");
//                int day = scn.nextInt();
//                System.out.println("mese");
//                int month = scn.nextInt();
//                System.out.println("anno");
//                int year = scn.nextInt();
//                System.out.println("quante pagine ha il prodotto?");
//                int pages = scn.nextInt();
//                System.out.println("ho trovato autore e genere del tuo libro");
//                String author = faker.dragonBall().character();
//                String genres = faker.book().genre();
//
//                Libri nuovoLibro = new Libri(newISBN, newTitle, LocalDate.of(year, month, day), pages, author, genres);
//                System.out.println("ecco il tuo nuovo libro: " + nuovoLibro);
//                bookList.add(nuovoLibro);
//            }
//
//            scn.close();
//        } else if (s.equals("r")) {
//            System.out.println("aggiungi un rivista partendo dal nuovo codice univoco(ISBN):");
//            int newMagISBN = scn.nextInt();
//            scn.nextLine();
//            Iterator<Riviste> isbniterMag = magazineList.iterator();
//            while(isbniterMag.hasNext()){
//                Riviste magAdd = isbniterMag.next();
//                if (newMagISBN == magAdd.getISBN()) {
//                    isbnExists = true;
//                    System.out.println("esiste già questo codice, riprova");
//                    break;
//                }
//            }
//            if (!isbnExists){
//                System.out.println("Inserisci il titolo:");
//                String newMagTitle = scn.nextLine();
//                System.out.println("inserisci la data di pubblicazione:");
//                System.out.println("giorno");
//                int dayMag = scn.nextInt();
//                System.out.println("mese");
//                int monthMag = scn.nextInt();
//                System.out.println("anno");
//                int yearMag = scn.nextInt();
//                System.out.println("quante pagine ha il prodotto?");
//                int pagesMag = scn.nextInt();
//
//                Riviste nuovaRivista = new Riviste(newMagISBN, newMagTitle, LocalDate.of(yearMag, monthMag, dayMag), pagesMag, Periodicita.SETTIMANALE);
//                System.out.println("ecco la tua nuova rivista: " + nuovaRivista);
//                magazineList.add(nuovaRivista);
//            }
//        } else scn.close();

        System.out.println("-----------ES2-------------");
//                System.out.println("vuoi rimuovere elemento? s/n");
//        String a = scn.nextLine();
//
//        if (a.equals("s")){
//            System.out.println("inserisci il codice univoco(ISBN):");
//        int isbn = scn.nextInt();
//
//
//            Iterator<Prodotto> iterator = prodottoList.iterator();
//            while (iterator.hasNext()) {
//                Prodotto product = iterator.next();
//                if (isbn == product.getISBN()) {
//                    isbnExists = true;
//                    iterator.remove();
//                    System.out.println("hai rimosso l'elemento: " + product);
//                    break;
//                }
//            }
//            if (!isbnExists) {
//                System.out.println("errore: il libro con ISBN " + isbn + " non esiste nella lista.");
//            }
//        } else System.out.println("arrivederci");
//
//        prodottoList.forEach(System.out::println);

        System.out.println("-----------ES3-------------");
//        System.out.println("ricerca un elemento tramite il codice ISBN");
//        int searchISBN = scn.nextInt();
//        for (Prodotto product : prodottoList) {
//            if (searchISBN == product.getISBN()) {
//                isbnExists = true;
//                System.out.println("Elemento trovato:");
//                if (product instanceof Libri) {
//                    Libri libro = (Libri) product;
//                    System.out.println("Libro: " + libro);
//                } else if (product instanceof Riviste) {
//                    Riviste rivista = (Riviste) product;
//                    System.out.println("Rivista: " + rivista);
//                }
//                break;
//            }
//        }
//
//        if (!isbnExists) {
//            System.out.println("Errore: l'elemento con ISBN " + searchISBN + " non esiste nella lista.");
//        } else System.out.println("Arrivederci.");

        System.out.println("-----------ES4-------------");
        System.out.println("-----------ES5-------------");
//        System.out.println("ricerca per autore:");
//        String author = scn.nextLine();
//        boolean authorExist = false;
//        for (Prodotto product : prodottoList){
//            if(author.equals(product.getAuthor().toLowerCase())){
//                authorExist = true;
//                System.out.println("Autore trovato! " + author);
//            }else System.out.println("Autore non trovato"); break;
//        }
        System.out.println("-----------ES6/ES7-------------");
        File file = new File("src/fileLibrary.txt");
        try{
            //FileUtils.writeStringToFile(file, prodottoList.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            System.out.println("archivio scritto");
            FileUtils.writeStringToFile(file, bookList.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            //FileUtils.writeStringToFile(file, magazineList.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            System.out.println("--------------ES7-LETTURA---------------");
            String contenutoArchivio = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println(contenutoArchivio);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}


