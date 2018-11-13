package dao;

import model.Rodada;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Util; //Contém os métodos de tranformação das datas.
import java.text.ParseException;

public class RodadaDAO {
    
    private Connection conn = null;

    public RodadaDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(Rodada r) throws ParseException{
        String sql = "INSERT INTO rodadas " + 
                "(nomeRodada, dataInicio, dataFim) values " + 
                "(?, ?, ?)";
        Util u = new Util();
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, r.getNomeRodada());
           stmt.setString(2, u.convDataBanco(r.getDataInicio()));
           stmt.setString(3, u.convDataBanco(r.getDataFim()));
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<Rodada> selectAll() throws ParseException{
        String sql = "select * from rodadas";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Rodada> lista = new ArrayList<Rodada>();
        Util u = new Util();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Rodada r = new Rodada(rs.getString("nomeRodada"), u.convDataJava(rs.getString("dataInicio")),  u.convDataJava(rs.getString("dataFim")));
                r.setIdRodada(rs.getInt("idRodada"));
                lista.add(r);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<Rodada> selectAll(String condicao) throws ParseException{
        String sql = "select * from rodadas "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Rodada> lista = new ArrayList<Rodada>();
        Util u = new Util();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Rodada r = new Rodada(rs.getString("nomeRodada"), u.convDataJava(rs.getString("dataInicio")),  u.convDataJava(rs.getString("dataFim")));
                r.setIdRodada(rs.getInt("idRodada"));
                lista.add(r);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean update(String nomeColuna, String valorNovo, int id){
        String sql = "UPDATE rodadas SET "+nomeColuna+ " = ? WHERE idRodada = ?";
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
    
    public boolean update(Rodada r) throws ParseException{
        String sql = "UPDATE rodadas SET nomeRodada = ?, dataInicio = ?, dataFim = ? WHERE idRodada = ?";
        Util u = new Util();
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, r.getNomeRodada());
           stmt.setString(2, u.convDataBanco(r.getDataInicio()));
           stmt.setString(3, u.convDataBanco(r.getDataFim()));
           stmt.setInt(4, r.getIdRodada());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM rodadas WHERE idRodada = ?";
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
    public int totalRodadas(){
        String sql = "select count(*) as total from rodadas";
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
