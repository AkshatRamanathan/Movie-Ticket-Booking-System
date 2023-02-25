package midterm.controller.admin;

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
@WebServlet("/editMovie")
public class EditMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovie() {
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
		request.getRequestDispatcher("/WEB-INF/admin/editMovie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Movie movie = (Movie) session.getAttribute("movie");
		//edit the details inside this movie
		movie.setName(request.getParameter("name"));
		movie.setGenre(request.getParameter("genre"));
		movie.setCost(request.getParameter("cost"));
		movie.setRelease_date(request.getParameter("release_date"));
		movie.setSeats_left(request.getParameter("seats_left"));
		// call the movie dao update function
		ServletContext application = request.getServletContext();
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
	    MovieDAO movieDAO = new MovieDAO(mongoClient);
	    movieDAO.update(movie);
		//redirect to success page, dashboard from there
		request.getRequestDispatcher("/WEB-INF/admin/editStatus.jsp").forward(request, response);
		
	}

}
