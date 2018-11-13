package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import dao.*;
import util.Util;

/**
 * Servlet implementation class Crud
 */
@WebServlet("/Crud")
public class Crud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opcao = Integer.parseInt(request.getParameter("opcao"));
		int operacao = Integer.parseInt(request.getParameter("operacao"));
		if(opcao == 1) {
			if(operacao == 1) {
				String nome = request.getParameter("nomeJogador");
				String posicao = request.getParameter("posicao");
				String imagem = request.getParameter("imagem");
				int curso = Integer.parseInt(request.getParameter("curso"));
				Jogador j = new Jogador(nome, posicao, imagem, curso);
				try {
					JogadorDAO jd = new JogadorDAO();
					jd.insertInto(j);
					jd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(operacao == 2) {
				String nome = request.getParameter("nome");
				String posicao = request.getParameter("posicao");
				String imagem = request.getParameter("imagem");
				int curso = Integer.parseInt(request.getParameter("curso"));
				int id = Integer.parseInt(request.getParameter("id"));
				Jogador j = new Jogador(nome, posicao, imagem, curso);
				j.setIdJogador(id);
				try {
					JogadorDAO jd = new JogadorDAO();
					jd.update(j);
					jd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					JogadorDAO jd = new JogadorDAO();
					jd.delete(id);
					jd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(opcao == 2) {
			if(operacao == 1) {
				String nome = request.getParameter("nomeCurso");
				String imagem = request.getParameter("imagemCurso");
				int eliminado = Integer.parseInt(request.getParameter("eliminado"));
				Curso c = new Curso(nome, imagem, eliminado);
				try {
					CursoDAO cd = new CursoDAO();
					cd.insertInto(c);
					cd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(operacao == 2) {
				String nome = request.getParameter("nome");
				String imagem = request.getParameter("imagem");
				int id = Integer.parseInt(request.getParameter("id"));
				int eliminado = Integer.parseInt(request.getParameter("eliminado"));
				Curso c = new Curso(id, nome, imagem, eliminado);
				try {
					CursoDAO cd = new CursoDAO();
					cd.update(c);
					cd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					CursoDAO cd = new CursoDAO();
					cd.delete(id);
					cd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(opcao == 3) {
			if(operacao == 1) {
				int curso1 = Integer.parseInt(request.getParameter("curso1"));
				int curso2 = Integer.parseInt(request.getParameter("curso2"));
				int placar1 = Integer.parseInt(request.getParameter("placar1"));
				int placar2 = Integer.parseInt(request.getParameter("placar2"));
				String localizacao = request.getParameter("local");
				String datahora = request.getParameter("dh");
				int idRodada = Integer.parseInt(request.getParameter("rodada"));
				Jogos j = new Jogos(0, curso1, curso2, placar1, placar2, localizacao, datahora, idRodada);
				try {
					JogosDAO jd = new JogosDAO();
					jd.insertInto(j);
					jd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(operacao == 2) {
				int idJogo = Integer.parseInt(request.getParameter("idJogo"));
				int curso1 = Integer.parseInt(request.getParameter("curso1"));
				int curso2 = Integer.parseInt(request.getParameter("curso2"));
				int placar1 = Integer.parseInt(request.getParameter("placar1"));
				int placar2 = Integer.parseInt(request.getParameter("placar2"));
				String localizacao = request.getParameter("localizacao");
				String datahora = request.getParameter("datahora");
				int idRodada = Integer.parseInt(request.getParameter("rodada"));
				Jogos j = new Jogos(idJogo, curso1, curso2, placar1, placar2, localizacao, datahora, idRodada);
				try {
					JogosDAO jd = new JogosDAO();
					jd.update(j);
					jd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int idJogo = Integer.parseInt(request.getParameter("idJogo"));
				try {
					JogosDAO jd = new JogosDAO();
					jd.delete(idJogo);
					jd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(opcao == 4) {
			if(operacao == 1) {
				int jogador = Integer.parseInt(request.getParameter("jogador"));
				int rodada = Integer.parseInt(request.getParameter("rodada"));
				float pontuacao = Float.parseFloat(request.getParameter("pontuacao"));
				RodadaJogador rj = new RodadaJogador(pontuacao, rodada, jogador);
				try {
					RodadaJogadorDAO rjd = new RodadaJogadorDAO();
					rjd.insertInto(rj);
					rjd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(operacao == 2) {
				int jogador = Integer.parseInt(request.getParameter("jogador"));
				int rodada = Integer.parseInt(request.getParameter("rodada"));
				float pontuacao = Float.parseFloat(request.getParameter("pontuacao"));
				try {
					RodadaJogadorDAO rjd = new RodadaJogadorDAO();
					rjd.updatePuntuacao(pontuacao, rodada, jogador);
					rjd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int jogador = Integer.parseInt(request.getParameter("jogador"));
				int rodada = Integer.parseInt(request.getParameter("rodada"));
				try {
					RodadaJogadorDAO rjd = new RodadaJogadorDAO();
					rjd.delete(rodada, jogador);
					rjd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}else if(opcao == 5) {
			if(operacao == 1) {
				String nome = request.getParameter("nome");
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
				int curso = Integer.parseInt(request.getParameter("curso"));
				int idtipousuario = Integer.parseInt(request.getParameter("tipousuario"));
				Usuario u = new Usuario(nome, login, senha, curso, idtipousuario);
				try {
					UsuarioDAO ud = new UsuarioDAO();
					if(ud.selectAll("WHERE login = '"+login+"'").size() == 0){
						ud.insertIntoNull(u);
						int id = ud.selectAll("WHERE login = '"+login+"'").get(0).getIdUsuario();
						LigaUsuarioDAO lud = new LigaUsuarioDAO();
						LigaUsuario lu = new LigaUsuario(id, 7);
						LigaUsuario lc = new LigaUsuario(id, curso);
						lud.insertInto(lu);
						lud.insertInto(lc);
						lud.closeDataBase();
						ud.closeDataBase();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(operacao == 2) {
				String nome = request.getParameter("nome");
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
				String nometime = request.getParameter("nometime");
				String nomecartoleiro = request.getParameter("nomecartoleiro");
				int curso = Integer.parseInt(request.getParameter("curso"));
				int idtipousuario = Integer.parseInt(request.getParameter("tipousuario"));
				int id = Integer.parseInt(request.getParameter("id"));
				Usuario u = new Usuario(nome, login, senha, nometime, nomecartoleiro,curso, idtipousuario);
				u.setIdUsuario(id);
				try {
					UsuarioDAO ud = new UsuarioDAO();
					ud.update(u);
					ud.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					
					TimeRodadaDAO trd = new TimeRodadaDAO();
					trd.delete(id);
					trd.closeDataBase();
					LigaUsuarioDAO lud = new LigaUsuarioDAO();
					lud.delete(id);
					lud.closeDataBase();
					UsuarioDAO ud = new UsuarioDAO();
					ud.delete(id);
					ud.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(opcao == 6) {
			if(operacao == 1) {
				String nomerodada = request.getParameter("nomerodada");
				String datainicio = request.getParameter("datai");
				String datafim = request.getParameter("dataf");
				Util u = new Util();
				try {
					Rodada r = new Rodada(nomerodada, u.convDataJava(u.convDataFormToBanco(datainicio)), u.convDataJava(u.convDataFormToBanco(datafim)));
					RodadaDAO rd = new RodadaDAO();
					if(rd.selectAll("WHERE nomeRodada ='"+nomerodada+"'").size() == 0) {
						rd.insertInto(r);
					}
					rd.closeDataBase();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(operacao == 2) {
				int id = Integer.parseInt(request.getParameter("id"));
				String nome = request.getParameter("nomerodada");
				String datai = request.getParameter("datai");
				String dataf = request.getParameter("dataf");
				Util u = new Util();
				try {
					Rodada r = new Rodada(nome, u.convDataJava(u.convDataFormToBanco(datai)), u.convDataJava(u.convDataFormToBanco(dataf)));
					r.setIdRodada(id);
					RodadaDAO rd = new RodadaDAO();
					rd.update(r);
					rd.closeDataBase();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					RodadaDAO rd = new RodadaDAO();
					TimeRodadaDAO trd = new TimeRodadaDAO();
					JogosDAO jd = new JogosDAO();
					RodadaJogadorDAO rjd = new RodadaJogadorDAO();
					if(trd.selectAll("WHERE idRodada = '"+id+"'").size() != 0) {
						trd.deleteRodada(id);
					}
					if(jd.selectAll("WHERE idRodada = '"+id+"'").size() != 0) {
						jd.deleteRodada(id);
					}
					if(rjd.selectAll("WHERE idRodada = '"+id+"'").size() != 0) {
						rjd.deleteRodada(id);
					}
					trd.closeDataBase();
					jd.closeDataBase();
					rjd.closeDataBase();
					rd.delete(id);
					rd.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			if(operacao == 1) {
				String nome = request.getParameter("nome");
				Liga l = new Liga(nome);
				try {
					LigaDAO ld = new LigaDAO();
					if(ld.selectAll("WHERE nomeLiga = '"+nome+"'").size() == 0) {
						ld.insertInto(l);
					}
					ld.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(operacao == 2) {
				String nome = request.getParameter("nome");
				int id = Integer.parseInt(request.getParameter("id"));
				Liga l = new Liga(nome);
				l.setIdLiga(id);
				try {
					LigaDAO ld = new LigaDAO();
					ld.update("nomeLiga", nome, id);
					ld.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					LigaUsuarioDAO lud = new LigaUsuarioDAO();
					LigaDAO ld = new LigaDAO();
					if(lud.selectAll("WHERE idLiga = '"+id+"'").size() != 0){
						lud.deleteLiga(id);
					}
					lud.closeDataBase();
					ld.delete(id);
					ld.closeDataBase();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
