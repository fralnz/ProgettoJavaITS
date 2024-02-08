package avventura.mondo;
import avventura.umani.Avventuriero;

import java.util.ArrayList;
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
        Avventuriero membro = party.get(checkClass(classe));
        if (checkClass(classe) >= 0 && checkClass(classe) < party.size()){
            System.out.println(party.get(checkClass(classe)).getNome()+" può equipaggiarlo.");
            System.out.println("Vuoi equipaggiarlo? (s/N) Danno attuale di "+ membro.getNome() + ": "+ membro.getDanno());
            String scelta = tastiera.next();
            if (scelta.equalsIgnoreCase("s")){
                membro.setDanno(danno);
            }else System.out.println("Non equipaggiato.");
        }
    }
    private void GeneraEvento(){
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
        }
    }
    public Giorno(ArrayList<Avventuriero> party) {
        this.numGiorno = 1;
        this.livello = 1;
        this.party = party;
        GeneraEvento();
    }
}
