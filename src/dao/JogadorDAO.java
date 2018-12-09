package dao;

import model.Top;
import model.Jogador;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDAO {
    
    private Connection conn = null;

    public JogadorDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(Jogador j){
        String sql = "INSERT INTO jogadores " + 
                "(nomeJogador, posicao, imagem, cursoJogador) values " + 
                "(?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, j.getNomeJogador());
           stmt.setString(2, j.getPosicao());
           stmt.setString(3, j.getImagem());
           stmt.setInt(4, j.getCursoJogador());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<Jogador> selectAll(){
        String sql = "select * from jogadores";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Jogador> lista = new ArrayList<Jogador>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Jogador j = new Jogador(rs.getString("nomeJogador"), rs.getString("posicao"), rs.getString("imagem"), rs.getInt("cursoJogador"));
                j.setIdJogador(rs.getInt("idJogador"));
                lista.add(j);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<Jogador> selectAll(String condicao){
        String sql = "select * from jogadores "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Jogador> lista = new ArrayList<Jogador>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Jogador j = new Jogador(rs.getString("nomeJogador"), rs.getString("posicao"), rs.getString("imagem"), rs.getInt("cursoJogador"));
                j.setIdJogador(rs.getInt("idJogador"));
                lista.add(j);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean update(String nomeColuna, String valorNovo, int id){
        String sql = "UPDATE jogadores SET "+nomeColuna+ " = ? WHERE idJogador = ?";
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
    
    public boolean update(Jogador j){
        String sql = "UPDATE jogadores SET nomeJogador = ?, posicao = ?, imagem = ?, cursoJogador = ? WHERE idJogador = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, j.getNomeJogador());
           stmt.setString(2, j.getPosicao());
           stmt.setString(3, j.getImagem());
           stmt.setInt(4, j.getCursoJogador());
           stmt.setInt(5, j.getIdJogador());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM jogadores WHERE idJogador = ?";
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
    
    public ArrayList<Top> top3Rodada(int rodada){
        String sql = "select jogadores.nomeJogador, jogadores.imagem,rodadaJogador.pontuacao, jogadores.idJogador from jogadores, rodadaJogador\n" +
                     "where (jogadores.idJogador = rodadaJogador.idJogador) and (rodadaJogador.idRodada = "+rodada+") and (jogadores.posicao != 'Técnico')\n" +
                     "group by(jogadores.nomeJogador)\n" +
                     "order by pontuacao desc";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            int c = 0;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(c <= 2){
                if (rs.next()){
                    Top t = new Top(rs.getString("nomeJogador"), rs.getString("imagem"), rs.getFloat("pontuacao"), rs.getInt("idJogador"));
                    lista.add(t);
                    c++;
                }else {
                    c = 3;
                }
            }
            return lista;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
            return lista;
    }
    
    public ArrayList<Top> topRodada(int rodada){
        String sql = "select jogadores.nomeJogador, jogadores.imagem, rodadaJogador.pontuacao, jogadores.idJogador from jogadores, rodadaJogador\n" +
                     "where (jogadores.idJogador = rodadaJogador.idJogador) and (rodadaJogador.idRodada = "+rodada+") and (jogadores.posicao != 'Técnico')\n" +
                     "group by(jogadores.nomeJogador)\n" +
                     "order by pontuacao desc";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
            	Top t = new Top(rs.getString("nomeJogador"), rs.getString("imagem"), rs.getFloat("pontuacao"), rs.getInt("idJogador"));
                lista.add(t);
            }
            return lista;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
            return lista;
    }
    
    /*public HashMap top3Geral(){
        String sql = "select jogadores.nomeJogador, rodadaJogador.pontuacao from jogadores, rodadaJogador\n" +
                     "where (jogadores.idJogador = rodadaJogador.idJogador)\n" +
                     "group by(jogadores.nomeJogador)\n" +
                     "order by pontuacao desc";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        HashMap<String, Float> mapa = new HashMap<String, Float>();
        try{
            int c = 0;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(c <= 2){
                if (rs.next()){
                    mapa.put(rs.getString("nomeJogador"), rs.getFloat("pontuacao"));
                    c++; 
                }else {
                    c = 3;
                }
            }
            return mapa;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
            return mapa;
    }*/

    public ArrayList<Top> top3Escalados(int rodada){
        String sql = "select jogadores.nomeJogador, jogadores.imagem, count(*) as participacoes, jogadores.idJogador from timeRodada, jogadores\n" +
                    "where (idRodada = '"+rodada+"') and (jogadores.idJogador = timeRodada.idJogador) and (jogadores.posicao != 'Técnico')\n" +
                    "group by timeRodada.idJogador\n" +
                    "order by participacoes desc";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            int c = 0;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(c <= 2){
                if (rs.next()){
                    Top t = new Top(rs.getString("nomeJogador"), rs.getString("imagem"), rs.getFloat("participacoes"), rs.getInt("idJogador"));
                    lista.add(t);
                    c++;
                }else {
                    c = 3;
                }
            }
            return lista;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
            return lista;
    }
    
    public ArrayList<Top> top3EscaladosRodada(int rodada){
        String sql = "select jogadores.nomeJogador, jogadores.imagem, count(*) as participacoes, jogadores.idJogador from timeRodada, jogadores\n" +
                    "where (idRodada = '"+rodada+"') and (jogadores.idJogador = timeRodada.idJogador) and (jogadores.posicao != 'Técnico')\n" +
                    "group by timeRodada.idJogador\n" +
                    "order by participacoes desc";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                    Top t = new Top(rs.getString("nomeJogador"), rs.getString("imagem"), rs.getFloat("participacoes"), rs.getInt("idJogador"));
                    lista.add(t);
               
            }
            return lista;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
            return lista;
    }
    
   private int totalDeRodadasParticipantes(int id){
        String sql = "select count(*) as total from rodadaJogador where (idJogador = "+id+")";
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
   
    public Top papaPonto(){
        String sql = "select jogadores.nomeJogador, jogadores.imagem, (sum(rodadaJogador.pontuacao)/(select count(*) as total from rodadaJogador where (idJogador = jogadores.idJogador))) as pontuacao, jogadores.idJogador from jogadores, rodadaJogador \r\n" + 
        		"where (jogadores.idJogador = rodadaJogador.idJogador) and (jogadores.posicao != 'Técnico') \r\n" + 
        		"group by(jogadores.nomeJogador) \r\n" + 
        		"order by (pontuacao) desc LIMIT 1";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            Top t =  new Top (rs.getString("nomeJogador"), rs.getString("imagem"), rs.getInt("pontuacao"), rs.getInt("idJogador"));
            return t;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return null;
    }
    
    public Top popularidade() throws SQLException{
        String sql = "select timeRodada.idJogador, count(*) as total from timeRodada, jogadores WHERE (timeRodada.idJogador = jogadores.idJogador) and (jogadores.posicao != 'Técnico') group by (idJogador)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idMaior = 0;
        float pontuacaoMaior = 0;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                if((rs.getInt("total")/this.totalDeRodadasParticipantes(rs.getInt("idJogador"))) > pontuacaoMaior){
                    idMaior = rs.getInt("idJogador");
                    pontuacaoMaior = rs.getInt("total")/this.totalDeRodadasParticipantes(idMaior);
                }
            }
            Jogador j = this.selectAll("WHERE idJogador ='"+idMaior+"'").get(0);
            Top t = new Top(j.getNomeJogador(), j.getImagem(), pontuacaoMaior, j.getCursoJogador());
            return t;
        }catch (SQLException ex) {
            System.err.println("Erro: "+ ex);
        }
        return null;
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