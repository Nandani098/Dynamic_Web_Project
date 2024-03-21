package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FrontCtl", urlPatterns = "*.do")
public class FrontCtl implements Filter{
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		     HttpServletRequest request =(HttpServletRequest)req;
		     HttpServletResponse response =(HttpServletResponse)resp;
		     
		     HttpSession session = request.getSession();
		     
		     String uri = request.getRequestURI();
		     
		     System.out.println("uri =>" + uri);
		    
		     if (session.getAttribute("user")==null) {
		    	 req.setAttribute("msg", "session expired ..pls login again..!!");
		    	 req.setAttribute("uri", uri);
		    	 RequestDispatcher rd= req.getRequestDispatcher("LoginView.jsp");
		    	 rd.forward(request, response);
				
			} else {
				chain.doFilter(req, resp);

			}
		
	}
	@Override
	public void destroy() {
		
		
	}
}
