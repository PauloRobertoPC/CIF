package model;

import java.util.Date;

public class Rodada {
    private int idRodada;
    private String nomeRodada;
    private Date dataInicio;
    private Date dataFim;

    public Rodada(String nomeRodada, Date dataInicio, Date dataFim) {
        this.nomeRodada = nomeRodada;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Rodada() {
    }

    public int getIdRodada() {
        return idRodada;
    }

    public void setIdRodada(int idRodada) {
        this.idRodada = idRodada;
    }

    public String getNomeRodada() {
        return nomeRodada;
    }

    public void setNomeRodada(String nomeRodada) {
        this.nomeRodada = nomeRodada;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Rodada{" + "idRodada=" + idRodada + ", nomeRodada=" + nomeRodada + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }
}