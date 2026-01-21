package com.example;

import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<Canzone> canzoni = gestore.leggiArrayListConGson();

        Scanner scanner = new Scanner(System.in);

        gestore.start();

        System.out.println("----------------------------- BENVENUTO --------------------------------");
        System.out.println("------- Sviluppatori: Federico Governatori il capo di San Sisto --------");
        System.out.println("------------------------------------------------------------------------");
        System.out.println();

        int seconds = 5;

        try {
            for (int i = seconds; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000); // Pausa di 1 secondo
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Conto alla rovescia interrotto.");
        }

        for (Canzone c : canzoni) {
            System.out.println(c);
        }

        System.out.println("Vuoi aggiungere una nuova canzone? (s/n)");
        String risposta = scanner.nextLine();

        while (risposta.equalsIgnoreCase("s")) {
            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();
            
            System.out.print("Artista: ");
            String artista = scanner.nextLine();
    
            System.out.print("Album: ");
            String album = scanner.nextLine();

            System.out.print("Anno: ");
            int anno = Integer.parseInt(scanner.nextLine());
    
            System.out.print("Durata (secondi): ");
            int durata = Integer.parseInt(scanner.nextLine());

            // Generiamo un id automatico incrementale
            int id = canzoni.size() + 1;
            Canzone nuovaCanzone = new Canzone(id, titolo, artista, album, anno, durata);
            canzoni.add(nuovaCanzone);

            System.out.println("Canzone aggiunta!");

            System.out.println("Vuoi aggiungere un'altra canzone? (s/n)");
            risposta = scanner.nextLine();
        }

        // Aggiornamento File Json
        gestore.scriviArrayListConGson(canzoni);
    }
}
