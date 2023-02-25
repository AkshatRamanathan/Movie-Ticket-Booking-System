package midterm.controller;

import java.io.IOException;

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
import midterm.model.UserSession;

/**
 * Servlet implementation class MovieBooking
 */
@WebServlet("/movieBooking")
public class MovieBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = request.getServletContext();
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
	    MovieDAO movieDAO = new MovieDAO(mongoClient);
		Movie movie = movieDAO.getMovie(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("movie", movie);
		request.getRequestDispatcher("/WEB-INF/movieBooking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Movie movie = (Movie) session.getAttribute("movie");
		ServletContext application = request.getServletContext();
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
	    MovieDAO movieDAO = new MovieDAO(mongoClient);
	    String quantity = request.getParameter("quantity");
	    UserSession userSession = (UserSession) session.getAttribute("userSession");
		movieDAO.bookMovie(movie,quantity,userSession.getUsername());
		request.getRequestDispatcher("/WEB-INF/bookingStatus.jsp").forward(request, response);
		
	}

}
