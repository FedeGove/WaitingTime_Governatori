package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GestoreFile extends Thread {
    String nomeFile;

    public GestoreFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    @Override
    public void run() {
        
    }

    public void leggi() {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(nomeFile));
            String riga;

            while ((riga = bufferedReader.readLine()) != null) {
                System.out.println(riga);
            }

        } catch (IOException ex) {
            System.err.println("Errore in lettura del file " + nomeFile);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ex) {
                System.err.println("Errore nella chiusura del file " + nomeFile);
            }
        }
    }
    
    public ArrayList<Canzone> leggiArrayListConGson() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeFile))) {

            Gson gson = new Gson();

            // Tipo specifico per ArrayList<Canzone>
            Type tipoArrayList = new TypeToken<ArrayList<Canzone>>() {}.getType();

            ArrayList<Canzone> canzoni = gson.fromJson(bufferedReader, tipoArrayList);

            return canzoni;
        } catch (Exception e) {
            System.err.println("Errore lettura JSON: " + e.getMessage());
            return null;
        }
    }

    public void scriviArrayListConGson(ArrayList<Canzone> canzoni) {
    
        try (FileWriter writer = new FileWriter(nomeFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(canzoni, writer); // Scrive l'ArrayList come JSON
            System.out.println("File JSON aggiornato correttamente!");
        } catch (IOException e) {
            System.err.println("Errore scrittura JSON: " + e.getMessage());
        }
    }

}       