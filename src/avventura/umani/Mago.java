package avventura.umani;

public class Mago extends Avventuriero{
    int mana = 5;
    public Mago(String nome, String razza, char sesso, int eta, int mana) {
        super(nome, razza, sesso, eta);
        this.mana = mana;
    }

    public Mago(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Mago(String nome, String razza, int eta, int mana) {
        super(nome, razza, eta);
        this.mana = mana;
    }

    public Mago(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Mago{" +
                "mana=" + mana +
                ", nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", sesso=" + sesso +
                ", eta=" + eta +
                '}';
    }
}
