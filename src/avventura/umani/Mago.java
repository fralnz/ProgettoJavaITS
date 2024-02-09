package avventura.umani;

public class Mago extends Avventuriero{
    int danno = 3;
    public Mago(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.icona = "\uD83E\uDE84";
    }

    public Mago(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
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

    @Override
    public int attacco() {
        return getDanno();
    }
    @Override
    public void equip(int amount) {
        System.out.println("Hai trovato una pergamena! (danno: +" + amount + ")");
        System.out.println(getNome()+" può impararlo.");
        setDanno(getDanno()+amount);
        System.out.println(getNome() + " ha imparato un nuovo incantesimo. Il suo potere totale ora è " + getDanno());
    }
}
