package umani;

public class Druido extends Avventuriero {
    double forzaCura = 5;

    public Druido(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
    }

    public Druido(String nome, String razza) {
        super(nome, razza);
    }

    public Druido(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Druido() {
    }

    @Override
    public String toString() {
        return "Druido{" +
                "nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", sesso=" + sesso +
                ", eta=" + eta +
                '}';
    }
}
