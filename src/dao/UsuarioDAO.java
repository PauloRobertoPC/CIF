package dao;

import model.Top;
import model.Usuario;
import dao.RodadaDAO;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class UsuarioDAO {
    
    private Connection conn = null;

    public UsuarioDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insertInto(Usuario u){
        String sql = "INSERT INTO usuarios " + 
                "(nomeUsuario, login, senha, nomeTime, nomeCartoleiro, cursoUsuario, idTipoUsuario) values " + 
                "(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, u.getNomeUsuario());
           stmt.setString(2, u.getLogin());
           stmt.setString(3, u.getSenha());
           stmt.setString(4, u.getNomeTime());
           stmt.setString(5, u.getNomeCartoleiro());
           stmt.setInt(6, u.getCursoUsuario());
           stmt.setInt(7, u.getidTipoUsuario());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean insertIntoEmail(Usuario u){
        String sql = "INSERT INTO usuarios " + 
                "(nomeUsuario, login, senha, nomeTime, nomeCartoleiro, cursoUsuario, idTipoUsuario, email) values " + 
                "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, u.getNomeUsuario());
           stmt.setString(2, u.getLogin());
           stmt.setString(3, u.getSenha());
           stmt.setString(4, u.getNomeTime());
           stmt.setString(5, u.getNomeCartoleiro());
           stmt.setInt(6, u.getCursoUsuario());
           stmt.setInt(7, u.getidTipoUsuario());
           stmt.setString(8, u.getEmail());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public ArrayList<Usuario> selectAllEmail(){
        String sql = "select * from usuarios";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(rs.getString("nomeUsuario"), rs.getString("login"), rs.getString("senha"), rs.getString("nomeTime"), rs.getString("nomeCartoleiro"),rs.getInt("cursoUsuario"), rs.getInt("idTipoUsuario"), rs.getString("email"));
                u.setIdUsuario(rs.getInt("idUsuario"));
                lista.add(u);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public ArrayList<Usuario> selectAll(){
        String sql = "select * from usuarios";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(rs.getString("nomeUsuario"), rs.getString("login"), rs.getString("senha"), rs.getString("nomeTime"), rs.getString("nomeCartoleiro"),rs.getInt("cursoUsuario"), rs.getInt("idTipoUsuario"));
                u.setIdUsuario(rs.getInt("idUsuario"));
                lista.add(u);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean insertIntoNull(Usuario u){
        String sql = "INSERT INTO usuarios " + 
                "(nomeUsuario, login, senha, nomeTime, nomeCartoleiro, cursoUsuario, idTipoUsuario, email) values " + 
                "(?, ?, ?, null, null, ?, ?, ?)";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, u.getNomeUsuario());
           stmt.setString(2, u.getLogin());
           stmt.setString(3, u.getSenha());
           stmt.setInt(4, u.getCursoUsuario());
           stmt.setInt(5, u.getidTipoUsuario());
           stmt.setString(6, u.getEmail());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    public ArrayList<Top> mediaCampeonato() throws ParseException{
        String sql = "select usuarios.nomeCartoleiro, usuarios.nomeTime, usuarios.idUsuario , sum(rodadaJogador.pontuacao) as total from usuarios, timeRodada, rodadajogador\n" +
                    "where (usuarios.idUsuario = timeRodada.idUsuario) and (timeRodada.idJogador = rodadaJogador.idJogador) and (timeRodada.idRodada = rodadaJogador.idRodada)\n" +
                    "group by (timeRodada.idUsuario) order by (total) desc";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Top t = new Top(rs.getString("nomeCartoleiro"), rs.getString("nomeTime"), rs.getFloat("total"), rs.getInt("idUsuario"));
                lista.add(t);
            }
            return lista;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    
    
    /*public float pontosRodada(){
        
    }*/
    
    public ArrayList<Usuario> selectAll(String condicao){
        String sql = "select * from usuarios "+condicao;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(rs.getString("nomeUsuario"), rs.getString("login"), rs.getString("senha"), rs.getString("nomeTime"), rs.getString("nomeCartoleiro"),rs.getInt("cursoUsuario"), rs.getInt("idTipoUsuario"), rs.getString("email"));
                u.setIdUsuario(rs.getInt("idUsuario"));
                lista.add(u);
            }
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
    }
    
    public boolean update(String nomeColuna, String valorNovo, int id){
        String sql = "UPDATE usuarios SET "+nomeColuna+ " = ? WHERE idUsuario = ?";
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
    
    public boolean update(Usuario u){
        String sql = "UPDATE usuarios SET nomeUsuario = ?, login = ?, senha = ?, nomeTime = ?, nomeCartoleiro = ?, cursoUsuario = ?, idTipoUsuario = ?, email= ? WHERE idUsuario = ?";
        PreparedStatement stmt = null;
        try{
           stmt = conn.prepareStatement(sql); 
           stmt.setString(1, u.getNomeUsuario());
           stmt.setString(2, u.getLogin());
           stmt.setString(3, u.getSenha());
           stmt.setString(4, u.getNomeTime());
           stmt.setString(5, u.getNomeCartoleiro());
           stmt.setInt(6, u.getCursoUsuario());
           stmt.setInt(7, u.getidTipoUsuario());
           stmt.setString(8, u.getEmail());
           stmt.setInt(9, u.getIdUsuario());
           stmt.executeUpdate();
           return true;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
            return false;
        }
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";
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
    
    public int totalDeLigasParticipantes(int id){
        String sql = "select count(*) as total from ligausuario where (idUsuario = "+id+")";
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
    
    public ArrayList<Top> top3Rodada(int rodada){
        String sql = "select usuarios.nomeCartoleiro, usuarios.nomeTime,sum(rodadajogador.pontuacao) as pontuacao from usuarios, jogadores, rodadajogador, timerodada\n" +
                     "where (usuarios.idUsuario = timerodada.idUsuario) and (jogadores.idJogador = timerodada.idJogador) and (rodadaJogador.idJogador = timerodada.idJogador) and (rodadaJogador.idRodada = '"+rodada+"') and (timeRodada.idRodada = '"+rodada+"')\n" +
                     "group by usuarios.nomeUsuario order by pontuacao desc;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            int c = 0;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(c <= 2){
                if (rs.next()){
                    Top t = new Top(rs.getString("nomeCartoleiro"), rs.getString("nomeTime"),(rs.getFloat("pontuacao")));
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
    
    public ArrayList<Top> topTimes(int rodada){
        String sql = "select usuarios.nomeCartoleiro, usuarios.nomeTime,sum(rodadajogador.pontuacao) as pontuacao from usuarios, jogadores, rodadajogador, timerodada\n" +
                     "where (usuarios.idUsuario = timerodada.idUsuario) and (jogadores.idJogador = timerodada.idJogador) and (rodadaJogador.idJogador = timerodada.idJogador) and (rodadaJogador.idRodada = '"+rodada+"') and (timeRodada.idRodada = '"+rodada+"')\n" +
                     "group by usuarios.nomeUsuario order by pontuacao desc;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
            	Top t = new Top(rs.getString("nomeCartoleiro"), rs.getString("nomeTime"),(rs.getFloat("pontuacao")));
                lista.add(t);
            }
            return lista;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
            return lista;
    }
    
    /*public HashMap top3Geral(){
        String sql = "select usuarios.nomeUsuario, avg(rodadaJogador.pontuacao) as pontuacao from usuarios, rodadaJogador, timerodada\n" +
                    "where (usuarios.idUsuario = timeRodada.idUsuario)\n" +
                    "group by (usuarios.nomeUsuario)\n" +
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
                    mapa.put(rs.getString("nomeUsuario"), rs.getFloat("pontuacao"));
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
    
    public Top mestreDoCampeonato(){
        String sql = "select usuarios.idUsuario, sum(rodadaJogador.pontuacao) as total from usuarios, timeRodada, rodadajogador\r\n" + 
        		"where (usuarios.idUsuario = timeRodada.idUsuario) and (timeRodada.idJogador = rodadaJogador.idJogador) and (timeRodada.idRodada = rodadaJogador.idRodada)\r\n" + 
        		"group by (timeRodada.idUsuario) ORDER BY (total) DESC LIMIT 1";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idMaior = 0;
        float pontuacaoMaior = 0;
        try{
            RodadaDAO r = new RodadaDAO();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            int rodadas = r.totalRodadas();
            r.closeDataBase();
            while(rs.next()){
                
                    idMaior = rs.getInt("idUsuario");
                    pontuacaoMaior = (rs.getInt("total")/rodadas);
            }
            Usuario u = this.selectAll("WHERE idUsuario = '"+idMaior+"'").get(0);
            Top t = new Top(u.getNomeCartoleiro(), u.getNomeTime(),pontuacaoMaior);
            return t;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return null;
    }
    
    public ArrayList<Top> timeRodada(int idU, int idR){
        String sql = "select jogadores.imagem, jogadores.posicao, jogadores.cursoJogador, rodadajogador.pontuacao from timerodada, jogadores, rodadajogador, usuarios\n" +
                     "where (timeRodada.idJogador = rodadaJogador.idJogador) and (jogadores.idJogador = timeRodada.idJogador) and (jogadores.idJogador = rodadaJogador.idJogador)\n" +
                      "and (timeRodada.idUsuario = usuarios.idUsuario) and (rodadaJogador.idRodada = '"+idR+"') and (timeRodada.idUsuario = "+idU+") and (timeRodada.idRodada = "+idR+")";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Top> lista = new ArrayList<Top>();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Top t = new Top(rs.getString("imagem"), rs.getString("posicao"), rs.getFloat("pontuacao"), rs.getInt("cursoJogador"));
                lista.add(t);
            }
            return lista;
        }catch(SQLException ex){
            System.err.println("Erro: "+ ex);
        }
        return lista;
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