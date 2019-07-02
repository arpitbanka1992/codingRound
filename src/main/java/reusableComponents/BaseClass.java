package reusableComponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class BaseClass {

	public static WebDriver driver;

	public static String RootPath = System.getProperty("user.dir");
	public static String URL = "https://www.cleartrip.com/";

	// Wait for a certain period
	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Launch the related browser
	public static void Browserlaunch() {

		setDriverPath();
		// Disable the Chrome notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// navigate to URL
	public static void Navigate_URL() {

		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	// set the driver path as per OS
	public static void setDriverPath() {

		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", RootPath + "\\Utils\\chromedriver.exe");
		} else if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", RootPath + "\\Utils\\chromedriver.exe");
		} else if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", RootPath + "\\Utils\\chromedriver.exe");
		} else {
			System.out.println("Current OS not supported");
		}

	}

}
