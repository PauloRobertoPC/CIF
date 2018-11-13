package model;
public class Top {
    private String nome;
    private String nomeTime;
    private float pontuacao;
    private int idGuambiarra;

    public Top(String nome, String nomeTime, float pontuacao, int idGuambiarra) {
        this.nome = nome;
        this.nomeTime = nomeTime;
        this.pontuacao = pontuacao;
        this.idGuambiarra = idGuambiarra;
    }

    public Top(String nome, String nomeTime, float pontuacao) {
        this.nome = nome;
        this.nomeTime = nomeTime;
        this.pontuacao = pontuacao;
    }

    public Top(String nome, float pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public Top(float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Top() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getIdGuambiarra() {
        return idGuambiarra;
    }

    public void setIdGuambiarra(int idGuambiarra) {
        this.idGuambiarra = idGuambiarra;
    }

    @Override
    public String toString() {
        return "Top{" + "nome=" + nome + ", nomeTime=" + nomeTime + ", pontuacao=" + pontuacao + ", idGuambiarra=" + idGuambiarra + '}';
    }
}
