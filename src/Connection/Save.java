package Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;


@WebServlet("/Save")
public class Save extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		
		 Student e=new Student();  
	        
	        e.setName(name);  
	        e.setAddress(address);  
	        e.setEmail(email);  
	        
	        try 
	        {
			int status=StudentDao.Save(e);
		    request.getRequestDispatcher("index.html").include(request, response);  
		       
			} 
	        
	        catch (ClassNotFoundException | SQLException e1)
	        {
				e1.printStackTrace();
			}
		 
	        out.close();  
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
