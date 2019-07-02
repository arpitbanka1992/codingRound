package codingRound;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import reusableComponents.BaseClass;
import reusableComponents.HotelBookingPage;

public class HotelBookingTest extends BaseClass {

	HotelBookingPage hotelPage;

	public static String Locality = "Indiranagar, Bangalore";

	public static String Rooms = "1 room, 2 adults";

	@BeforeMethod
	public void setupHomePage() {
		Browserlaunch();
		Navigate_URL();
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {
		hotelPage = new HotelBookingPage();
		
		hotelPage.click_HotelLink();

		hotelPage.select_Locality(Locality);

		hotelPage.select_traveller(Rooms);

		hotelPage.click_SearchBtn();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
