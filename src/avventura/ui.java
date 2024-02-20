package avventura;

import avventura.mondo.Mostro;
import avventura.umani.Avventuriero;

import java.util.ArrayList;

/**\
 * Classe contenente tutti i metodi di stampa menu
 * @author Francesco Lanza
 * @version 1.0
 */
public class ui {
    /**
     * Stampa il menu iniziale
     */
    public static void stampaMessaggioIniziale(){
        System.out.print("""
                ┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                ┃        \u001B[1mBenvenuto!\u001B[0m        ┃
                ┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫
                ┃\u001B[33m0\u001B[0m. Istruzioni             ┃
                ┃\u001B[33m1\u001B[0m. Partita personalizzata ┃
                ┃\u001B[33m2\u001B[0m. Partita casuale        ┃
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                """);
    }

    /**
     * Stampa le istruzioni del gioco
     */
    public static void stampaIstruzioni(){
        System.out.print("""
                ---ISTRUZIONI---
                Il giocatore controlla un party composto da tre avventurieri.
                Il party si puo' creare da zero selezionando "Partita personalizzata" (opzione 1), oppure si puo' partire con un party gia' fatto e composto casualmente selezionando "Partita casuale" (opzione 2)
                Nel caso in cui si desideri personalizzare il party, l'utente puo' decidere Il nome, la razza, il sesso, l'eta', e la classe dell'avventuriero (solo quest'ultima ha un impatto sul gioco).
                Ogni partita e' composta da 10 livelli, ognuno dei quali e' diviso in due parti: un evento casuale e il combattimento.
                Evento casuale: il party trova un'arma generata casualmente, e puo' decidere se equipaggiarla o no (equivale a un potenziamento di un avventuriero).
                Combattimento: il party dovra' affrontare una squadra composta da 1 a 3 mostri, ognuno dei quali infliggera' un danno, anch'esso generato casualmente. Il danno dei mostri aumentera' con il progredire dei livelli.
                Se l'attacco totale del party e' superiore a quello dei nemici, il livello e' vinto, altrimenti e' GAME OVER.
                Al termine dei 10 livelli il giocatore ha vinto.
                ----------------
                Seleziona un'opzione:
                """);
    }

    /**
     * Stampa un arraylist di Avventurieri
     * @param party l'arraylist di Avventurieri che deve essere stampato
     */
    public static void stampaParty(ArrayList<Avventuriero> party){
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("IL TUO PARTY:");
        for (Avventuriero membro : party){
            System.out.println(membro);
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
    /**
     * Stampa un arraylist di Mostri
     * @param nemici l'arraylist di Mostri che deve essere stampato
     */
    public static void stampaNemici(ArrayList<Mostro> nemici){
        System.out.println("Hai incontrato dei nemici!");
        String out = "";
        for (Mostro mostro : nemici){
            out += mostro.getIcona() + ", ";
        }
        System.out.println(out.substring(0, out.length()-2));
    }
    /**
     * Stampa il messaggio di vittoria a fine gioco (richiama stampaParty)
     * @param party l'arraylist di Avventurieri che deve essere stampato tramite stampaParty
     */
    public static void stampaVittoria(ArrayList<Avventuriero> party){
        System.out.println("""
                \u001B[1m---HAI VINTO!---\u001B[0m
                Congratulazioni! La tua squadra di avventurieri è riuscita a superare 10 livelli!
                Ecco i valorosi eroi:""");
        stampaParty(party);
    }
}
