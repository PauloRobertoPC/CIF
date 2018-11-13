package model;

public class TimeRodada {
    private int idUsuario;
    private int idJogador;
    private int idRodada;

    public TimeRodada(int idUsuario, int idJogador, int idRodada) {
        this.idUsuario = idUsuario;
        this.idJogador = idJogador;
        this.idRodada = idRodada;
    }

    public TimeRodada() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public int getIdRodada() {
        return idRodada;
    }

    public void setIdRodada(int idRodada) {
        this.idRodada = idRodada;
    }

    @Override
    public String toString() {
        return "TimeRodada{" + "idUsuario=" + idUsuario + ", idJogador=" + idJogador + ", idRodada=" + idRodada + '}';
    }
}