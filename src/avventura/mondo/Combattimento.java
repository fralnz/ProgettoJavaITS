package avventura.mondo;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Francesco Lanza
 * @version 1.0
 */

public class Combattimento {
    /**
     * Genera un arraylist di 3 Mostri, ognuno con danno casuale e scalato con il livello
     * @param livello il livello con cui scalare il danno generato dai nemici
     * @return L'arraylist di Mostri generato
     */
    public static ArrayList<Mostro> generaNemici(int livello){
        Random rand = new Random();
        int numNemici = rand.nextInt(3)+1;
        ArrayList<Mostro> nemici = new ArrayList<>(3);
        for (int i=0; i<numNemici; i++){
            // Ripempio l'arraylist di mostri casuali
            nemici.add(new Mostro(livello));
        }
        return nemici;
    }

    /**
     * Inizia las fase di combattimento e stampa tutti i danni dei nemici e del party del giocatore
     * @param party L'arraylist di avventurieri del giocatore
     * @param nemici L'arraylist di mostri che deve sconfiggere il giocatore
     * @return True se il giocatore ha vinto, False se il giocatore ha perso
     * @throws InterruptedException Generato dalla funzione sleep
     */
    public static boolean combattimento(ArrayList<Avventuriero> party, ArrayList<Mostro> nemici) throws InterruptedException {
        // Metti gli attacchi qua
        Scanner tastiera = new Scanner(System.in);
        int dannoNemici = 0;
        int dannoParty = 0;
        int dannoCurato = 0;
        // controllo se il party ha un domatore
        int idxDomatore = -1;
        for (int i=0; i<party.size(); i++){if (party.get(i).getClass().getSimpleName().equals("Domatore")) idxDomatore = i;}
        // Inizia il combattimento
        System.out.println("---INIZIO COMBATTIMENTO---");
        System.out.println("TURNO DEI NEMICI");
        for (Mostro mostro : nemici) {
            dannoNemici += mostro.getDanno();
            System.out.println(mostro.getIcona() + " attacca! Danno: " + mostro.getDanno());
            // se nel party è presente un domatore, prova a domesticare il mostro
            if (idxDomatore != -1 && mostro.getIcona().equals("\uD83D\uDC3A")){
                System.out.println(party.get(idxDomatore).getNome()+" può addomesticarlo. Vuoi addomesticarlo? (s/N)");
                System.out.println("Danno attuale di "+party.get(idxDomatore).getNome()+": "+party.get(idxDomatore).attacco());
                String scelta = tastiera.nextLine();
                if (scelta.equalsIgnoreCase("s")) {
                    party.get(idxDomatore).equip(mostro.getDanno());
                    dannoNemici -= mostro.getDanno();
                    mostro.setDanno(0);
                } else {
                    System.out.println("Non addomesticato.");
                }
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("TURNO DEGLI AVVENTURIERI");
        ArrayList<Integer> attacchiParty = new ArrayList<>();
        for (Avventuriero membro : party) {
            int dannoMembro = membro.attacco();
            attacchiParty.add(dannoMembro);
            if (dannoMembro >= 0){
                dannoParty += dannoMembro;
                System.out.println(membro.getNome() + " attacca! Danno: " + dannoMembro);
            } else {
                dannoCurato -= membro.attacco();
                System.out.println(membro.getNome() + " cura! Danno curato: " + membro.attacco()*(-1));
            }
            TimeUnit.SECONDS.sleep(1);
        }
        displayCombattimento(nemici, party, attacchiParty);
        System.out.print("Danno mostri: \u001B[31m"+dannoNemici+"\u001B[0m");
        if (dannoCurato > 0) System.out.print(" - \u001B[32m"+dannoCurato+"\u001B[0m");
        System.out.println("\nDanno party: \u001B[31m"+dannoParty+"\u001B[0m");
        if (dannoParty > (dannoNemici-dannoCurato)){
            System.out.println("Hai vinto!");
            return true;
        } else if (dannoParty == (dannoNemici-dannoCurato)) {
            System.out.println("Pareggio! Premi invio per lanciare una moneta.");
            tastiera.nextLine();
            for (int i = 0; i < 3; i++){
                System.out.print('.');
                TimeUnit.SECONDS.sleep(1);
            }
            if ((new Random()).nextInt(2) == 0){
                System.out.println("Hai vinto!");
                return true;
            }
            // non ho bidogno di un else in quanto se non ritorno passa direttamente al caso in cui si perde
        }
        System.out.println("Hai perso!\n---GAME OVER---");
        return false;
    }

    /**
     * Stampa un disegno in ascii+unicode del combattimento, raffigurante il lato nemico (sopra), il lato del giocatore (sotto) e il danno di ogni combattente
     * Esempio:
     * ----👺----👻----🧌----
     *     6      4     3
     *           ⚔️️
     *     6      4     3
     * ----🪓----🗡️----🪄----
     * @param nemici Arraylist dei Mostri nemici
     * @param party Arraylist degli Avventurieri del giocatore
     * @param attacchiParty Arraylist di interi contenente i danni del party
     */
    private static void displayCombattimento(ArrayList<Mostro> nemici, ArrayList<Avventuriero> party, ArrayList<Integer> attacchiParty) {
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
        System.out.println("⚔️");

        // Stampa il danno degli avventurieri sopra le loro icone
        for (int i = 0; i < numAvventurieri; i++) {
            System.out.print("    ");
            if (attacchiParty.get(i) > 0){
                System.out.print(attacchiParty.get(i));
            }else {
                System.out.print("\u001B[32m"+(attacchiParty.get(i)*-1)+"\u001B[0m");
            }
            if (attacchiParty.get(i) < 10) System.out.print(' ');
        }
        System.out.println();

        // Stampa il nome degli avventurieri o spazi vuoti se non ci sono abbastanza avventurieri
        for (int i = 0; i < numAvventurieri; i++) {
            System.out.print("----" + party.get(i).getIcona());
        }
        System.out.println("----");
    }
}