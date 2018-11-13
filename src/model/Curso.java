package model;

public class Curso {
    private int idCurso;
    private String nomeCurso;
    private String imagemCurso;
    private int eliminado;

    public Curso(int idCurso, String nomeCurso, String imagemCurso, int eliminado) {
        this.idCurso = idCurso;
    	this.nomeCurso = nomeCurso;
        this.imagemCurso = imagemCurso;
        this.eliminado = eliminado;
    }
    
    public Curso(String nomeCurso, String imagemCurso, int eliminado) {
    	this.nomeCurso = nomeCurso;
        this.imagemCurso = imagemCurso;
        this.eliminado = eliminado;
    }
    
    public Curso(int idCurso, String nomeCurso, String imagemCurso) {
        this.idCurso = idCurso;
    	this.nomeCurso = nomeCurso;
        this.imagemCurso = imagemCurso;
    }
    
    public Curso(String nomeCurso, String imagemCurso) {
        this.nomeCurso = nomeCurso;
        this.imagemCurso = imagemCurso;
    }
    
    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Curso() {
    }
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getImagemCurso() {
        return imagemCurso;
    }

    public void setImagemCurso(String imagemCurso) {
        this.imagemCurso = imagemCurso;
    }
    
    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }
    
    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nomeCurso=" + nomeCurso + "imagemCurso=" +imagemCurso+ "eliminado=" +eliminado+'}';
    }   
}