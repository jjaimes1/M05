package video;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import video.Customer;
import video.Movie;
import video.Rental;
import video.Videoclub;

public class TestVideoclub {
	static Videoclub V;
	static String s;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		V = new Videoclub();
		s = "Rental Record for Luc�a\n" + "	Star Wars	3.0\n" + "	La Princesa Prometida	2.0\n"
				+ "	Green Book	6.0\n" + "Amount owed is 11.0\n" + "You earned 4 frequent renter points";
	}

	@Test
	public void test() {
		Customer customer = new Customer("Luc�a");
		Movie movie1 = new Movie("Star Wars", Movie.CHILDREN);
		Movie movie2 = new Movie("La Princesa Prometida", Movie.REGULAR);
		Movie movie3 = new Movie("Green Book", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(movie1, 4);
		Rental rental2 = new Rental(movie2, 1);
		Rental rental3 = new Rental(movie3, 2);
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		assertEquals(String.valueOf(s), String.valueOf(customer.statement()));
	}

}
