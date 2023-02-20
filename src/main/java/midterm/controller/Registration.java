package midterm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.dao.LoginDAO;
import midterm.model.UserRegistration;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = {"/Registration","/registration"})
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		UserRegistration userRegistration = new UserRegistration(firstname, lastname, username, password, email, UserRegistration.Role.CUSTOMER);
		ServletContext application = request.getServletContext();
		application.setAttribute("userRegistration", userRegistration);
		
		LoginDAO loginDAO = new LoginDAO();
		if(loginDAO.registerUser(userRegistration)){			
			request.getRequestDispatcher("/WEB-INF/registrationStatus.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("index.html").forward(request, response);
		
		}
		
	}

}
