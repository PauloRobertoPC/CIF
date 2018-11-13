package dao;

import model.Liga;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LigaDAO {
    
    private Connection conn = null;

    public LigaDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(Liga l){
        String sql = "INSERT INTO liga " + 
                "(nomeLiga) values " + 
                "(?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, l.getNomeLiga());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<Liga> selectAll(){
        String sql = "select * from liga";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Liga> lista = new ArrayList<Liga>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Liga l = new Liga(rs.getString("nomeLiga"));
                l.setIdLiga(rs.getInt("idLiga"));
                lista.add(l);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<Liga> selectAll(String condicao){
        String sql = "select * from liga "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Liga> lista = new ArrayList<Liga>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Liga l = new Liga(rs.getString("nomeLiga"));
                l.setIdLiga(rs.getInt("idLiga"));
                lista.add(l);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean update(String nomeColuna, String valorNovo, int id){
        String sql = "UPDATE liga SET "+nomeColuna+ " = ? WHERE idLiga = ?";
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
    
    public boolean delete(int id){
        String sql = "DELETE FROM liga WHERE idLiga = ?";
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
