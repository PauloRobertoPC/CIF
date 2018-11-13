package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDAO;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 * Servlet implementation class TimeCartoleiro
 */
@WebServlet("/TimeCartoleiro")
public class TimeCartoleiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeCartoleiro() {
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
		String time = request.getParameter("nometime");
		String cartoleiro = request.getParameter("nomecartoleiro");
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			UsuarioDAO ud = new UsuarioDAO();
			int modal = 0;
			if(ud.selectAll("WHERE nomeTime = '"+time+"'").size() != 0) {
				modal = 1;
			}
			if(ud.selectAll("WHERE nomeCartoleiro = '"+cartoleiro+"'").size() != 0) {
				modal = 2;
			}
			if(modal != 0) {
				ud.closeDataBase();
				response.sendRedirect("tutorial.jsp?modal="+modal);
			}else {
				ud.update("nomeTime", time, id);
				ud.update("nomeCartoleiro", cartoleiro, id);
				Usuario u = ud.selectAll("WHERE idUsuario = '"+id+"'").get(0);
				ud.closeDataBase();
				HttpSession session = request.getSession();
				session.setAttribute("usuario", u);
				request.getRequestDispatcher("PaginaInicial.jsp"). forward (request, response);
			}
			/*ud.update("nomeTime", time, id);
			ud.update("nomeCartoleiro", cartoleiro, id);
			Usuario u = ud.selectAll("WHERE idUsuario = '"+id+"'").get(0);
			ud.closeDataBase();
			HttpSession session = request.getSession();
			session.setAttribute("usuario", u);
			request.getRequestDispatcher("PaginaInicial.jsp"). forward (request, response);*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
