package videoStore;

public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double determineAmount(int daysRented) {
		double rentalAmount = 2;
		if (daysRented > 2)
			rentalAmount += (daysRented - 2) * 1.5;
		
		return rentalAmount;
	}

	@Override
	protected int determineFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
