package dao;

import model.LigaUsuario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LigaUsuarioDAO {
    
    private Connection conn = null;

    public LigaUsuarioDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(LigaUsuario lu){
        String sql = "INSERT INTO ligaUsuario " + 
                "(idUsuario, idLiga) values " + 
                "(?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setFloat(1, lu.getIdUsuario());
           stmt.setInt(2, lu.getIdLiga());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<LigaUsuario> selectAll(){
        String sql = "select * from ligaUsuario";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<LigaUsuario> lista = new ArrayList<LigaUsuario>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                LigaUsuario lu = new LigaUsuario(rs.getInt("idUsuario"), rs.getInt("idLiga"));
                lista.add(lu);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<LigaUsuario> selectAll(String condicao){
        String sql = "select * from ligaUsuario "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<LigaUsuario> lista = new ArrayList<LigaUsuario>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                LigaUsuario lu = new LigaUsuario(rs.getInt("idUsuario"), rs.getInt("idLiga"));
                lista.add(lu);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public HashMap<Integer,Integer> usuariosDaLiga(int liga){
        String sql = "select * from ligaUsuario WHERE idLiga = "+liga+"";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        HashMap<Integer,Integer> mapa = new HashMap<Integer,Integer>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                mapa.put(rs.getInt("idUsuario"), rs.getInt("idLiga"));
            }
            return mapa;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return null;
    }
    
    public int totalParticipantes(int liga) {
    	String sql = "select count(*) as total from ligaUsuario where idLiga = '"+liga+"'";
    	PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            int tot =  rs.getInt("total");
            return tot;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return 0;
    }
    
    public boolean delete(int idUsuario, int idLiga){
        String sql = "DELETE FROM ligaUsuario WHERE idUsuario = '"+idUsuario+"' and idLiga = '"+idLiga+"'";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean deleteLiga(int idLiga){
        String sql = "DELETE FROM ligaUsuario WHERE idLiga = '"+idLiga+"'";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean delete(int idUsuario){
        String sql = "DELETE FROM ligaUsuario WHERE idUsuario = '"+idUsuario+"'";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
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
