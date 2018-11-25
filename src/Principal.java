import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import dao.CursoDAO;
import dao.JogadorDAO;
import dao.UsuarioDAO;
import model.Curso;
import model.Jogador;
import model.Top;
import model.Usuario;
import util.Util;
public class Principal {

	public static void main(String[] args) throws SQLException, ParseException {
		/*Util u = new Util();
		UsuarioDAO ud = new UsuarioDAO();
		ArrayList<Top> lista = ud.topTimes(u.rodadaCorrente() - 1);
		int c = 0;
		while(c < lista.size()) {
			System.out.println(c);
			System.out.println(lista.get(c).getNome());
			System.out.println(lista.get(c).getNomeTime());
			System.out.println(u.pontoFlutuante(lista.get(c).getPontuacao(), 2)+"\n");
			c++;
		}*/
		
		/*Util u = new Util();
		JogadorDAO jd = new JogadorDAO();
		CursoDAO cdao = new CursoDAO();
		ArrayList<Top> lista = jd.topRodada(u.rodadaCorrente() - 1);
		int c = 0;
		while(c < lista.size()){
        	Jogador j = jd.selectAll("WHERE idJogador = '"+lista.get(c).getIdGuambiarra()+"'").get(0);
        	String cursos = u.tratarPasta(cdao.selectAll("WHERE idCurso ='"+j.getCursoJogador()+"'").get(0).getNomeCurso());
        	System.out.println(c+1);
        	System.out.println("<img src='imagens/jogadores/"+cursos+"/"+lista.get(c).getNomeTime()+"'>");
        	System.out.println(lista.get(c).getNome());
        	System.out.println(u.pontoFlutuante(lista.get(c).getPontuacao(), 2)+" Pontos\n\n");
            c++;
        }*/
		
		/*Util u = new Util();
		CursoDAO cdao = new CursoDAO();
		JogadorDAO jd = new JogadorDAO();
		ArrayList<Top> lista = jd.top3EscaladosRodada(u.rodadaCorrente() - 1);
		int c = 0;
		while(c < lista.size()){
        	Jogador j1 = jd.selectAll("WHERE idJogador = '"+lista.get(c).getIdGuambiarra()+"'").get(0);
        	String cursos = u.tratarPasta(cdao.selectAll("WHERE idCurso ='"+j1.getCursoJogador()+"'").get(0).getNomeCurso());
        	System.out.println(c+1);
        	System.out.println("<img src='imagens/jogadores/"+cursos+"/"+lista.get(c).getNomeTime()+"'>");
        	System.out.println(lista.get(c).getNome());
        	System.out.println(u.pontoFlutuante(lista.get(c).getPontuacao(), 0)+"\n\n");
            c++;
        }*/

		ArrayList<Jogador> v = new ArrayList();
		JogadorDAO jdao = new JogadorDAO();
		v = jdao.selectAll("ORDER BY (posicao)");
		jdao.closeDataBase();
		ArrayList<Curso> curso = new ArrayList();
		CursoDAO cdao = new CursoDAO();
		curso = cdao.selectAll();
		int c = 0;
		while (c < v.size()) {
			if(curso.get(v.get(c).getCursoJogador() - 1).getEliminado() != 1){
				System.out.println("Esse sim");
			}else {
				System.out.println(curso.get(v.get(c).getCursoJogador()).getEliminado());
				System.out.println("Esse não");
			}
			c++;
		}
	}
}
