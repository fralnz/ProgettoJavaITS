package avventura.umani;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Domatore domatore = (Domatore) o;
        return danno == domatore.danno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), danno);
    }

    /**
     * L'attacco e' dato dalla variabile di istanza danno
     * @return il valore di danno
     */
    public int attacco() {
        return getDanno();
    }

    /**
     * il danno attuale viene scambiato con il valore del parametro
     * @param amount il valore con il quale sotituire la variabile di istanza danno
     */
    public void equipaggia(int amount) {
        setDanno(amount);
        System.out.println("Addomesticato. Il suo danno sarà nullo.");
    }
}
