package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;
import model.pojo;


@WebServlet("/Userdata")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();	
    
    String uname = request.getParameter("uname");
	String dob = request.getParameter("dob");
		String ugen= request.getParameter("ugen");

  		String uemail = request.getParameter("uemail");
  		String upass = request.getParameter("upass");
  		String cupass = request.getParameter("cupass");
  		
  		System.out.println(uname);
  		System.out.println(dob);
  		System.out.println(ugen);
  		System.out.println(uemail);
  		System.out.println(upass);
  		System.out.println(cupass);
  		
  		uname.trim();
  		dob.trim();
  		ugen.trim();
		uemail.trim(); 
		upass.trim();
		cupass.trim();

  		UserDao ud = new UserDao();
  		pojo p = new pojo(uname,ugen,dob,uemail,upass);
  		
  		
  		try {
  			if(!ud.checkUser(uemail)){
				 if (upass.equals(cupass)) {	  
					    ud.addData(p); 
				        System.out.println("Added Successfullly !!");
				        out.print("<!DOCTYPE html>");
				        out.print("<html>");
				        out.print("<head>");
				        out.print("<meta charset='ISO-8859-1'>");
				        out.print("<title>Insert title here</title>");
				        out.print("<style>");
				        out.print("p{");
				        out.print("background-color: green;");
				        out.print("text-align:center;");
				        out.print("color:white;");
				        out.print("width:60%;");
				        out.print("}");
				        out.print("h2{");
				        out.print("color :red;");
				        out.print("text-align:center;");
				        out.print("width:60%;");
				        out.print("display: flex;");
				        out.print("position:relative;");
				        out.print("top : 20px;");
				        out.print("}");
				        out.print("</style>");
				        out.print("</head>");
				        out.print("<body>");
				        out.print("<marquee scrollamount='12'><h2><p> Registeration Successful !! Please Login</p></h2></marquee>");
				        out.print("</body>");
				        out.print("</html>");				        
				        request.getRequestDispatcher("signIn.html").include(request, response);	


				  } 
				  else if (!upass.equals(cupass))

					{
						request.getRequestDispatcher("signUp.html").include(request, response);
						out.print("<!DOCTYPE html>");
						out.print("<html>");
						out.print("<head>");
						out.print("<meta charset='0ISO-8859-1'>");
						out.print("<title>Insert title here</title>");
						out.print("<style>");
						out.print("p{");
						out.print("background-color: red;");
						out.print("text-align:center;");
						out.print("color:white;");
						out.print("width:60%;");
						out.print("}");
						out.print("h2{");
						out.print("color :red;");
						out.print("text-align:center;");
						out.print("width:60%;");
						out.print("display: flex;");
						out.print("position:relative;");
						out.print("top : 20px;");
						out.print("}");
						out.print("</style>");
						out.print("</head>");
						out.print("<body>");
						out.print("<marquee scrollamount='15'><h2><p> ! Both Psswords are Different</p></h2></marquee>");
						out.print("</body>");
						out.print("</html");
					}
  			}
  			else if(ud.checkUser(uemail)){
  				out.print("YOUR EMAIL IS ALREADY EXIST PLEASE LOGIN !!");
		        request.getRequestDispatcher("signIn.html").include(request, response);			  
  			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
  		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
