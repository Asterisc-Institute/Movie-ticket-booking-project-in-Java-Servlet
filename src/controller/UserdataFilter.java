package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import model.UserDao;
import model.pojo;


@WebFilter("/UserdataFilter")
public class UserdataFilter implements Filter {

   
    public UserdataFilter() {
      
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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
					 if (upass.equals(cupass)) {						  
						    ud.addData(p); 
					        System.out.println("Added Successfullly !!");
					        out.print("Registeration successful !! please login");
					        request.getRequestDispatcher("signIn.html").include(request, response);	
					  } 
					  else if (!upass.equals(cupass))

						{
							request.getRequestDispatcher("signUp.html").include(request, response);
							out.print("Enter Both Passwords Same !");
						}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
