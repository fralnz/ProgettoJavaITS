package avventura.mostri;

import java.util.Random;

public class Mostro {
    String icona;
    int danno;

    public Mostro(int livello) {
        Random rand=new Random();
        String[] iconeMostri={"\uD83D\uDC79", "\uD83E\uDDCC", "\uD83D\uDC7B", "\uD83D\uDC7A", "\uD83E\uDDDF"};
        this.icona = iconeMostri[rand.nextInt(iconeMostri.length)];
        this.danno = rand.nextInt(3+livello)+1;
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
        return  icona + '\n' + "danno=" + danno + '\n';
    }
}
