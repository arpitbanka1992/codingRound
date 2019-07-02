package codingRound;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import reusableComponents.BaseClass;
import reusableComponents.SignIn;

public class SignInTest extends BaseClass {

	SignIn signInPage;

	@BeforeMethod
	public void setupHomePage() {
		Browserlaunch();
		Navigate_URL();

	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {

		signInPage = new SignIn();

		signInPage.click_OnYourTrips();

		signInPage.click_OnSignInLink();

		signInPage.signInButtonclick();

		System.out.println(signInPage.errorMessage());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/*
	 * WebDriver driver = new ChromeDriver();
	 * 
	 * @Test public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
	 * 
	 * setDriverPath();
	 * 
	 * driver.get("https://www.cleartrip.com/"); waitFor(2000);
	 * 
	 * driver.findElement(By.linkText("Your trips")).click();
	 * driver.findElement(By.id("SignIn")).click();
	 * 
	 * driver.findElement(By.id("signInButton")).click();
	 * 
	 * String errors1 = driver.findElement(By.id("errors1")).getText();
	 * Assert.assertTrue(errors1.contains("There were errors in your submission"));
	 * driver.quit(); }
	 * 
	 * private void waitFor(int durationInMilliSeconds) { try {
	 * Thread.sleep(durationInMilliSeconds); } catch (InterruptedException e) {
	 * e.printStackTrace(); //To change body of catch statement use File | Settings
	 * | File Templates. } }
	 * 
	 * private void setDriverPath() { if (PlatformUtil.isMac()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver"); } if
	 * (PlatformUtil.isWindows()) { System.setProperty("webdriver.chrome.driver",
	 * "chromedriver.exe"); } if (PlatformUtil.isLinux()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver_linux"); } }
	 */

}
