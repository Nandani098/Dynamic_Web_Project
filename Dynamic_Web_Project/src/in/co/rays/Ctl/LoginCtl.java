package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.Bean.UserBean;
import in.co.rays.Model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//resp.sendRedirect("LoginView.jsp");

		
		// ye session destroy k liye tha
		 
		 String op= req.getParameter("operation");
		 
		 if(op!=null) {
		 
		 HttpSession session= req.getSession(); 
		 
		 
		 session.invalidate();
		 
		 
		 
		 }
		 
		 resp.sendRedirect("LoginView.jsp");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");

		UserModel model = new UserModel();

		try {
			UserBean bean = model.authenticate(login, pass);

			if (bean != null) {
				// resp.sendRedirect("Welcome1.jsp");
//				req.setAttribute("user", bean);
//				
//				RequestDispatcher rd = req.getRequestDispatcher("Welcome1.jsp");
//			    rd.forward(req, resp);

				// create session method

				HttpSession session = req.getSession();

				session.setAttribute("user", bean);

				resp.sendRedirect("Welcome1.jsp");

			} else {

				// resp.sendRedirect("LoginView");

				req.setAttribute("msg", "login id & password is invalid");
				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
