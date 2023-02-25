package midterm.dao;

import org.bson.Document;
import org.bson.types.ObjectId;

import midterm.model.Movie;

public class MovieConvertor {
	public static Document toDocument(Movie movie) {

		Document doc = new Document("cost", movie.getCost()).append("genre", movie.getGenre())
				.append("name", movie.getName()).append("release_date", movie.getRelease_date())
				.append("seats_left", movie.getSeats_left());

		if (movie.get_id() != null) {
			doc.append("_id", movie.get_id());
		}
		return doc;

	}

	public static Movie toMovie(Document movieDoc) {
//		System.out.println(movieDoc);
		Movie movie = new Movie();

		movie.set_id((ObjectId) movieDoc.get("_id"));
		movie.setCost(movieDoc.get("cost").toString());
		movie.setGenre(movieDoc.get("genre").toString());
		movie.setName(movieDoc.get("name").toString());
		movie.setRelease_date(movieDoc.get("release_date").toString());
		movie.setSeats_left(movieDoc.get("seats_left").toString());
		return movie;
	}
}
