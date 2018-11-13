package model;
public class Jogos {
    private int idJogo;
    private int curso1;
    private int curso2;
    private int placarCurso1;
    private int placarCurso2;
    private String localizacao;
    private String datahora;
    private int idRodada;

    public Jogos(int idJogo, int curso1, int curso2, int placarCurso1, int placarCurso2, String localizacao, String datahora, int idRodada) {
        this.idJogo = idJogo;
        this.curso1 = curso1;
        this.curso2 = curso2;
        this.placarCurso1 = placarCurso1;
        this.placarCurso2 = placarCurso2;
        this.localizacao = localizacao;
        this.datahora = datahora;
        this.idRodada = idRodada;
    }

    public int getCurso1() {
        return curso1;
    }

    public void setCurso1(int curso1) {
        this.curso1 = curso1;
    }

    public int getCurso2() {
        return curso2;
    }

    public void setCurso2(int curso2) {
        this.curso2 = curso2;
    }

    public int getPlacarCurso1() {
        return placarCurso1;
    }

    public void setPlacarCurso1(int placarCurso1) {
        this.placarCurso1 = placarCurso1;
    }

    public int getPlacarCurso2() {
        return placarCurso2;
    }

    public void setPlacarCurso2(int placarCurso2) {
        this.placarCurso2 = placarCurso2;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public int getIdRodada() {
        return idRodada;
    }

    public void setIdRodada(int idRodada) {
        this.idRodada = idRodada;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    @Override
    public String toString() {
        return "Jogos{" + "idJogo=" + idJogo + ", curso1=" + curso1 + ", curso2=" + curso2 + ", placarCurso1=" + placarCurso1 + ", placarCurso2=" + placarCurso2 + ", localizacao=" + localizacao + ", datahora=" + datahora + ", idRodada=" + idRodada + '}';
    }
}
