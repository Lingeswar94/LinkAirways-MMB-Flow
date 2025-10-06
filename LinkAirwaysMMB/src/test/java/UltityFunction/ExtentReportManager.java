package UltityFunction;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends Commonfunction implements ITestListener {

	ExtentSparkReporter extentSparkReporter;
	ExtentReports reports;
	ExtentTest extentTest;
	// Properties properties;

	Logger logger = Logger.getLogger(ExtentReportManager.class);

	@Override
	public void onStart(ITestContext context) {
		String reportPath = System.getProperty("user.dir") + "./src/test/resources/Report/MMBFlow_"
				+ Helper.getcurrentdate() + ".html";
		extentSparkReporter = new ExtentSparkReporter(reportPath);

		extentSparkReporter.config().setDocumentTitle("Automation LinkAirways MMB Flow Report");
		extentSparkReporter.config().setReportName("Link Airways MMB Flows");
		extentSparkReporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(extentSparkReporter);

		// Load properties (make sure you load it from config file)
		// properties = new Properties();
		reports.setSystemInfo("QA Automation", "Link Airways Project");
		reports.setSystemInfo("Application URL", properties.getProperty("Url"));
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = reports.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, result.getMethod().getMethodName() + " started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getMethod().getMethodName() + " executed successfully");
		// extentTest.log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenShot()).build());

		/*
		 * if (result.getStatus() == ITestResult.SUCCESS) { TakesScreenshot ts =
		 * (TakesScreenshot) driver; String screen =
		 * ts.getScreenshotAs(OutputType.BASE64); extentTest.log(Status.PASS,
		 * MediaEntityBuilder.createScreenCaptureFromBase64String(screen).build());
		 * 
		 * }
		 */
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			extentTest = reports.createTest(result.getMethod().getMethodName());

			if (result.getStatus() == ITestResult.FAILURE) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				String failerpic = ts.getScreenshotAs(OutputType.BASE64);
				extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(failerpic).build());
			}
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Screenshot capture failed");
			logger.error(e.getMessage());
		}
		extentTest.log(Status.FAIL, result.getMethod().getMethodName() + " execution failed");
		extentTest.log(Status.FAIL, result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getMethod().getMethodName() + " was skipped");
		extentTest.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished project execution");
		reports.flush();
	}
}
