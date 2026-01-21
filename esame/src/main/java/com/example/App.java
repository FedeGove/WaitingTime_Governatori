package com.example;

import java.util.ArrayList;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        String nomeFile = "canzoni.json";

        GestoreFile gestore = new GestoreFile(nomeFile);

        gestore.start();

        System.out.println("Thread avviato...");

        ArrayList<Canzone> canzoni = gestore.leggiArrayListConGson();

        for (Canzone c : canzoni) {
            System.out.println(c);
        }
    }
}
