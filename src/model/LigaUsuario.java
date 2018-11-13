package model;

public class LigaUsuario {
    
    private int idUsuario;
    private int idLiga;

    public LigaUsuario(int idUsuario, int idLiga) {
        this.idUsuario = idUsuario;
        this.idLiga = idLiga;
    }

    public LigaUsuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    @Override
    public String toString() {
        return "LigaUsuario{" + "idUsuario=" + idUsuario + ", idLiga=" + idLiga + '}';
    }
}
