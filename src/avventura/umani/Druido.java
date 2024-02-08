package avventura.umani;

public class Druido extends Avventuriero {
    int forzaCura;

    public Druido(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        this.forzaCura = 1;
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
    public String toString() {
        return "Druido{" +
                "nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", sesso=" + sesso +
                ", eta=" + eta +
                '}';
    }
}
