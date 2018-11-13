package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Util;
import dao.*;
import model.*;
/**
 * Servlet implementation class Escalar
 */
@WebServlet("/Escalar")
public class Escalar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Escalar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuario = Integer.parseInt(request.getParameter("usuario"));
		String stecnico = request.getParameter("tecnico");
		String sgoleiro = request.getParameter("goleiro");
		String sfixo = request.getParameter("fixo");
		String salae = request.getParameter("alae");
		String salad = request.getParameter("alad");
		String spivo = request.getParameter("pivo");
		
		/*int tecnico = Integer.parseInt(request.getParameter("tecnico"));
		int goleiro = Integer.parseInt(request.getParameter("goleiro"));
		int fixo = Integer.parseInt(request.getParameter("fixo"));
		int alae = Integer.parseInt(request.getParameter("alae"));
		int alad = Integer.parseInt(request.getParameter("alad"));
		int pivo = Integer.parseInt(request.getParameter("pivo"));*/
		
		
		try {
			TimeRodadaDAO trd = new TimeRodadaDAO();
			Util util = new Util();
			int rodada = util.rodadaCorrente();
			if(!trd.selectAll("WHERE idUsuario = '"+usuario+"'").isEmpty()) {
				trd.delete(usuario, rodada);
			}
			
		if(stecnico != "") {
			int tecnico = Integer.parseInt(stecnico);
			TimeRodada tr1 = new TimeRodada(usuario, tecnico, rodada);
			trd.insertInto(tr1);
		}
		if(sgoleiro != "") {
			int goleiro = Integer.parseInt(sgoleiro);
			TimeRodada tr2 = new TimeRodada(usuario, goleiro, rodada);
			trd.insertInto(tr2);
		}
		if(sfixo != "") {
			int fixo = Integer.parseInt(sfixo);
			TimeRodada tr3 = new TimeRodada(usuario, fixo, rodada);
			trd.insertInto(tr3);
		}
		if(salae != "") {
			int alae = Integer.parseInt(salae);
			TimeRodada tr4 = new TimeRodada(usuario, alae, rodada);
			trd.insertInto(tr4);
		}
		if(salad != "") {
			int alad = Integer.parseInt(salad);
			TimeRodada tr5 = new TimeRodada(usuario, alad, rodada);
			trd.insertInto(tr5);
		}
		if(spivo != "") {
			int pivo = Integer.parseInt(spivo);
			TimeRodada tr6 = new TimeRodada(usuario, pivo, rodada);
			trd.insertInto(tr6);
		}
			
			/*TimeRodada tr1 = new TimeRodada(usuario, tecnico, rodada);
			TimeRodada tr2 = new TimeRodada(usuario, goleiro, rodada);
			TimeRodada tr3 = new TimeRodada(usuario, fixo, rodada);
			TimeRodada tr4 = new TimeRodada(usuario, alae, rodada);
			TimeRodada tr5 = new TimeRodada(usuario, alad, rodada);
			TimeRodada tr6 = new TimeRodada(usuario, pivo, rodada);
			
			trd.insertInto(tr2);
			trd.insertInto(tr3);
			trd.insertInto(tr4);
			trd.insertInto(tr5);
			trd.insertInto(tr6);*/
			trd.closeDataBase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
