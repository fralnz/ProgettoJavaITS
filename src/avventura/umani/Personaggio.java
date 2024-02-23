package avventura.umani;

public interface Personaggio {
    /**
     * calcola il danno inflitto all'avversario
     * @return >0 se attacco, altrimenti e' una cura
     */
    public int attacco();

    /**
     * equipaggia un arma
     * @param amount il valore con il quale sotituire/incrementare la variabile di istanza da cui dipende l'attacco
     */
    public void equipaggia(int amount);
}
