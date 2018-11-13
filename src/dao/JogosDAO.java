package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Jogos;

public class JogosDAO {
    private Connection conn = null;

    public JogosDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(Jogos j){
        String sql = "INSERT INTO jogos " + 
                "(curso1, curso2, placarCurso1, placarCurso2, localizacao, datahora, idRodada) values " + 
                "(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setInt(1, j.getCurso1());
           stmt.setInt(2, j.getCurso2());
           stmt.setInt(3, j.getPlacarCurso1());
           stmt.setInt(4, j.getPlacarCurso2());
           stmt.setString(5, j.getLocalizacao());
           stmt.setString(6, j.getDatahora());
           stmt.setInt(7, j.getIdRodada());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<Jogos> selectAll(){
        String sql = "select * from jogos";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Jogos> lista = new ArrayList<Jogos>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Jogos j = new Jogos(rs.getInt("idJogo"), rs.getInt("curso1"),rs.getInt("curso2"), rs.getInt("placarCurso1") ,rs.getInt("placarCurso2") ,rs.getString("localizacao") ,rs.getString("datahora") ,rs.getInt("idRodada"));
                lista.add(j);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<Jogos> selectAll(String condicao){
        String sql = "select * from jogos "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Jogos> lista = new ArrayList<Jogos>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Jogos j = new Jogos(rs.getInt("idJogo"), rs.getInt("curso1"),rs.getInt("curso2"), rs.getInt("placarCurso1") ,rs.getInt("placarCurso2") ,rs.getString("localizacao") ,rs.getString("datahora") ,rs.getInt("idRodada"));
                lista.add(j);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean update(Jogos j){
        String sql = "UPDATE jogos SET curso1 = ?, curso2 = ?, placarCurso1 = ?, placarCurso2 = ?, localizacao = ?, datahora = ?, idRodada = ? WHERE idJogo = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setInt(1, j.getCurso1());
           stmt.setInt(2, j.getCurso2());
           stmt.setInt(3, j.getPlacarCurso1());
           stmt.setInt(4, j.getPlacarCurso2());
           stmt.setString(5, j.getLocalizacao());
           stmt.setString(6, j.getDatahora());
           stmt.setInt(7, j.getIdRodada());
           stmt.setInt(8, j.getIdJogo());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM jogos WHERE idJogo = ?";
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
    
    public boolean deleteRodada(int idRodada){
        String sql = "DELETE FROM jogos WHERE idRodada = ?";
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
