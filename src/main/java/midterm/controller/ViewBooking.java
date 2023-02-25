package midterm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;

import midterm.dao.MovieDAO;
import midterm.model.Order;
import midterm.model.UserSession;

/**
 * Servlet implementation class ViewBooking
 */
@WebServlet("/viewBooking")
public class ViewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
		MovieDAO movieDAO = new MovieDAO(mongoClient);
		String id = request.getParameter("id");
		if (id != null) {
			movieDAO.deleteOrder(id);
			response.sendRedirect("controller?action=viewBooking");
			return;
//			request.getRequestDispatcher("/WEB-INF/viewBooking.jsp").forward(request, response);
		}
		List<Order> orders = movieDAO.getOrders(userSession.getUsername());
		System.out.println(orders);
		request.setAttribute("orders", orders);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/viewBooking.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		// cancel logic here
	}

}
