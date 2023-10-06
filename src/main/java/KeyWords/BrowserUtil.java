package KeyWords;

import java.rmi.Remote;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Util.PropUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil extends PropUtil {
	public static RemoteWebDriver driver;
	PropUtil pro = new PropUtil();

	public static void BrowserOpen(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			System.out.println(BrowserName + "Browser Launched Sucessfully");
		} else if (BrowserName.equalsIgnoreCase("Edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option);
			driver.manage().window().maximize();
			System.out.println(BrowserName + "Browser Launched Sucessfully");
		} else if (BrowserName.equalsIgnoreCase("FireFox")) {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);
			driver.manage().window().maximize();
			System.out.println(BrowserName + "Browser Launched Sucessfully");
		} else {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Default Browser Launched Sucessfully ");
		}
	}

	public static void BrowserClose() {
		driver.quit();
	}

	public static void getURL(String BrowserName) {
		driver.get(BrowserName);
	}

	@BeforeMethod
	public void BrowserLaunch() {
		BrowserUtil.BrowserOpen(pro.getObjectFromRepo("BrowserName"));
		BrowserUtil.getURL(pro.getObjectFromRepo("IndianRailwayEnquiry"));
	}

	@AfterMethod
	public void BrowserTearDown() {
		BrowserUtil.BrowserClose();
	}
}