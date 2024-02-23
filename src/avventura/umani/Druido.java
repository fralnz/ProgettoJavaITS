package avventura.umani;
import avventura.Metodi;
import java.util.Objects;

public class Druido extends Avventuriero {
    private int forzaCura;
    public Druido(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        this.forzaCura = 1;
        super.setIcona("⚕️");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Druido druido = (Druido) o;
        return forzaCura == druido.forzaCura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), forzaCura);
    }

    /**
     * L'attacco e' dato dalla variabile di istanza forzaCura
     * @return -forzaCura, in modo tale da capire che si tratta di una cura
     */
    public int attacco() {
        // restituisco un valore negativo, così da segnare che si tratta di una cura
        return getForzaCura()*(-1);
    }

    /**
     * scambia forzaCura attuale con il parametro
     * @param amount il valore con il quale sotituire la variabile di istanza forzaCura
     */
    public void equipaggia(int amount) {
        System.out.println(getNome()+" può imparalo.");
        System.out.println("Vuoi impararlo? (s/N) Potere curativo attuale di "+ getNome() + ": "+ getForzaCura());
        boolean scelta = Metodi.selezioneScelta();
        if (scelta){
            setForzaCura(amount);
            System.out.println("Imparato.");
        }else System.out.println("Non imparato.");
    }
}
