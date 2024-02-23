package avventura.umani;

public class Mago extends Avventuriero{
    private int danno;
    public Mago(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.setIcona("\uD83E\uDE84");
        this.danno = 3;
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

    /**
     * L'attacco e' dato dalla variabile di istanza danno
     * @return il valore di danno
     */
    public int attacco() {
        return getDanno();
    }

    /**
     * la variabile di istanza danno aumenta del numero passato come parametro
     * @param amount il valore con il quale incrementare il danno
     */
    public void equipaggia(int amount) {
        System.out.println(getNome()+" può impararlo.");
        setDanno(getDanno()+amount);
        System.out.println(getNome() + " ha imparato un nuovo incantesimo. Il suo potere totale ora è " + getDanno());
    }
}
