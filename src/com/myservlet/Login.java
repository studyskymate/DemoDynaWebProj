package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserAccount;
import com.myservlet.dao.DbInteraction;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  response.setContentType("text/html"); 
          PrintWriter out = response.getWriter(); 
          
		UserAccount userAccount= new UserAccount();
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		userAccount.setName(username);
		userAccount.setPassword((password));
		
		DbInteraction di= new DbInteraction();
		boolean status=di.save(userAccount);
		
		System.out.println("Save"+status);
		System.out.println("Save");
		
	     out.print("!User created Successfully");
	     RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");
	     rd.include(request, response);
		
	}

}
