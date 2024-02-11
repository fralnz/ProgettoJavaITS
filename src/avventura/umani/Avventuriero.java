package avventura.umani;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Avventuriero implements Personaggio{
    String nome, razza, icona;
    char sesso;
    int eta;
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
            String nome;
            System.out.print("Inserisci il nome: ");
            do {
                nome = tastiera.nextLine();
            }while(nome.isEmpty());
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
            int scelta;
            do {
                System.out.print("""
                        Inserisci la classe:
                        0) Aiuto
                        1) Barbaro
                        2) Mago
                        3) Druido
                        4) Domatore
                        5) Ladro
                        """);
                scelta = tastiera.nextInt();
                if (scelta == 0) {
                    System.out.println("""
                            1) BARBARO: dotato di grande forza e resistenza
                            2) MAGO: capace di usare magia
                            3) DRUIDO: capace di curare e parlare con gli animali
                            4) DOMATORE: capace di addomesticare un animale e parlare con gli animali
                            5) LADRO: capace di rubare
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
                } else if (scelta == 4) {
                    party.add(new Domatore(nome, razza, sesso, eta));
                } else if (scelta == 5) {
                    party.add(new Ladro(nome, razza, sesso, eta));
                }
            } while (scelta < 1 || scelta > 5);
            tastiera.nextLine();
        }
    }

    public static void randomParty(ArrayList<Avventuriero> party, int membriParty){
        if (membriParty<1 || membriParty>5){
            throw new RuntimeException("Numero di membri non valido! (1 <= membriParty <= 5)");
        }
        // genero un arraylist di avventurieri casuali
        ArrayList<Avventuriero> avventurieriCasuali = new ArrayList<>();
        avventurieriCasuali.add(new Mago("Pablo", "Elfo", 'M', 107));
        avventurieriCasuali.add(new Ladro("Erika", "Umano", 'F', 32));
        avventurieriCasuali.add(new Barbaro("Enrico", "Orco", 'M', 48));
        avventurieriCasuali.add(new Domatore("Andrea", "Umano", 'X', 19));
        avventurieriCasuali.add(new Druido("Peter", "Gnomo", 'F', 85));
        // scelgo a caso avventurieri da avventurieriCasuali e li metto in party
        for (int i = 0; i < membriParty; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(0, avventurieriCasuali.size());
            party.add(avventurieriCasuali.get(randomNum));
            avventurieriCasuali.remove(avventurieriCasuali.get(randomNum));
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getIcona() {
        return icona;
    }

    public void setIcona(String icona) {
        this.icona = icona;
    }

    @Override
    public String toString() {
        return  icona + nome + "(" +
                razza + ", " + sesso +
                ", " + eta + " anni, )";
    }
}