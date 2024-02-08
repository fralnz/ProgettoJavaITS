import avventura.mondo.Giorno;
import avventura.umani.*;

import java.util.ArrayList;
import java.util.Scanner;

/*
Traccia: RPG
L'utente ha un party di 3 avventurieri, deve passare 10 giornate
Ogni giorno genera 3 eventi casuali, ognuno con le sue opportunità.

*/
public class Main {
    public static void main(String[] args) {
        // inizializzo le variabili
        int giorno = 1;  //inizializzo i giorni
        int membriParty = 1;
        Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
        ArrayList<Avventuriero> party = new ArrayList<Avventuriero>();
        // messaggio di benvenuto
        System.out.println("\uD83D\uDC7B Inserisci tre avventurieri:");
        // Il tipo statico è Avventuriero
        avventura.umani.Avventuriero.partyInit(party, membriParty);
        System.out.println(party);
        // Inizio dell'avventura
        Giorno viaggio = new Giorno(party);
        for (int i=0; i<10; i++){
            viaggio.GeneraEvento();
            System.out.println("Premi invio per continuare...");
            tastiera.nextLine();
            viaggio.GeneraCombattimento();
            viaggio.avanzaGiorno();
            System.out.println("Premi invio per continuare...");
            tastiera.nextLine();
        }
    }
}