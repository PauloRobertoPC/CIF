package model;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String nomeTime;
    private String nomeCartoleiro;
    private int cursoUsuario;
    private int idTipoUsuario;
    private String email;

    public Usuario(String nomeUsuario, String login, String senha, String nomeTime, String nomeCartoleiro, int cursoUsuario, int idTipoUsuario, String email) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.nomeTime = nomeTime;
        this.nomeCartoleiro = nomeCartoleiro;
        this.cursoUsuario = cursoUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.email = email;
    }
    
    public Usuario(String nomeUsuario, String login, String senha, String nomeTime, String nomeCartoleiro, int cursoUsuario, int idTipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.nomeTime = nomeTime;
        this.nomeCartoleiro = nomeCartoleiro;
        this.cursoUsuario = cursoUsuario;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public Usuario(String nomeUsuario, String login, String senha, int cursoUsuario, int idTipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.cursoUsuario = cursoUsuario;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public Usuario(String nomeUsuario, String login, String senha, int cursoUsuario, int idTipoUsuario, String email) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.cursoUsuario = cursoUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.email = email;
    }
    
    public Usuario(String nomeUsuario, String login, String senha, String nomeTime, String nomeCartoleiro, int cursoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.nomeTime = nomeTime;
        this.nomeCartoleiro = nomeCartoleiro;
        this.cursoUsuario = cursoUsuario;
    }

    public Usuario() {
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getNomeCartoleiro() {
        return nomeCartoleiro;
    }

    public void setNomeCartoleiro(String nomeCartoleiro) {
        this.nomeCartoleiro = nomeCartoleiro;
    }

    public int getCursoUsuario() {
        return cursoUsuario;
    }

    public void setCursoUsuario(int cursoUsuario) {
        this.cursoUsuario = cursoUsuario;
    }
    
    public int getidTipoUsuario() {
        return idTipoUsuario;
    }

    public void setidTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", nomeTime=" + nomeTime + ", nomeCartoleiro=" + nomeCartoleiro + ", cursoUsuario=" + cursoUsuario + "idTipoUsuario" +idTipoUsuario+'}';
    }
}