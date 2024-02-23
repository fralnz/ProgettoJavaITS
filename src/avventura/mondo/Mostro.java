package avventura.mondo;

import java.util.Objects;
import java.util.Random;

/**
 * Ogni mostro ha una icona e un danno
 * @author Francesco Lanza
 * @version 1.0
 */
public class Mostro {
    private String icona;
    private int danno;
    private static final String[] iconeMostri={"\uD83D\uDC79", "\uD83E\uDDCC", "\uD83D\uDC7B", "\uD83D\uDC7A", "\uD83E\uDDDF", "\uD83D\uDC3A"};

    /**
     * Genera un mostro il cui danno scala con il livello, icona casuale
     * @param livello valore con cui far scalare il danno del mostro
     */
    public Mostro(int livello) {
        Random rand=new Random();
        this.icona = iconeMostri[rand.nextInt(iconeMostri.length)];
        this.danno = rand.nextInt(3+livello)+1;
    }
    /**
     * Genera un mostro il cui danno scala con il livello
     * @param livello valore con cui far scalare il danno del mostro
     * @param icona icona del mostro, preferibilmente unicode
     */
    public Mostro(int livello, String icona) {
        Random rand=new Random();
        this.icona = iconeMostri[rand.nextInt(iconeMostri.length)];
        this.danno = rand.nextInt(3+livello)+1;
        this.icona = icona;
    }
    /**
     * Genera un mostro il cui danno varia da 1 a 10
     */
    public Mostro() {
        Random rand=new Random();
        this.icona = iconeMostri[rand.nextInt(iconeMostri.length)];
        this.danno = rand.nextInt(10)+1;
    }

    public String getIcona() {
        return icona;
    }

    public void setIcona(String icona) {
        this.icona = icona;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    @Override
    public String toString() {
        return  icona + "(danno: " + danno + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mostro mostro)) return false;
        return danno == mostro.danno && Objects.equals(icona, mostro.icona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(icona, danno);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
