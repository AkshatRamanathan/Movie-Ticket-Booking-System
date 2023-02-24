package midterm.controller;

import java.io.IOException;
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
 * Servlet implementation class UserProfile
 */
@WebServlet("/userProfile")
public class userProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/userProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDAO loginDAO = new LoginDAO();
		HttpSession session = request.getSession();
		UserSession user = (UserSession) session.getAttribute("userSession");
		String update = request.getParameter("update");
		switch (update) {
		case "details": {	
			user = loginDAO.updateDetails(user, request.getParameter("username"), request.getParameter("email"));
			session.setAttribute("userSession", user);
			break;
		}
		
		case "pass": {	
			loginDAO.updatePassword(request.getParameter("password"),request.getParameter("confirm_password"));
			session.invalidate();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + update);
		}
		
		request.getRequestDispatcher("login").forward(request, response);
	}

}
