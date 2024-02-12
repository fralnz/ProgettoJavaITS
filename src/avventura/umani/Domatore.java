package avventura.umani;

public class Domatore extends Avventuriero{
    private int danno;
    public Domatore(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.setIcona("\uD83E\uDE88");
        this.danno = 2;
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

    public int attacco() {
        return getDanno();
    }

    public void equip(int amount) {
        setDanno(amount);
        System.out.println("Addomesticato. Il suo danno sarà nullo.");
    }
}
