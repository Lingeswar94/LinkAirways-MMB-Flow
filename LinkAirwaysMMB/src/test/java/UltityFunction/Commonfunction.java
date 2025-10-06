package UltityFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonfunction {

	public static Properties properties;
	public static WebDriver driver;
	public static ExcelData excelData;

	Logger logger= Logger.getLogger(Commonfunction.class);
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties loadbrowser() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/test/resources/Config/Config.properties");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return properties;
	}

	@BeforeSuite
	public void LanuchBrowser() {

		PropertyConfigurator.configure(Commonfunction.class.getClassLoader().getResource("./Config/Log4j.properties"));
		logger.info("LinkAirways MMB Flow are begins ");
		loadbrowser();
		String Browser = properties.getProperty("Browser");
		logger.info("Application is going to execute");
		String url = properties.getProperty("Url");
		if (Commonfunction.getDriver() == null) {
			if (Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Application has selected :" + Browser);
			} else if (Browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Application has selected :" + Browser);
			} else if (Browser.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				logger.info("Application has selected :" + Browser);
			} else {
				logger.info("Application hasn't selected browser ");
			}
			Helper.Initelement();
		}

		Commonfunction.getDriver().navigate().to(url);
		Commonfunction.getDriver().manage().window().maximize();
		Commonfunction.getDriver().manage().deleteAllCookies();
	}

	@AfterSuite
	public void quitbrowser() {

		 Commonfunction.getDriver().quit();
		logger.info("LinkAirways Automation MMB Flow booking was successfully executed ");
	}



}
