package reusableComponents;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlightBookingPage extends BaseClass {

	public static By RadioBox_OneWayTrip = By.id("OneWay");
	public static By FromLocation = By.id("FromTag");
	public static By ToLocation = By.id("ToTag");
	public static By DepartDate = By.id("DepartDate");
	public static By SearchBtn = By.id("SearchBtn");
	public static By NextBtn = By.xpath("//*[@class='nextMonth ']");
	public static By Elementsearch = By.xpath("//*[@class='searchSummary']");

	public static List<WebElement> AllFromlocation;
	public static List<WebElement> AllTOlocation;

	public void select_OneWayJourney() {

		if (!driver.findElement(RadioBox_OneWayTrip).isSelected())
			driver.findElement(RadioBox_OneWayTrip).click();
	}

	public void fromLocationSelected(String FromLocationName) throws InterruptedException {
		driver.findElement(FromLocation).sendKeys(FromLocationName);
		waitFor(3000);
		getFromLocation(FromLocationName);
	}

	public void getFromLocation(String location) throws InterruptedException {

		// Must be given the value when user actually clicked into the field
		AllFromlocation = driver.findElements(By.xpath("Sign in to Cleartrip"));

		System.out.println(AllFromlocation);
		for (int i = 0; i < AllFromlocation.size(); i++) {
			WebElement element = AllFromlocation.get(i);
			if (element.getText().contains(location)) {
				System.out.println(element.getText());
				// Fix Xpath
				driver.findElement(By.xpath("(//*[@id='ui-id-1']//li[@class='list'][\" + i + \"]/a)")).click();
				break;
			}
		}
	}

	public void toLocationSelected(String ToLocationName) throws InterruptedException {
		driver.findElement(ToLocation).sendKeys(ToLocationName);
		waitFor(3000);
		getToLocation(ToLocationName);
	}

	public void getToLocation(String location) throws InterruptedException {

		// Must be given the value when user actually clicked into the field
		AllTOlocation = driver.findElements(By.xpath("//*[@id='ui-id-2']/child::li"));

		for (int i = 0; i < AllTOlocation.size(); i++) {
			WebElement element = AllTOlocation.get(i);
			if (element.getText().contains(location)) {
				driver.findElement(By.xpath("(//*[@id='ui-id-2']//li[@class='list'][\" + i + \"]/a)")).click();
				break;
			}
		}
	}

	public void searchBtnClick() {
		driver.findElement(SearchBtn).click();
	}

	public boolean isElementPresent() {
		try {
			driver.findElement(Elementsearch).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void date_Selection(String date) throws InterruptedException {
		driver.findElement(DepartDate).sendKeys(date);

	}

}
