package codingRound;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import reusableComponents.BaseClass;
import reusableComponents.FlightBookingPage;

public class FlightBookingTest extends BaseClass {

	FlightBookingPage flightBookingPage;

	@BeforeMethod
	public void setupHomePage() {
		Browserlaunch();
		Navigate_URL();

	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {

		flightBookingPage = new FlightBookingPage();

		flightBookingPage.fromLocationSelected("Bangalore");

		flightBookingPage.toLocationSelected("Delhi");
		waitFor(7000);

		//This can be done by using loops and select the date but due to time constraint, using sendkys
		flightBookingPage.date_Selection("Tue, 30 Jul, 2019");
		waitFor(3000);

		// click on search
		flightBookingPage.searchBtnClick();

		// verify that result appears for the provided journey search
		Assert.assertTrue(flightBookingPage.isElementPresent());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
