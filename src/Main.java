import static umani.Avventuriero.*;

import umani.Avventuriero;
import umani.Barbaro;
import umani.Druido;
import umani.Mago;

import java.util.ArrayList;
import java.util.Scanner;

/*
Traccia: RPG
*/
public class Main {
    public static void main(String[] args) {
        // inizializzo le variabili
        int giorno = 1;     //inizializzo i giorni
        int membriParty = 3;
        Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
        ArrayList<Avventuriero> party = new ArrayList<Avventuriero>();
        // messaggio di benvenuto
        System.out.println("Inserisci tre avventurieri:");
        // Il tipo statico è Avventuriero
        umani.Avventuriero.partyInit(party, membriParty);
        System.out.println(party);
    }
}