package in.co.rays.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserBean;
import in.co.rays.Model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		UserModel model = new UserModel();
		
		try {
			List list= model.search(null, 1, 5);
			req.setAttribute("list", list);
			RequestDispatcher rd= req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			}
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserBean bean=null;
		
		String firstname =req.getParameter("firstName");
		
		String op =req.getParameter("operation");
		
		if(op.equals("search")) {
			
			bean = new UserBean();
			
			bean.setFirstName(firstname);
			
		}
		if(op.equals("add")) {
			
			
			resp.sendRedirect("UserCtl");
		}
		
		 
			UserModel model = new UserModel();
			
			try {
				List list= model.search(null, 1, 0);
				req.setAttribute("list", list);
				RequestDispatcher rd= req.getRequestDispatcher("UserListView.jsp");
				rd.forward(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
				}
		
	}
}
