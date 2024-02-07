import umani.Avventuriero;
import umani.Barbaro;
import umani.Druido;
import umani.Mago;

import java.util.Scanner;
import static umani.Avventuriero.partyInit;

/*
Traccia: RPG
*/
public class Main {
    public static void main(String[] args) {
        // inizializzo le variabili
        int giorno = 1;     //inizializzo i giorni
        Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
        // messaggio di benvenuto
        System.out.println("Benvenuto!");
        System.out.println("Inserisci tre avventurieri:");
        // Il tipo statico è Avventuriero
        Avventuriero membro1 = partyInit();
        System.out.println(membro1);
        /*
        Avventuriero membro2 = partyInit();
        Avventuriero membro3 = partyInit();
        System.out.println(membro2);
        System.out.println(membro3);

         */
    }
}