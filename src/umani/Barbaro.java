package umani;

public class Barbaro extends Avventuriero{
    String arma, armatura;

    public Barbaro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
    }

    public Barbaro(String nome, String razza) {
        super(nome, razza);
    }

    public Barbaro(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Barbaro() {
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
