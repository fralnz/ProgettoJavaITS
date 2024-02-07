package umani;

public abstract class Avventuriero {
    String nome, razza;
    char sesso;
    int eta;
    double danno, hp;

    public Avventuriero(String nome, String razza, char sesso, int eta) {
        this.nome = nome;
        this.razza = razza;
        if (sesso == 'm' || sesso == 'M' || sesso == 'f' || sesso == 'F')
            this.sesso = sesso;
        else this.sesso = 'x';
        this.eta = eta;
    }

    public Avventuriero(String nome, String razza) {
        this.nome = nome;
        this.razza = razza;
        this.sesso = 'x';
    }

    public Avventuriero(String nome, String razza, int eta) {
        this.nome = nome;
        this.razza = razza;
        this.eta = eta;
        this.sesso = 'x';
    }

    public Avventuriero() {
    }
}