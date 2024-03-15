package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet1")
public class FirstServlet1 extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("frist servlet1 do get");
	System.out.println("FirstName ="+ req.getParameter("firstName"));
	
	//RequestDispatcher rd= req.getRequestDispatcher("SecondServlet1");
	
	
	req.setAttribute("lastName", "Barfa");
	
	//rd.forward(req, resp);
	
	resp.sendRedirect("SecondServlet1");
	
	
}	



@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("first servlet1 dopost");
	System.out.println("FirstName ="+ req.getParameter("firstName"));
	
	req.setAttribute("lastName", "parihar");
	
	//RequestDispatcher rd= req.getRequestDispatcher("SecondServlet1");
	//rd.forward(req, resp);
	
	resp.sendRedirect("SecondServlet1");
	
	}
}
