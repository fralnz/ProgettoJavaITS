package avventura.umani;

import java.util.Random;

public class Ladro extends Avventuriero{
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
    public void Attacco(){
        Random rand = new Random();
        int numAttacchi = rand.nextInt(7)+1;
        double attacco = danno*numAttacchi;
        System.out.println(nome + " ha attaccato "+numAttacchi+" volte. Danno: "+ attacco);
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
