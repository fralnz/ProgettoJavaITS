package avventura.mondo;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Francesco Lanza
 * @version 1.0
 */

public class Livello {
    int numLivello;
    ArrayList<Avventuriero> party;

    /**
     * Controlla se nel party e' presente un Avventuriero della classe inserita
     * @param classe Nome della classe che si desidera controllare
     * @return Indice del membro trovato nel party. -1 se non trovato
     */
    private int checkClass(String classe){
        for (int i = 0; i < party.size(); i++){
            if (party.get(i).getClass().getSimpleName().equals(classe)) return i;
        }
        return -1;
    }

    /**
     * Viene generata un arma casuale e controlla se un membro del party puo' equipaggiarla
     */
    public void GeneraEvento(){
        String classe, arma;
        int amount = 0;
        Random rand = new Random();
        int nEvento = ThreadLocalRandom.current().nextInt(0, 4);
        if (nEvento == 0){
            classe = "Barbaro";
            arma = "ascia";
            amount = rand.nextInt(10)+ numLivello;
        } else if (nEvento == 1) {
            classe = "Ladro";
            arma = "coltello";
            amount = rand.nextInt(7)+1;
        } else if (nEvento == 2) {
            classe = "Mago";
            arma = "pergamena";
            amount = rand.nextInt(5) + 1;
        } else if (nEvento == 3) {
            classe = "Druido";
            arma = "ricetta";
            amount = rand.nextInt(5) + 1;
        } else {
            System.out.println("ERRORE!");
            classe = "Err";
            arma = "Err";
        }
        System.out.println("Hai trovato un "+arma+"! (potenza: +" + amount + ")");
        try{
            party.get(checkClass(classe)).equip(amount);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Nessun membro del tuo party può usarlo.");
        }
    }
    public Livello(ArrayList<Avventuriero> party) {
        this.numLivello = 1;
        this.party = party;
    }

    public int getNumLivello() {
        return numLivello;
    }

    public void setNumLivello(int numLivello) {
        this.numLivello = numLivello;
    }

    public ArrayList<Avventuriero> getParty() {
        return party;
    }

    public void setParty(ArrayList<Avventuriero> party) {
        this.party = party;
    }

    public void avanzaLivello(){
        setNumLivello(getNumLivello()+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livello giorno)) return false;
        return Objects.equals(party, giorno.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numLivello, numLivello, party);
    }
}
