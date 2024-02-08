package avventura.mostri;

import java.util.Random;

public class Mostro {
    String nome;
    int danno;

    public Mostro(int livello) {
        Random rand=new Random();
        String[] iconeMostri={"\uD83D\uDC79", "\uD83E\uDDCC", "\uD83D\uDC7B", "\uD83D\uDC7A"};
        this.nome = iconeMostri[rand.nextInt(iconeMostri.length)];
        this.danno = rand.nextInt(3)+1+livello;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    @Override
    public String toString() {
        return  nome + '\n' + "danno=" + danno + '\n';
    }
}
