package com.example;

public class Canzone {
    private int id;
    private String title;
    private String artist;
    private String album;
    private int year;
    private int duration; // durata in secondi

    @Override
    public String toString() {
        return "Canzone " + id + ") Titolo: " + title + ", Artista: " + artist + ", Album: " + album + ", Anno: " + year + ", Durata: " + duration + "s";
    }
}