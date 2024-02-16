package avventura.umani;

import java.util.Objects;

public abstract class Avventuriero implements Personaggio{
    private String nome, razza, icona;
    private char sesso;
    private int eta;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getIcona() {
        return icona;
    }

    public void setIcona(String icona) {
        this.icona = icona;
    }

    @Override
    public String toString() {
        return  icona + nome + "(" +
                razza + ", " + sesso +
                ", " + eta + " anni)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avventuriero that)) return false;
        return sesso == that.sesso && eta == that.eta && Objects.equals(nome, that.nome) && Objects.equals(razza, that.razza) && Objects.equals(icona, that.icona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, razza, icona, sesso, eta);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}