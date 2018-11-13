package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LigaUsuarioDAO;
import dao.TimeRodadaDAO;
import dao.UsuarioDAO;

/**
 * Servlet implementation class ApagarConta
 */
@WebServlet("/ApagarConta")
public class ApagarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarConta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			TimeRodadaDAO trd = new TimeRodadaDAO();
			if(trd.selectAll("WHERE idUsuario = '"+id+"'").size() != 0) {
				trd.delete(id);
			}
			trd.closeDataBase();
			LigaUsuarioDAO lud = new LigaUsuarioDAO();
			if(lud.selectAll("WHERE idUsuario = '"+id+"'").size() != 0) {
				lud.delete(id);
			}
			lud.closeDataBase();
			UsuarioDAO ud = new UsuarioDAO();
			ud.delete(id);
			ud.closeDataBase();
			response.sendRedirect("TelaLogin.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
