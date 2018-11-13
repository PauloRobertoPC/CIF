package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import dao.UsuarioDAO;
import model.LigaUsuario;
import dao.LigaUsuarioDAO;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/Cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastrar() {
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
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		int curso = Integer.parseInt(request.getParameter("curso"));
		Usuario u = new Usuario(nome, login, senha, "", "", curso, 3);
		
		try {
			UsuarioDAO udao = new UsuarioDAO();
			if(udao.selectAll("WHERE login = '"+login+"'").size() == 1) {
				/*Se o tamanho é igual a 1, que dizer que existe um usuario com aquele
				  login,ou seja, ele não pode ser cadastrado com esse login*/
				response.sendRedirect("TelaCadastro.jsp?modal=1");
				udao.closeDataBase();
			}else {
				udao.insertIntoNull(u);
				int idUser = udao.selectAll("WHERE login = '"+login+"'").get(0).getIdUsuario();
				udao.closeDataBase();
				LigaUsuario lu = new LigaUsuario(idUser, 7);
				LigaUsuario lc = new LigaUsuario(idUser, curso);
				LigaUsuarioDAO ludao = new LigaUsuarioDAO();
				ludao.insertInto(lu);
				ludao.insertInto(lc);
				ludao.closeDataBase();
				response.sendRedirect("TelaLogin.jsp?modal=3");
			}
			
		} catch (SQLException e) {
			response.sendRedirect("TelaCadastro.jsp");
			e.printStackTrace();
		}
		
	}

}
