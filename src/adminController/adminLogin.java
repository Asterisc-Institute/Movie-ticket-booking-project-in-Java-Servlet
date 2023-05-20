package adminController;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminModel.adminDao;


@WebServlet("/admin")
public class adminLogin extends HttpServlet {  
	private static final long serialVersionUID = 1L;
       
    
    public adminLogin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String checkeMail = request.getParameter("email");
		String checkepass = request.getParameter("pass");

		adminDao ad = new adminDao();

		try {
			if(ad.checkForLogin(checkeMail, checkepass)){
				 
//				response.sendRedirect("");
				request.getRequestDispatcher("HomeAdmin.html").include(request, response);		
				System.out.println("aheayyyy");

			}
			else{
		        request.getRequestDispatcher("signIn.html").include(request, response);	
		        System.out.println("no bud");
		        out.print("Username Or Password Didn't Match!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
