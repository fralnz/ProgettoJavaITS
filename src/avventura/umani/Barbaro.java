package avventura.umani;

import java.util.Scanner;

public class Barbaro extends Avventuriero{
    int danno = 3;
    String icona = icona = "\uD83E\uDE93";

    public Barbaro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.icona = "\uD83E\uDE93";
    }

    public Barbaro(String nome, String razza) {
        super(nome, razza);
    }

    public Barbaro(String nome, String razza, int eta) {
        super(nome, razza, eta);
        this.danno = 3;
    }

    public Barbaro() {
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
            setDanno(danno);
            System.out.println("Equipaggiato.");
        }else System.out.println("Non equipaggiato.");
    }

    @Override
    public String toString() {
        return "Barbaro{" +
                "nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", sesso=" + sesso +
                ", eta=" + eta +
                '}';
    }
}
