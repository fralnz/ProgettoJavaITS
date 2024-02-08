package avventura.mondo;
import avventura.mostri.Mostro;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Giorno {
    int numGiorno, livello;
    String evento;
    ArrayList<Avventuriero> party;

    private int checkClass(String classe){
        for (int i = 0; i < party.size(); i++){
            if (party.get(i).getClass().getSimpleName().equals(classe)) return i;
        }
        return -1;
    }
    private void EquipWeapon(String classe, int danno){
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
    public void GeneraEvento(){
        Random rand = new Random();
        int nEvento = rand.nextInt(4);
        if (nEvento == 0){
            int danno = rand.nextInt(10)+3;
            System.out.println("Hai trovato una spada! (danno: " + danno + ")");
            EquipWeapon("Barbaro", danno);
        } else if (nEvento == 1) {
            int danno = rand.nextInt(7)+1;
            System.out.println("Hai trovato un coltello! (danno: " + danno + ")");
            EquipWeapon("Ladro", danno);
        } else if (nEvento == 2) {
            int danno = rand.nextInt(7)+1;
            System.out.println("Hai trovato un coltello! (danno: " + danno + ")");
            EquipWeapon("Ladro", danno);
        } else {
            int danno = rand.nextInt(10)+3;
            System.out.println("Hai trovato una spada! (danno: " + danno + ")");
            EquipWeapon("Barbaro", danno);
        }
    }
    public Giorno(ArrayList<Avventuriero> party) {
        this.numGiorno = 1;
        this.livello = 1;
        this.party = party;
    }

    public int getNumGiorno() {
        return numGiorno;
    }

    public void setNumGiorno(int numGiorno) {
        this.numGiorno = numGiorno;
    }
    public void avanzaGiorno(){
        this.numGiorno++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Giorno giorno)) return false;
        return numGiorno == giorno.numGiorno && livello == giorno.livello && Objects.equals(evento, giorno.evento) && Objects.equals(party, giorno.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numGiorno, livello, evento, party);
    }
}
