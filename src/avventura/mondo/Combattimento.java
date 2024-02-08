package avventura.mondo;

import avventura.mostri.Mostro;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
import java.util.Random;

public class Combattimento {
    public static ArrayList<Mostro> generaNemici(int numGiorno){
        Random rand = new Random();
        int numNemici = rand.nextInt(3)+1;
        ArrayList<Mostro> nemici = new ArrayList<>(3);
        for (int i=0; i<numNemici; i++){
            // Ripempio l'arraylist di mostri casuali
            nemici.add(new Mostro(numGiorno));
        }
        return nemici;
    }
    public static void displayCombattimento(ArrayList<Mostro> nemici, ArrayList<Avventuriero> party) {
        int numNemici = nemici.size();
        int numAvventurieri = party.size();

        // Stampa il nome dei mostri o spazi vuoti se non ci sono abbastanza mostri
        for (int i = 0; i < numAvventurieri; i++) {
            if (i < numNemici) {
                System.out.print("----" + nemici.get(i).getNome());
            } else {
                System.out.print("----");
            }
        }
        System.out.println("----");

        // Stampa il danno dei nemici sotto le loro icone
        for (int i = 0; i < numAvventurieri; i++) {
            if (i < numNemici) {
                System.out.print("    " + nemici.get(i).getDanno());
                if (nemici.get(i).getDanno() < 10) System.out.print(' ');
            }
        }
        System.out.println();

        // Stampa la riga vuota tra i nomi dei mostri e degli avventurieri
        for (int i = 0; i < numAvventurieri; i++) {
            System.out.print("   ");
        }
        System.out.println("⚔\uFE0F");

        // Stampa il danno degli avventurieri sopra le loro icone
        for (int i = 0; i < numAvventurieri; i++) {
            System.out.print("    " + party.get(i).getDanno());
            if (party.get(i).getDanno() < 10) System.out.print(' ');
        }
        System.out.println();

        // Stampa il nome degli avventurieri o spazi vuoti se non ci sono abbastanza avventurieri
        for (int i = 0; i < numAvventurieri; i++) {
            System.out.print("----" + party.get(i).getIcona());
        }
        System.out.println("----");
    }
}

/*
COMBATTIMENTO

----👺----👻----🧌----
    6      4     3
          ⚔️️
    6      4     3
----🪓----🗡️----🪄----
 */