package avventura.mostri;

public abstract class Mostro {
    String nome;
    int vita;
    int danno;

    public Mostro(String nome, int vita, int danno) {
        this.nome = nome;
        this.vita = vita;
        this.danno = danno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }
}
