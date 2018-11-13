package model;

public class Jogador {
    private int idJogador;
    private String nomeJogador;
    private String posicao;
    private String imagem;
    private int cursoJogador;

    public Jogador(String nomeJogador, String posicao, String imagem, int cursoJogador) {
        this.nomeJogador = nomeJogador;
        this.posicao = posicao;
        this.imagem = imagem;
        this.cursoJogador = cursoJogador;
    }

    public Jogador() {
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getCursoJogador() {
        return cursoJogador;
    }

    public void setCursoJogador(int cursoJogador) {
        this.cursoJogador = cursoJogador;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Jogador{" + "idJogador=" + idJogador + ", nomeJogador=" + nomeJogador + ", posicao=" + posicao + ", imagem=" + imagem + ", cursoJogador=" + cursoJogador + '}';
    }
}