package avventura.umani;
import avventura.Metodi;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Ladro extends Avventuriero{
    private int danno;
    private static final int maxAttacchi = 3;
    public Ladro(String nome, String razza, char sesso, int eta) {
        super(nome, razza, sesso, eta);
        super.setIcona("\uD83D\uDDE1\uFE0F");
        this.danno = 1;
    }

    public Ladro(String nome, String razza) {
        super(nome, razza);
    }

    public Ladro(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public Ladro() {
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
        Ladro ladro = (Ladro) o;
        return danno == ladro.danno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), danno);
    }

    /**
     * L'attacco e' dato dalla variabile di istanza danno, attacca un numero di volte pari alla costante maxAttacchi
     * @return danno moltiplicato per un numero casuale che va da 1 a maxAttacchi
     */
    public int attacco(){
        int numAttacchi = ThreadLocalRandom.current().nextInt(1, maxAttacchi);
        System.out.println(super.getNome() + " ha attaccato " + numAttacchi + " volte.");
        return (getDanno() * numAttacchi);
    }

    /**
     * scambia il danno attuale con il parametro
     * @param amount il valore con il quale sotituire danno
     */
    public void equipaggia(int amount) {
        System.out.println(getNome()+" può equipaggiarlo.");
        System.out.println("Vuoi equipaggiarlo? (s/N) Danno attuale di "+ getNome() + ": "+ getDanno());
        boolean scelta = Metodi.selezioneScelta();
        if (scelta){
            setDanno(amount);
            System.out.println("Equipaggiato.");
        }else System.out.println("Non equipaggiato.");
    }
}
