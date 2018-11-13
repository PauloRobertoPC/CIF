package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDAO;

/**
 * Servlet implementation class MudarSenha
 */
@WebServlet("/MudarSenha")
public class MudarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MudarSenha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String senhaantiga = request.getParameter("senhaantiga");
		String senhanova1 = request.getParameter("senhanova1");
		String senhanova2 = request.getParameter("senhanova2");
		int idU = Integer.parseInt(request.getParameter("idU"));
		try {
			UsuarioDAO ud = new UsuarioDAO();
			if(ud.selectAll("WHERE idUsuario = '"+idU+"'").get(0).getSenha().equals(senhaantiga)) {
				if(senhanova1.equals(senhanova2)) {
					ud.update("senha", senhanova1, idU);
					ud.closeDataBase();
					response.sendRedirect("MeuPerfil.jsp?modal=3");
				}else {
					//Senha Nova 1 não condiz com a 2
					response.sendRedirect("MeuPerfil.jsp?modal=2");
				}
			}
			else {
				//Senha antiga errada!
				response.sendRedirect("MeuPerfil.jsp?modal=1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
