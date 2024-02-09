package avventura.umani;

public class Domatore extends Avventuriero{
    int danno = 0;
    public Domatore(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.icona = "\uD83E\uDE88";
    }

    public Domatore(String nome, String razza) {
        super(nome, razza);
    }

    public Domatore(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Domatore() {
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
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

    @Override
    public int attacco() {
        return getDanno();
    }

    @Override
    public void equip(int amount) {
        setDanno(amount);
        System.out.println("Addomesticato.");
    }
}
