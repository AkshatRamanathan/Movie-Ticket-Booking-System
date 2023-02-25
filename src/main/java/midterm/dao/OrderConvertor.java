package midterm.dao;

import org.bson.Document;
import org.bson.types.ObjectId;

import midterm.model.Order;


public class OrderConvertor {
	public static Document toDocument(Order order) {

		Document doc = new Document("username", order.getUsername())
				.append("quantity", order.getQuantity())
				.append("cost", order.getCost()).append("status", order.getStatus())
				.append("movie_id", order.getMovie_id());
		
		if (order.get_id() != null) {
			doc.append("_id", order.get_id());
		}
		return doc;

	}

	public static Order toMovie(Document orderDoc) {
		System.out.println(orderDoc);
		Order order = new Order();
		
		order.set_id((ObjectId) orderDoc.get("_id"));
		order.setUsername(orderDoc.get("username").toString());
		order.setQuantity(Integer.parseInt(orderDoc.get("quanitity").toString()));
		order.setCost(orderDoc.get("cost").toString());
		order.setStatus(orderDoc.get("status").toString());
		order.setMovie_id(orderDoc.get("movie_id").toString());

		return order;
	}
}
