package avventura.umani;

public class Barbaro extends Avventuriero{
    int danno;
    String icona = icona = "\uD83E\uDE93";

    public Barbaro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.danno = 3;
        super.icona = "\uD83E\uDE93";
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
        System.out.println(nome + " ha attaccato. Danno: "+ danno);
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
