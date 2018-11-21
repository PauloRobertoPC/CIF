package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("*")
public class Login implements Filter {

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		//Usuario u = new Usuario();
		//u = (Usuario) session.getAttribute("usuario");
		
		if((session.getAttribute("usuario") != null) 
				|| (req.getRequestURI().endsWith("/Logar"))
				|| (req.getRequestURI().matches(".*(css|jpg|png|gif|js|jpeg|ico|svg)"))
				|| (req.getRequestURI().endsWith("/TelaLogin.jsp"))
				|| (req.getRequestURI().endsWith("/TelaCadastro.jsp"))
				|| (req.getRequestURI().endsWith("/recuperarsenha.jsp"))
				|| (req.getRequestURI().endsWith("/RecuperarSenha"))) {
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse) response).sendRedirect("/CIF/TelaLogin.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
