package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import dao.*;

/**
 * Servlet implementation class BotarNaLiga
 */
@WebServlet("/BotarNaLiga")
public class BotarNaLiga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BotarNaLiga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuario = Integer.parseInt(request.getParameter("usuario"));
		int liga = Integer.parseInt(request.getParameter("liga"));
		LigaUsuario lu = new LigaUsuario(usuario, liga);
		try {
			LigaUsuarioDAO lud = new LigaUsuarioDAO();
			lud.insertInto(lu);
			lud.closeDataBase();
			response.sendRedirect("VerLiga.jsp?liga="+liga);
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
