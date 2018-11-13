package dao;

import model.Curso;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {
    
    private Connection conn = null;

    public CursoDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(Curso c){
        String sql = "INSERT INTO cursos " + 
                "(nomeCurso, imagemCurso, eliminado) values " + 
                "(?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, c.getNomeCurso());
           stmt.setString(2, c.getImagemCurso());
           stmt.setInt(3, c.getEliminado());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<Curso> selectAll(){
        String sql = "select * from cursos";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Curso c = new Curso(rs.getString("nomeCurso"), rs.getString("imagemCurso"), rs.getInt("eliminado"));
                c.setIdCurso(rs.getInt("idCurso"));
                lista.add(c);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<Curso> selectAll(String condicao){
        String sql = "select * from cursos "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Curso c = new Curso(rs.getString("nomeCurso"), rs.getString("imagemCurso"), rs.getInt("eliminado"));
                c.setIdCurso(rs.getInt("idCurso"));
                lista.add(c);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean update(String nomeColuna, String valorNovo, int id){
        String sql = "UPDATE cursos SET "+nomeColuna+ " = ? WHERE idCurso = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, valorNovo);
           stmt.setInt(2, id);
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean update(Curso c){
        String sql = "UPDATE cursos SET nomeCurso = ?, imagemCurso = ?, Eliminado = ? WHERE idCurso = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, c.getNomeCurso());
           stmt.setString(2, c.getImagemCurso());
           stmt.setInt(3, c.getEliminado());
           stmt.setInt(4, c.getIdCurso());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM cursos WHERE idCurso = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setInt(1, id);
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean closeDataBase() throws SQLException{
        try{
            conn.close();
            return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
}