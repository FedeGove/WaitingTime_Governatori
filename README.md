# Applicazione Java Multithreading con JSON

## Descrizione
Questo progetto realizza un’applicazione **Java multithreading** che consente di:

- Inserire da tastiera i dati relativi a più oggetti dello stesso tipo.  
- Leggere dati da un file JSON locale e visualizzarli sullo standard output.  
- Aggiornare un file JSON con nuove istanze di oggetti aggiunti dall’utente.  

L’applicazione sfrutta i principi della **programmazione orientata agli oggetti (OOP)** e segue gli standard di settore per lo sviluppo di software in team.

---

## Struttura del progetto

### 1. `Canzone.java`
Classe che rappresenta un oggetto **Canzone** con attributi:
- `id`  
- `title`  
- `artist`  
- `album`  
- `year`  
- `duration`  

Serve come modello per la lettura e scrittura dei dati nel file JSON.

---

### 2. `GestoreFile.java`
Classe responsabile della gestione del file JSON, con metodi principali:

#### a) Lettura tramite **BufferedReader**
```java
public void leggi() { ... }
```

#### b) Lettura tramite **Gson**
```java
public ArrayList<Canzone> leggiArrayListConGson() { ... }
```
Legge il JSON e crea istanze di Canzone, restituendo una lista dinamica (ArrayList<Canzone>).

#### c) Scrittura tramite **Gson**
```java
public void scriviArrayListConGson(ArrayList<Canzone> canzoni) { ... }
```
Aggiorna il file JSON con nuove canzoni, mantenendo il formato leggibile grazie a GsonBuilder().setPrettyPrinting().

---

### 3. `Main.java`
Classe principale dell’applicazione. Funzionalità principali:

Mostra un messaggio di benvenuto con il nome degli sviluppatori.

Esegue un conto alla rovescia di 5 secondi prima dell’inizio dell’interazione, usando Thread.sleep().

Visualizza le canzoni già presenti nel file JSON.

Permette all’utente di inserire nuove canzoni da tastiera, aggiungendole a una lista dinamica.

Alla fine, aggiorna il file JSON con le nuove istanze inserite dall’utente.
