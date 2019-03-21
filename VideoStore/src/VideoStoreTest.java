import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class VideoStoreTest {

	private Statement statement;
	final double DELTA = .001;

	@Before
	public void setUp() {
		statement = new Statement("Customer");
	}

	@Test
	public void testSingleNewReleaseStatementTotals() {
		statement.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
		statement.generate();
		assertEquals(9.0, statement.getTotal(), DELTA);
		assertEquals(2, statement.getFrequenetRenterPoint());
	}

	@Test
	public void testDualNewReleaseStatementTotals() {
		statement.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
		statement.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));
		statement.generate();
		assertEquals(18.0, statement.getTotal(), DELTA);
		assertEquals(4, statement.getFrequenetRenterPoint());
	}

	@Test
	public void testSingleChildrensStatementTotals() {
		statement.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), 3));
		statement.generate();
		assertEquals(1.5, statement.getTotal(), DELTA);
		assertEquals(1, statement.getFrequenetRenterPoint());
	}

	@Test
	public void testMultipleRegularStatementTotals() {
		statement.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
		statement.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
		statement.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));
		statement.generate();
		assertEquals(7.5, statement.getTotal(), DELTA);
		assertEquals(3, statement.getFrequenetRenterPoint());
	}

	@Test
	public void testMultipleRegularStatementFormat() {
		statement.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
		statement.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
		statement.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

		assertEquals(
				"Rental Record for Customer\n" + "\tPlan 9 from Outer Space\t2.0\n"
						+ "\t8 1/2\t2.0\n\tEraserhead\t3.5\n" + "You owed 7.5\nYou earned 3 frequent renter points\n",
				statement.generate());
	}

}