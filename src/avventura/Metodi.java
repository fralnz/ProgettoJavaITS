package avventura;
/**
 * @author Francesco Lanza
 * @version 1.0
 */

import avventura.umani.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**\
 * Classe contenente metodi chiamati dal main
 * @author Francesco Lanza
 * @version 1.0
 */

public class Metodi {
    /**
     * Fa inserire all'utente un input e, se questo non e' un numero ritorna -1
     * @param tastiera scanner da passare come parametro
     * @return
     */
    public static int inserisciNumero(Scanner tastiera){
        try{
            return Integer.parseInt(tastiera.nextLine());
        }catch(Exception e){
            System.out.println("Input non valido. Inserisci un numero.");
        }
        // se l'input non è valido ritorno -1. A me va bene perchè non uso mai -1 nel main.
        return -1;
    }

    /**
     * Controlla che nell'arraylist di Avventuriero sia presente un membro il cui nome del tipo dinamico corrisponda a una stringa
     * @param party Arraylist di Avventuriero da controllare
     * @param nomeClasse nome della classe da controllare
     * @return true se il controllo e' vero, altrimenti false
     */
    private static boolean checkPartyClass(ArrayList<Avventuriero> party, String nomeClasse){
        for (Avventuriero membro : party){
            if (nomeClasse.equalsIgnoreCase(membro.getClass().getSimpleName())) return true;
        }
        return false;
    }

    /**
     * Si chiede all'utente di riempire un arraylist di oggetti di classe avventuriero
     * @param party Il party che dovra' essere riempito
     * @param membriParty Il numero di membri che deve contenere il party
     */
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
                String classe = switch (scelta) {
                    case 1 -> "Barbaro";
                    case 2 -> "Mago";
                    case 3 -> "Druido";
                    case 4 -> "Domatore";
                    case 5 -> "Ladro";
                    default -> "x";
                };
                if (checkPartyClass(party, classe)){
                    System.out.println("Nel tuo party esiste già un "+classe+"!");
                    // metto scelta=-1 per far ripartire il ciclo
                    scelta = -1;
                }
                else switch (scelta) {
                    case 0:
                        System.out.println("""
                                1) BARBARO: utilizza un'ascia con un danno di base fisso, può essere sostituita
                                2) MAGO: utilizza magia, ogni incantesimo che trova aumenta il suo danno di base
                                3) DRUIDO: cura il party (diminuisce il danno totale dei nemici). Può memorizzare solo una ricetta alla volta
                                4) DOMATORE: capace di addomesticare gli animali nemici, azzerandone il danno e rendendolo proprio
                                5) LADRO: ha un danno di base minore rispetto al barbaro, ma è capace di attaccare più volte
                                ...
                                """);
                        // Tipo Statico: Avventuriero
                    case 1:
                        party.add(new Barbaro(nome, razza, sesso, eta));
                        break;
                    case 2:
                        party.add(new Mago(nome, razza, sesso, eta));
                        break;
                    case 3:
                        party.add(new Druido(nome, razza, sesso, eta));
                        break;
                    case 4:
                        party.add(new Domatore(nome, razza, sesso, eta));
                        break;
                    case 5:
                        party.add(new Ladro(nome, razza, sesso, eta));
                        break;
                }
            } while (scelta < 1 || scelta > 5);
            tastiera.nextLine();
        }
    }

    /**
     * Un arraylist di oggetti di classe avventuriero viene riempito da Avventurieri casuali (massimo 5)
     * @param party Il party che dovra' essere riempito
     * @param membriParty Il numero di membri che deve contenere il party
     */
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
}
