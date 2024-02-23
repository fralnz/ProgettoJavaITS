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

    /**
     * L'attacco e' dato dalla variabile di istanza danno
     * @return il valore di danno
     */
    public int attacco(){
        return getDanno();
    }

    /**
     * il danno attuale viene scambiato con il valore del parametro
     * @param amount il valore con il quale sotituire la variabile di istanza danno
     */
    public void equipaggia(int amount) {
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
