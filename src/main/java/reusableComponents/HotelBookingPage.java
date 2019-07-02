package reusableComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelBookingPage extends BaseClass {

	public static By hotelLink = By.linkText("Hotels");
	public static By localityTextBox = By.id("Tags");
	public static By searchButton = By.id("SearchHotelsButton");
	public static By travellerSelection = By.id("travellersOnhome");
	public static By checInDate = By.id("CheckInDate");
	public static By checOutDate = By.id("CheckOutDate");

	public static List<WebElement> Alllocations;

	public void click_HotelLink() {
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(driver.findElement(hotelLink))).click();
	}

	public void select_Locality(String HotelLocationName) throws InterruptedException {

		driver.findElement(localityTextBox).clear();
		driver.findElement(localityTextBox).sendKeys(HotelLocationName);
		waitFor(3000);
		locationlistSelected(HotelLocationName);

	}

	public void locationlistSelected(String HotelLocationName) throws InterruptedException {
		Alllocations = driver.findElements(By.xpath("//*[@id='ui-id-1']/child::li"));

		for (int i = 1; i < Alllocations.size(); i++) {
			WebElement element = Alllocations.get(i);
			if (element.getText().contains(HotelLocationName)) {
				driver.findElement(By.xpath("(//*[@id='ui-id-1']//li[@class='list'][\" + i + \"]/a)")).click();
				break;
			}
		}
	}

	public void select_traveller(String travelselectionName) {
		new Select(driver.findElement(travellerSelection)).selectByVisibleText(travelselectionName);
		waitFor(4000);
		driver.findElement(searchButton).click();
	}

	public void click_SearchBtn() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(searchButton));
		driver.findElement(searchButton).click();
	}
}
