package com.example;

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
    }
}
