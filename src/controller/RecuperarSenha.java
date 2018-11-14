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
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class RecuperarSenha
 */
@WebServlet("/RecuperarSenha")
public class RecuperarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarSenha() {
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
		String email = request.getParameter("email");
		try {
			UsuarioDAO ud = new UsuarioDAO();
			if(ud.selectAll("WHERE email = '"+email+"'").size() != 0) {
				Usuario u = ud.selectAll("WHERE email = '"+email+"'").get(0);
				Properties props = new Properties();
		        props.put("mail.smtp.host", "smtp.gmail.com");
		        props.put("mail.smtp.socketFactory.port", "465");
		        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.port", "465");
		        
		        Session session = Session.getDefaultInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication(){
		                    return new PasswordAuthentication("cartolaif2018@gmail.com", "CIF2018.");
		                }
		            });
		            session.setDebug(true);
		 
		            try {
		 
		                Message message = new MimeMessage(session);
		                message.setFrom(new InternetAddress("cartolaif2018@gmail.com")); //Remetente
		 
		                Address[] toUser = InternetAddress //Destinatário(s)
		                             .parse(email);  
		 
		                message.setRecipients(Message.RecipientType.TO, toUser);
		                message.setSubject("Recuperação de email Cartola IF");//Assunto
		                message.setText("Sua senha é: "+u.getSenha()+"\nPara mudar sua senha acesse o seu perfil depois de logado.");
		                Transport.send(message);
		                ud.closeDataBase();
		                response.sendRedirect("TelaLogin.jsp?modal=4");
		 
		            }
		            catch (MessagingException e) {
		                  throw new RuntimeException(e);
		            }
				
			}else {
				ud.closeDataBase();
				response.sendRedirect("recuperarsenha.jsp?modal=1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
