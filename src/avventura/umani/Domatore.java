package avventura.umani;

public class Domatore extends Avventuriero{
    public Domatore(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
    }

    public Domatore(String nome, String razza) {
        super(nome, razza);
    }

    public Domatore(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Domatore() {
    }

    @Override
    public String toString() {
        return "Domatore{" +
                "nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", sesso=" + sesso +
                ", eta=" + eta +
                '}';
    }
}
