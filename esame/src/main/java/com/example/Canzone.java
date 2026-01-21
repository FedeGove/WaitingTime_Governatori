package com.example;

public class Canzone {
    private int id;
    private String title;
    private String artist;
    private String album;
    private int year;
    private int duration; // durata in secondi

    public Canzone(int id, String title, String artist, String album, int year, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Canzone " + id + ") Titolo: " + title + ", Artista: " + artist + ", Album: " + album + ", Anno: " + year + ", Durata: " + duration + "s";
    }
}