package model;

public class Liga {
    private int idLiga;
    private String nomeLiga;

    public Liga(String nomeLiga) {
        this.nomeLiga = nomeLiga;
    }

    public Liga() {
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public String getNomeLiga() {
        return nomeLiga;
    }

    public void setNomeLiga(String nomeLiga) {
        this.nomeLiga = nomeLiga;
    }

    @Override
    public String toString() {
        return "Liga{" + "idLiga=" + idLiga + ", nomeLiga=" + nomeLiga + '}';
    }
}