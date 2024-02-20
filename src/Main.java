import avventura.mondo.Mostro;
import avventura.mondo.*;
import avventura.umani.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Francesco Lanza
 * @version 1.0
 */
/*
Traccia: RPG
L'utente ha un party di 3 avventurieri, deve passare 10 giornate
Ogni giorno genera 3 eventi casuali, ognuno con le sue opportunità.

TODO: aggiungere la javadoc
*/
public class Main {
    private static int inserisciNumero(Scanner tastiera){
        try{
            return Integer.parseInt(tastiera.nextLine());
        }catch(Exception e){
            System.out.println("Input non valido. Inserisci un numero.");
        }
        // se l'input non è valido ritorno -1. A me va bene perchè non uso mai -1 nel main.
        return -1;
    }
    public static void main(String[] args) throws InterruptedException {
        // inizializzo le variabili
        boolean gioca, vittoria = false;
        int scelta = 0;
        int membriParty = 3;
        // inizio il ciclo do while contenente il gioco
        do {
            Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
            // definisco l'arraylist contenente il party del giocatore
            ArrayList<Avventuriero> party = new ArrayList<Avventuriero>();
            avventura.ui.stampaMessaggioIniziale();
            // faccio inserire dell'utente un numero in input tra 0 e 2
            do {
                scelta = inserisciNumero(tastiera);
                if (scelta == 0) {
                    // stampo le istruzioni del gioco all'utente
                    avventura.ui.stampaIstruzioni();
                }
            } while (scelta < 1 || scelta > 2);
            if (scelta == 1) {
                // Faccio inserire 3 avventurieri all'utente
                System.out.println("\uD83D\uDC7B Inserisci tre avventurieri:");
                // Il tipo statico è Avventuriero
                avventura.Metodi.partyInit(party, membriParty);
            } else {
                // il party viene riempito casualmente
                avventura.Metodi.randomParty(party, membriParty);
            }
            avventura.ui.stampaParty(party);
            System.out.println("Premi invio per continuare...");
            tastiera.nextLine();
            // Inizio dell'avventura
            Livello viaggio = new Livello(party);
            // il gioco è composto da 10 livelli
            for (int i = 0; i < 10; i++) {
                // stampo il numero del livello in blu e grassetto
                System.out.println("\u001B[1;34mLIVELLO " + viaggio.getNumLivello()+"\u001B[0m");
                // genero l'evento in cui si ottiene equipaggiamento
                viaggio.GeneraEvento();
                System.out.println("Premi invio per continuare...");
                tastiera.nextLine();
                // genero l'array di mostri e li stampo a schermo
                ArrayList<Mostro> nemici = Combattimento.generaNemici(viaggio.getNumLivello());
                avventura.ui.stampaNemici(nemici);
                // la variabile vittoria è true se il combattimento è terminato con la vittoria del giocatore, altrimenti false
                vittoria = Combattimento.combattimento(party, nemici);
                // se il giocatore ha perso esci dal ciclo
                if (!vittoria) break;
                viaggio.avanzaLivello();
                System.out.println("Premi invio per continuare...");
                tastiera.nextLine();
            }
            // se il giocatore ha vinto, stampa un messaggio di vittoria
            if (vittoria) avventura.ui.stampaVittoria(party);
            // chiedi di giocare di nuovo
            System.out.println("Vuoi giocare di nuovo? (s/N)");
            gioca = tastiera.nextLine().equals("s");
        }while (gioca);
    }
}