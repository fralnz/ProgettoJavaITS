package umani;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Avventuriero {
    String nome, razza;
    char sesso;
    int eta;
    double danno, hp;

    public Avventuriero(String nome, String razza, char sesso, int eta) {
        this.nome = nome;
        this.razza = razza;
        if (sesso == 'm' || sesso == 'M' || sesso == 'f' || sesso == 'F')
            this.sesso = sesso;
        else this.sesso = 'x';
        this.eta = eta;
    }

    public Avventuriero(String nome, String razza) {
        this.nome = nome;
        this.razza = razza;
        this.sesso = 'x';
    }

    public Avventuriero(String nome, String razza, int eta) {
        this.nome = nome;
        this.razza = razza;
        this.eta = eta;
        this.sesso = 'x';
    }

    public Avventuriero() {
    }
    public static void partyInit(ArrayList<Avventuriero> party, int membriParty) {
        Scanner tastiera = new Scanner(System.in);  //definisco un nuovo scanner
        for (int i = 0; i < membriParty; i++) {
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
            if (!sessoInp.equalsIgnoreCase("m") && !sessoInp.equalsIgnoreCase("f")) {
                sesso = 'X';
            } else sesso = sessoInp.toUpperCase().charAt(0);
            // controllo che il carattere inserito sia accettato
            System.out.print("Inserisci l'eta (facoltativo): ");
            int eta = tastiera.nextInt();      // da implementare la gesitione delle eccezioni per renderla effettivamente facoltativa
            int scelta = 0;
            do {
                System.out.print("""
                        Inserisci la classe:
                        0) Aiuto
                        1) Barbaro
                        2) Mago
                        3) Druido
                        4) Domatore
                        """);
                scelta = tastiera.nextInt();
                if (scelta == 0) {
                    System.out.println("""
                            1) BARBARO: dotato di grande forza e resistenza
                            2) MAGO: capace di usare magia
                            3) DRUIDO: capace di curare e parlare con gli animali
                            4) DOMATORE: capace di addomesticare un animale e parlare con gli animali
                            ...
                            """);
                }
                // Tipo Statico: Avventuriero
                else if (scelta == 1) {
                    party.add(new Barbaro(nome, razza, sesso, eta));
                } else if (scelta == 2) {
                    party.add(new Mago(nome, razza, sesso, eta));
                } else if (scelta == 3) {
                    party.add(new Druido(nome, razza, sesso, eta));
                }
            } while (scelta < 1 || scelta > 4);
        }
        tastiera.nextLine();
    }
}