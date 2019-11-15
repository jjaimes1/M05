package video;
public class Videoclub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer = new Customer("Lucía");
		Movie movie1 = new Movie("Star Wars", Movie.CHILDREN);
		Movie movie2 = new Movie("La Princesa Prometida", Movie.REGULAR);
		Movie movie3 = new Movie("Green Book", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(movie1, 4);
		Rental rental2 = new Rental(movie2, 1);
		Rental rental3 = new Rental(movie3, 2);
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		
		String s = customer.statement();
		System.out.println(s);
	}

}
