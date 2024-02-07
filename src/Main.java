import umani.Avventuriero;
import umani.Barbaro;
import umani.Druido;
import umani.Mago;

import java.util.Scanner;

/*
Traccia: RPG
*/
public class Main {
    private static Avventuriero partyInit(){
        Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
        System.out.print("Inserisci il nome: ");
        String nome = tastiera.nextLine();
        System.out.print("Inserisci la razza: ");
        String razza = tastiera.nextLine();
        System.out.print("""
                Inserisci il sesso (m/f)
                (facoltativo)
                """);
        char sesso;
        String sessoInp = tastiera.nextLine();
        if (!sessoInp.equalsIgnoreCase("m") && !sessoInp.equalsIgnoreCase("f")){
            sesso = 'X';
        } else sesso = sessoInp.toUpperCase().charAt(0);
        // controllo che il carattere inserito sia accettato
        System.out.print("Inserisci l'eta (facoltativo): ");
        int eta = tastiera.nextInt();      // da implementare la gesitione delle eccezioni per renderla effettivamente facoltativa
        boolean ripeti;
        do {
            ripeti = false;
            System.out.print("""
                    Inserisci la classe:
                    0) Aiuto
                    1) Barbaro
                    2) Mago
                    3) Druido
                    4) Domatore
                    """);
            int scelta = tastiera.nextInt();
            if (scelta == 0){
                System.out.println("""
                        1) BARBARO: dotato di grande forza e resistenza
                        2) MAGO: capace di usare magia
                        3) DRUIDO: capace di curare e parlare con gli animali
                        4) DOMATORE: capace di addomesticare un animale e parlare con gli animali
                        ...
                        """);
                ripeti = true;
            }
            else if (scelta == 1) {
                return new Barbaro(nome, razza, sesso, eta);
            } else if (scelta == 2) {
                return new Mago(nome, razza, sesso, eta);
            } else if (scelta == 3) {
                return new Druido(nome, razza, sesso, eta);
            }
        } while (ripeti);
        return new Barbaro();
    }
    public static void main(String[] args) {
        // inizializzo le variabili
        int giorno = 1;     //inizializzo i giorni
        Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
        // messaggio di benvenuto
        System.out.println("Benvenuto!");
        System.out.println("Inserisci tre avventurieri:");
        Avventuriero membro1 = partyInit();
        /*
        Avventuriero membro2 = partyInit();
        Avventuriero membro3 = partyInit();
        System.out.println(membro1);
        System.out.println(membro2);
        System.out.println(membro3);

         */
    }
}