package videoStore;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return movie.getTitle();
	}

	double determineAmount() {
		return movie.determineAmount(daysRented);
	}

	int determineFrequentRenterPoints() {
		return movie.determineFrequentRenterPoints(daysRented);
	}
}