package midterm.controller.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import com.mongodb.MongoClient;

import midterm.dao.MovieDAO;
import midterm.model.Movie;

/**
 * Servlet implementation class addMovie
 */
@WebServlet("/addMovie")
public class addMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/admin/addMovie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String genre = request.getParameter("genre");
		String cost = request.getParameter("cost");
		String release_date = request.getParameter("release_date");
		String seats_left = request.getParameter("seats_left");
		
		ServletContext application = request.getServletContext();
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
	    MovieDAO movieDAO = new MovieDAO(mongoClient);
	    Movie movie = new Movie();
	    movie.setCost(cost);
	    movie.setGenre(genre);
	    movie.setName(name);
	    movie.setRelease_date(release_date);
	    movie.setSeats_left(seats_left);
	    movie = movieDAO.create(movie);
	    if(movie!=null) {
			request.getRequestDispatcher("/WEB-INF/admin/movieStatus.jsp").forward(request, response);
	    }
	}

}
