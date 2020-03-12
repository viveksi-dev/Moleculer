package molecular;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Configuration;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class HelloWorld {
	
	public static WebDriver driver;
	public static Properties prop;
	
	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void setupSuite(String browser) throws IOException {

		// launching firefox browser
		/*
		 * DesiredCapabilities dc = new DesiredCapabilities();
		 * dc.setBrowserName("firefox"); dc.setPlatform(Platform.WINDOWS); WebDriver
		 * driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		 */
		// this.browser = browser;
		try {
			System.out.println("Browser:" + browser);
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"D:/Firefox driver/geckodriver-v0.24.0-win64/geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("Calling firefox driver");
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:/Chrome driver/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("Calling chrome driver");
			}

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("launching browser");

		// loading data from properties file
		FileInputStream fis = new FileInputStream(
				"D:/viveksi/B2B_Automation/eclipse-workspace/Demo_Moleculer_Hello_World/configuration.properties");
		prop = new Properties();
		prop.load(fis);

		// opening B2B website
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		System.out.println("Successfully open Moleculer homepage");
	}

	// Closing the browser sessions

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		System.out.println("Closing all the open sessions");
		/* driver.quit(); */
	}

	@BeforeTest
	public void startReport() {
		

	
	// in @beforeMethod --> @Test1 --> in afterMethod -->in
	// beforeMethod-->@Test2-->in afterMethod
}
	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "moleculer-demo - Moleculer Microservices Project";
		String actualTitle = driver.getTitle();
		System.out.println("Title is:" + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Successfully user is on the Molecular MicroServices Project ");
	}
}
