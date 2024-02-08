package avventura.umani;

public class Barbaro extends Avventuriero{
    double danno;

    public Barbaro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        this.danno = 3;
    }

    public Barbaro(String nome, String razza) {
        super(nome, razza);
        this.danno = 3;
    }

    public Barbaro(String nome, String razza, int eta) {
        super(nome, razza, eta);
        this.danno = 3;
    }

    public Barbaro() {
    }

    public void Attacco(){
        // senza modificatori
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
