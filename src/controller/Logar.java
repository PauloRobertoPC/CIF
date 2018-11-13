package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class Logar
 */
@WebServlet("/Logar")
public class Logar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		HttpSession session = request.getSession();
		//session.invalidate();
		try {
			UsuarioDAO udao = new UsuarioDAO();
			Usuario u = new Usuario();
			if(udao.selectAll("WHERE login = '"+login+"'").size() == 0) {
				udao.closeDataBase();
				response.sendRedirect("TelaLogin.jsp?modal=1");
			}else {
				u = udao.selectAll("WHERE login = '"+login+"'").get(0);
				udao.closeDataBase();
				if(senha.equals(u.getSenha())) {
					session.setAttribute("usuario", u);
					request.getRequestDispatcher("PaginaInicial.jsp"). forward (request, response);
				}else {
					response.sendRedirect("TelaLogin.jsp?modal=2");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
