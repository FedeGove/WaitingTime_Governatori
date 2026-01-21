package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GestoreFile extends Thread {
    String nomeFile;

    public GestoreFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    @Override
    public void run() {
        leggi();
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
}
