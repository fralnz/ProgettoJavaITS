package avventura.mondo;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Livello {
    int livello;
    ArrayList<Avventuriero> party;

    private int checkClass(String classe){
        for (int i = 0; i < party.size(); i++){
            if (party.get(i).getClass().getSimpleName().equals(classe)) return i;
        }
        return -1;
    }

    /*
    private void equipWeapon(String classe, int danno){
        Scanner tastiera = new Scanner(System.in);
        int idxMembro = checkClass(classe);
        if (idxMembro >= 0){
            Avventuriero membro = party.get(idxMembro);
            System.out.println(party.get(idxMembro).getNome()+" può equipaggiarlo.");
            System.out.println("Vuoi equipaggiarlo? (s/N) Danno attuale di "+ membro.getNome() + ": "+ membro.getDanno());
            String scelta = tastiera.nextLine();
            if (scelta.equalsIgnoreCase("s")){
                membro.setDanno(danno);
            }else System.out.println("Non equipaggiato.");
        } else System.out.println("Nessun membro del tuo party può usarlo.");
    }

    private void addSpell(String classe, int danno){
        int idxMembro = checkClass(classe);
        if (idxMembro >= 0){
            Mago membro = (Mago) party.get(idxMembro);
            System.out.println(party.get(idxMembro).getNome()+" può impararlo.");
            membro.setDanno(membro.getDanno()+danno);
            System.out.println(membro.getNome() + " ha imparato un nuovo incantesimo. Il suo potere totale ora è " + membro.getDanno());
        } else System.out.println("Nessun membro del tuo party può usarlo.");
    }

    private void equipRecipe(String classe, int danno){
        Scanner tastiera = new Scanner(System.in);
        int idxMembro = checkClass(classe);
        if (idxMembro >= 0){
            Druido membro = (Druido) party.get(idxMembro);
            System.out.println(party.get(idxMembro).getNome()+" può imparalo.");
            System.out.println("Vuoi impararlo? (s/N) Potere curativo attuale di "+ membro.getNome() + ": "+ membro.getForzaCura());
            String scelta = tastiera.nextLine();
            if (scelta.equalsIgnoreCase("s")){
                membro.setForzaCura(danno);
            }else System.out.println("Non imparato.");
        } else System.out.println("Nessun membro del tuo party può usarlo.");
    }
     */

    public void GeneraEvento(){
        String classe, arma;
        int amount = 0;
        Random rand = new Random();
        int nEvento = ThreadLocalRandom.current().nextInt(0, 4);
        if (nEvento == 0){
            classe = "Barbaro";
            arma = "ascia";
            amount = rand.nextInt(10)+livello;
        } else if (nEvento == 1) {
            classe = "Ladro";
            arma = "coltello";
            amount = rand.nextInt(7)+1;
        } else if (nEvento == 2) {
            classe = "Mago";
            arma = "pergamena";
            amount = rand.nextInt(5) + 1;
        } else if (nEvento == 3) {
            classe = "Druido";
            arma = "ricetta";
            amount = rand.nextInt(5) + 1;
        } else {
            System.out.println("ERRORE!");
            classe = "Err";
            arma = "Err";
        }
        System.out.println("Hai trovato una "+arma+"! (potenza: +" + amount + ")");
        try{
            party.get(checkClass(classe)).equip(amount);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Nessun membro del tuo party può usarlo.");
        }
    }
    public Livello(ArrayList<Avventuriero> party) {
        this.livello = 1;
        this.livello = 1;
        this.party = party;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public void avanzaLivello(){
        setLivello(getLivello()+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livello giorno)) return false;
        return Objects.equals(party, giorno.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livello, livello, party);
    }
}
