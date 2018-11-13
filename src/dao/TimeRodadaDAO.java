package dao;

import model.TimeRodada;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TimeRodadaDAO {
    
    private Connection conn = null;

    public TimeRodadaDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(TimeRodada tr){
        String sql = "INSERT INTO timeRodada " + 
                "(idUsuario, idJogador, idRodada) values " + 
                "(?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setInt(1, tr.getIdUsuario());
           stmt.setInt(2, tr.getIdJogador());
           stmt.setInt(3, tr.getIdRodada());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<TimeRodada> selectAll(){
        String sql = "select * from timeRodada";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<TimeRodada> lista = new ArrayList<TimeRodada>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                TimeRodada tr = new TimeRodada(rs.getInt("idUsuario"), rs.getInt("idJogador"), rs.getInt("idRodada"));
                lista.add(tr);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<TimeRodada> selectAll(String condicao){
        String sql = "select * from timeRodada "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<TimeRodada> lista = new ArrayList<TimeRodada>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                TimeRodada tr = new TimeRodada(rs.getInt("idUsuario"), rs.getInt("idJogador"), rs.getInt("idRodada"));
                lista.add(tr);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    /*public boolean update(String nomeColuna, String valorNovo, int id){
        String sql = "UPDATE timeRodada SET "+nomeColuna+ " = ? WHERE idUsuario = ? and idJogador = ? and idRodada = ?";
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
    } */
    
    public boolean delete(int idUsuario, int idRodada){
        String sql = "DELETE FROM timeRodada WHERE idUsuario = '"+idUsuario+"' and idRodada = '"+idRodada+"'";
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
    
    public boolean deleteRodada(int idRodada){
        String sql = "DELETE FROM timeRodada WHERE idRodada = '"+idRodada+"'";
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
        String sql = "DELETE FROM timeRodada WHERE idUsuario = '"+idUsuario+"'";
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
