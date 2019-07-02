package reusableComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignIn extends BaseClass {

	public static By yourTripsBtn = By.linkText("Your trips");
	public static By signInLink = By.id("SignIn");
	public static By signIn_PopUp_title = By.linkText("Sign in to Cleartrip");
	public static By userName = By.id("email");
	public static By password = By.id("password");
	public static By signInButton = By.id("signInButton");
	public static By signIn_ErrorMessage = By.id("errors1");

	public void click_OnYourTrips() {
		driver.findElement(yourTripsBtn).click();
	}

	public void click_OnSignInLink() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signInLink));
		driver.findElement(signInLink).click();
	}

	public void signInButtonclick() {
		driver.switchTo().frame("modal_window");
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signInButton));
		driver.findElement(signInButton).click();

	}

	public String errorMessage() {
		Assert.assertTrue(driver.findElement(signIn_ErrorMessage).isDisplayed());
		return driver.findElement(signIn_ErrorMessage).getText();
	}

	public void framename(String framename) {
		driver.switchTo().frame(framename);
	}

}
