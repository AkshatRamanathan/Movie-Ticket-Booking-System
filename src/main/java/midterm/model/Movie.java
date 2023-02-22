package midterm.model;

import org.bson.types.ObjectId;

public class Movie {

	private ObjectId _id;
	private String name;
	private String genre;
	private String cost;
	private String release_date;
	private String seats_left;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getSeats_left() {
		return seats_left;
	}

	public void setSeats_left(String seats_left) {
		this.seats_left = seats_left;
	}

}
