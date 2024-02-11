package avventura.umani;

import java.util.Scanner;

public class Druido extends Avventuriero {
    int forzaCura;
    public Druido(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        this.forzaCura = 1;
        super.icona = "⚕\uFE0F";
    }

    public Druido(String nome, String razza, int forzaCura) {
        super(nome, razza);
        this.forzaCura = forzaCura;
    }

    public Druido(String nome, String razza, int eta, int forzaCura) {
        super(nome, razza, eta);
        this.forzaCura = forzaCura;
    }

    public Druido(int forzaCura) {
        this.forzaCura = forzaCura;
    }

    public int getForzaCura() {
        return forzaCura;
    }

    public void setForzaCura(int forzaCura) {
        this.forzaCura = forzaCura;
    }

    @Override
    public int attacco() {
        return getForzaCura()*(-1);
    }

    @Override
    public void equip(int amount) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println(getNome()+" può imparalo.");
        System.out.println("Vuoi impararlo? (s/N) Potere curativo attuale di "+ getNome() + ": "+ getForzaCura());
        String scelta = tastiera.nextLine();
        if (scelta.equalsIgnoreCase("s")){
            setForzaCura(amount);
        }else System.out.println("Non imparato.");
    }
}
