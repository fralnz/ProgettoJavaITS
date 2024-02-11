package avventura;

import avventura.umani.Avventuriero;

import java.util.ArrayList;

/*
Classe contenente tutti i metodi di stampa menu
 */
public class ui {
    public static void stampaMessaggioIniziale(){
        System.out.print("""
                ┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                ┃        Benvenuto!        ┃
                ┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫
                ┃0. Istruzioni             ┃
                ┃1. Partita personalizzata ┃
                ┃2. Partita casuale        ┃
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                """);
    }
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
    public static void stampaParty(ArrayList<Avventuriero> party){
        System.out.println("━━━━━━━━━━━━━━━━");
        System.out.println("IL TUO PARTY:");
        for (Avventuriero membro : party){
            System.out.println(membro);
        }
        System.out.println("━━━━━━━━━━━━━━━━");
    }

}
