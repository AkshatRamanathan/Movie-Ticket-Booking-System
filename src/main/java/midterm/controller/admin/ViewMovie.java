package midterm.controller.admin;

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
import midterm.model.Movie;
import midterm.model.Order;
import midterm.model.UserSession;

/**
 * Servlet implementation class ViewBooking
 */
@WebServlet("/viewMovie")
public class ViewMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewMovie() {
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
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
		MovieDAO movieDAO = new MovieDAO(mongoClient);
		String id = request.getParameter("id");
		if (id != null) {
			movieDAO.delete(id);
			response.sendRedirect("controller?action=viewMovie");
			return;
//			request.getRequestDispatcher("/WEB-INF/viewBooking.jsp").forward(request, response);
		}
		List<Movie> movies = movieDAO.getAllMovies();
		request.setAttribute("movies", movies);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/viewMovie.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
