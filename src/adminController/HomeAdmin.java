package adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeAdmin")
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();
     
     String movieN = request.getParameter("movieN");
     int price = Integer.parseInt(request.getParameter("price"));
     String actors = request.getParameter("actors");
     String director = request.getParameter("director");
     String upload = request.getParameter("upload");
     
     movieN.trim();
     actors.trim();
     director.trim();
     upload.trim();
     

     
     
     System.out.println(movieN);
     System.out.println(price);
     System.out.println(actors);
     System.out.println(director);
     System.out.println(upload);


		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
