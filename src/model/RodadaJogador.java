package model;

public class RodadaJogador {
    private float pontuacao;
    private int idRodada;
    private int idJogador;

    public RodadaJogador(float pontuacao, int idRodada, int idJogador) {
        this.pontuacao = pontuacao;
        this.idRodada = idRodada;
        this.idJogador = idJogador;
    }

    public RodadaJogador() {
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getIdRodada() {
        return idRodada;
    }

    public void setIdRodada(int idRodada) {
        this.idRodada = idRodada;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    @Override
    public String toString() {
        return "RodadaJogador{" + "pontuacao=" + pontuacao + ", idRodada=" + idRodada + ", idJogador=" + idJogador + '}';
    }
}