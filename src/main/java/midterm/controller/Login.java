package midterm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import midterm.dao.LoginDAO;
import midterm.model.UserRegistration;
import midterm.model.UserSession;

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
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		if(userSession != null) {
			response.sendRedirect("controller");
		}else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean loginStatus = false;
		String errorMsg = "Error: Invalid username or password";
		
		LoginDAO loginDAO = new LoginDAO(); 
		UserSession userSession = loginDAO.validateLogin(username, password);
		
		if(userSession != null) {
			HttpSession session = request.getSession();
			if(UserRegistration.Role.ADMIN == userSession.getRole()) {
				userSession.setCurrentPage("adminDashboard");
			}else {
				userSession.setCurrentPage("userDashboard");
			}
			session.setAttribute("userSession", userSession);
			loginStatus = true;	
		}
		if(loginStatus) {	
			response.sendRedirect("controller");
		}
		else {
			request.setAttribute("errorMsg",errorMsg);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}

		
		
	}

}
