package avventura.umani;

public class Ladro extends Avventuriero{
    public Ladro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
    }

    public Ladro(String nome, String razza) {
        super(nome, razza);
    }

    public Ladro(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Ladro() {
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
