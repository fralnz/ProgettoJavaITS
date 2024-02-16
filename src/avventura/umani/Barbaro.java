package avventura.umani;

import java.util.Scanner;

public class Barbaro extends Avventuriero{
    private int danno;

    public Barbaro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.setIcona("\uD83E\uDE93");
        this.danno = 1;
    }
    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    public int attacco(){
        return getDanno();
    }

    @Override
    public void equip(int amount) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println(getNome()+" può equipaggiarlo.");
        System.out.println("Vuoi equipaggiarlo? (s/N) Danno attuale di "+ getNome() + ": "+ getDanno());
        String scelta = tastiera.nextLine();
        if (scelta.equalsIgnoreCase("s")){
            setDanno(amount);
            System.out.println("Equipaggiato.");
        }else System.out.println("Non equipaggiato.");
    }
}
