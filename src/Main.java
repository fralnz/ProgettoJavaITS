import avventura.mondo.Mostro;
import avventura.mondo.*;
import avventura.umani.*;

import java.util.ArrayList;
import java.util.Scanner;

/*
Traccia: RPG
L'utente ha un party di 3 avventurieri, deve passare 10 giornate
Ogni giorno genera 3 eventi casuali, ognuno con le sue opportunità.

TODO: aggiungere la javadoc
*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // inizializzo le variabili
        boolean gioca;
        int scelta = 0;
        int membriParty = 3;
        do {
            Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
            ArrayList<Avventuriero> party = new ArrayList<Avventuriero>();
            avventura.ui.stampaMessaggioIniziale();
            do {
                scelta = tastiera.nextInt();
                if (scelta == 0) {
                    avventura.ui.stampaIstruzioni();
                }
            } while (scelta < 1 || scelta > 2);
            if (scelta == 1) {
                // messaggio di benvenuto
                System.out.println("\uD83D\uDC7B Inserisci tre avventurieri:");
                // Il tipo statico è Avventuriero
                avventura.umani.Avventuriero.partyInit(party, membriParty);
            } else if (scelta == 2) {
                avventura.umani.Avventuriero.randomParty(party, membriParty);
            }
            avventura.ui.stampaParty(party);
            // Inizio dell'avventura
            Livello viaggio = new Livello(party);
            for (int i = 0; i < 10; i++) {
                System.out.println("LIVELLO " + viaggio.getNumLivello());
                viaggio.GeneraEvento();
                System.out.println("Premi invio per continuare...");
                tastiera.nextLine();
                ArrayList<Mostro> nemici = Combattimento.generaNemici(viaggio.getNumLivello());
                avventura.ui.stampaNemici(nemici);
                if (!Combattimento.inizaCombattimento(party, nemici)) break;
                viaggio.avanzaLivello();
                System.out.println("Premi invio per continuare...");
                tastiera.nextLine();
            }
            avventura.ui.stampaVittoria(party);
            System.out.println("Vuoi giocare di nuovo?");
            gioca = tastiera.nextLine().equals("s");
        }while (gioca);
    }
}