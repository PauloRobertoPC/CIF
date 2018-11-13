package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;

/**
 * Servlet implementation class SairDaLiga
 */
@WebServlet("/SairDaLiga")
public class SairDaLiga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SairDaLiga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuario = Integer.parseInt(request.getParameter("usuario"));
		int liga = Integer.parseInt(request.getParameter("liga"));
		try {
			LigaUsuarioDAO lud = new LigaUsuarioDAO();
			lud.delete(usuario, liga);
			if(lud.totalParticipantes(liga) == 0) {
				LigaDAO ld = new LigaDAO();
				ld.delete(liga);
				ld.closeDataBase();
			}
			lud.closeDataBase();
			response.sendRedirect("Ligas.jsp");
		} catch (SQLException e) {
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
