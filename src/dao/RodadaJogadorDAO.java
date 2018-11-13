package dao;

import model.RodadaJogador;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RodadaJogadorDAO {
    
    private Connection conn = null;

    public RodadaJogadorDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(RodadaJogador rj){
        String sql = "INSERT INTO rodadaJogador " + 
                "(pontuacao, idRodada, idJogador) values " + 
                "(?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setFloat(1, rj.getPontuacao());
           stmt.setInt(2, rj.getIdRodada());
           stmt.setInt(3, rj.getIdJogador());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<RodadaJogador> selectAll(){
        String sql = "select * from rodadaJogador";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<RodadaJogador> lista = new ArrayList<RodadaJogador>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                RodadaJogador rj = new RodadaJogador(rs.getFloat("pontuacao"), rs.getInt("idRodada"), rs.getInt("idJogador"));
                lista.add(rj);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<RodadaJogador> selectAll(String condicao){
        String sql = "select * from rodadaJogador "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<RodadaJogador> lista = new ArrayList<RodadaJogador>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                RodadaJogador rj = new RodadaJogador(rs.getFloat("pontuacao"), rs.getInt("idRodada"), rs.getInt("idJogador"));
                lista.add(rj);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean updatePuntuacao(float valorNovo, int idRodada, int idJogador){
        String nomeColuna = "pontuacao";
        String sql = "UPDATE rodadaJogador SET "+nomeColuna+ " = ? WHERE idRodada = ? and idJogador = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setFloat(1, valorNovo);
           stmt.setInt(2, idRodada);
           stmt.setInt(3, idJogador);
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean delete(int idRodada, int idJogador){
        String sql = "DELETE FROM rodadaJogador WHERE idRodada = ? and idJogador = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setInt(1, idRodada);
           stmt.setInt(2, idJogador);
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean deleteRodada(int idRodada){
        String sql = "DELETE FROM rodadaJogador WHERE idRodada = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setInt(1, idRodada);
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