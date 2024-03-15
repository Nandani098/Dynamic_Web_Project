package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet1")
public class SecondServlet1 extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	System.out.println("second Servlet do get");
	
  String str= (String) req.getAttribute("lastName");
  
  System.out.println(str);
	
	
	
	
}	
	
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Second Servlet do post");
		
		 String str= (String) req.getAttribute("lastName");
		  
		  System.out.println("LastName =" + str);
			
	}

}
