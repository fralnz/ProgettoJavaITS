package avventura.mondo;

import avventura.mostri.Mostro;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    public static void inizaCombattimento(ArrayList<Avventuriero> party, ArrayList<Mostro> nemici) throws InterruptedException {
        // Metti gli attacchi qua
        Scanner tastiera = new Scanner(System.in);
        int dannoNemici = 0;
        int dannoParty = 0;
        int dannoCurato = 0;
        // controllo se il party ha un domatore
        int idxDomatore = -1;
        for (int i=0; i<party.size(); i++){if (party.get(i).getClass().getSimpleName().equals("Domatore")) idxDomatore = i;};
        // Inizia il combattimento
        System.out.println("---INIZIO COMBATTIMENTO---");
        System.out.println("TURNO DEI NEMICI");
        for (Mostro mostro : nemici) {
            dannoNemici += mostro.getDanno();
            System.out.println(mostro.getIcona() + " attacca! Danno: " + mostro.getDanno());
            // se nel party è presente un domatore, prova a domesticare il mostro
            if (idxDomatore != -1){
                System.out.println(party.get(idxDomatore).getNome()+" può addomesticarlo.Vuoi addomesticarlo? (s/N)");
                System.out.print("Danno attuale di "+party.get(idxDomatore).getNome()+": "+party.get(idxDomatore).attacco());
                String scelta = tastiera.nextLine();
                if (scelta.equalsIgnoreCase("s")) {
                    party.get(idxDomatore).equip(mostro.getDanno());
                    dannoNemici -= mostro.getDanno();
                } else {
                    System.out.println("Non addomesticato.");
                }
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("TURNO DEGLI AVVENTURIERI");
        for (Avventuriero membro : party) {
            if (membro.attacco() >= 0){
                dannoParty += membro.attacco();
                System.out.println(membro.getNome() + " attacca! Danno: " + membro.attacco());
            } else {
                dannoCurato -= membro.attacco();
                System.out.println(membro.getNome() + " cura! Danno curato: " + membro.attacco()*(-1));
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.print("Danno mostri: "+dannoNemici);
        if (dannoCurato > 0) System.out.print(" - "+dannoCurato);
        System.out.print("\nDanno party: "+dannoParty);
        if (dannoParty > (dannoNemici-dannoCurato)){
            System.out.println("Hai vinto!");
        }else {
            System.out.println("Hai perso!\nGAME OVER");
        }
    }
    public static void displayCombattimento(ArrayList<Mostro> nemici, ArrayList<Avventuriero> party) {
        int numNemici = nemici.size();
        int numAvventurieri = party.size();

        // Stampa il nome dei mostri o spazi vuoti se non ci sono abbastanza mostri
        for (int i = 0; i < numAvventurieri; i++) {
            if (i < numNemici) {
                System.out.print("----" + nemici.get(i).getIcona());
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
            System.out.print("    ");
            if (party.get(i).attacco() > 0){
                System.out.print(party.get(i).attacco());
            }else {
                System.out.print('0');
            }
            if (party.get(i).attacco() < 10) System.out.print(' ');
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