package avventura.mondo;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Livello {
    int numLivello;
    ArrayList<Avventuriero> party;

    private int checkClass(String classe){
        for (int i = 0; i < party.size(); i++){
            if (party.get(i).getClass().getSimpleName().equals(classe)) return i;
        }
        return -1;
    }

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
