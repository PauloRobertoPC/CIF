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
 * Servlet implementation class CriarLiga
 */
@WebServlet("/CriarLiga")
public class CriarLiga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarLiga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usu = Integer.parseInt(request.getParameter("usu"));
		String nome = request.getParameter("nomeLiga");
		Liga l = new Liga(nome);
		try {
			LigaDAO ld = new LigaDAO();
			if(ld.selectAll("WHERE nomeLiga = '"+nome+"'").size() != 0) {
				ld.closeDataBase();
				response.sendRedirect("Ligas.jsp?modal=1");
			}else {
				ld.insertInto(l);
				l = ld.selectAll("WHERE nomeLiga = '"+nome+"'").get(0);
				ld.closeDataBase();
				LigaUsuario lu = new LigaUsuario(usu, l.getIdLiga());
				LigaUsuarioDAO lud = new LigaUsuarioDAO();
				lud.insertInto(lu);
				lud.closeDataBase();
				response.sendRedirect("VerLiga.jsp?liga="+l.getIdLiga());
			}
			
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
