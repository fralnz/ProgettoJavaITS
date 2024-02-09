package avventura.umani;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ladro extends Avventuriero{
    int danno = 1;
    public Ladro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.icona = "\uD83D\uDDE1\uFE0F";
    }

    public Ladro(String nome, String razza) {
        super(nome, razza);
    }

    public Ladro(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Ladro() {
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    public int attacco(){
        int numAttacchi = ThreadLocalRandom.current().nextInt(0, 4);
        System.out.println(nome + " ha attaccato " + numAttacchi + " volte.");
        return (getDanno() * numAttacchi);
    }

    @Override
    public void equip(int amount) {
        System.out.println("Hai trovato un coltello! (danno: " + amount + ")");
        Scanner tastiera = new Scanner(System.in);
        System.out.println(getNome()+" può equipaggiarlo.");
        System.out.println("Vuoi equipaggiarlo? (s/N) Danno attuale di "+ getNome() + ": "+ getDanno());
        String scelta = tastiera.nextLine();
        if (scelta.equalsIgnoreCase("s")){
            setDanno(danno);
        }else System.out.println("Non equipaggiato.");
    }

    @Override
    public String toString() {
        return "Ladro{" +
                "nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", sesso=" + sesso +
                ", eta=" + eta +
                '}';
    }
}
