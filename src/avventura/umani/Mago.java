package avventura.umani;

public class Mago extends Avventuriero{
    String icona = icona = "\uD83E\uDE84";
    public Mago(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
    }

    public Mago(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }
    @Override
    public String toString() {
        return "Mago{" +
                ", nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", sesso=" + sesso +
                ", eta=" + eta +
                '}';
    }
}
