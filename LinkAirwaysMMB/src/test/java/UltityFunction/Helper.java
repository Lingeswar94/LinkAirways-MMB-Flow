package UltityFunction;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.support.PageFactory;


import MMBChangeFlightPage.ChangeFlightAddonPage;
import MMBChangeFlightPage.ChangeFlightEndTxPage;
import MMBChangeFlightPage.ChangeFlightItinearyPage;
import MMBChangeFlightPage.DateSelectionPage;
import MMBChangeFlightPage.FlightSelectionPage;
import MMBLogin.LoginPage;

public class Helper {

	public static void Initelement() {

		PageFactory.initElements(Commonfunction.getDriver(), LoginPage.getmmbLoginPage());
		PageFactory.initElements(Commonfunction.getDriver(), DateSelectionPage.getDateSelectionPage());
		PageFactory.initElements(Commonfunction.getDriver(), FlightSelectionPage.getFlightSelectionPage());
		PageFactory.initElements(Commonfunction.getDriver(), ChangeFlightAddonPage.getChangeFlightAddonPage());
		PageFactory.initElements(Commonfunction.getDriver(), ChangeFlightItinearyPage.getChangeFlightItinearyPage());
		PageFactory.initElements(Commonfunction.getDriver(), ChangeFlightEndTxPage.getChangeFlightEndTxPage());

	}

	public static String getcurrentdate() {

		DateFormat dateFormat = new SimpleDateFormat("_MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		String Currentdate = dateFormat.format(date);
		return Currentdate;

	}

	public static String getScreenShot() {
	    String filePath = System.getProperty("user.dir") + "/src/test/resources/Screenshot/Changeflight_" 
	                      + getcurrentdate() + ".png";
	    File directory = new File(filePath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getMessage());
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = filePath;
		File file = new File(filePath);

		try {
			ImageIO.write(bufferedImage, "png", file);
			System.out.println("Fail Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshot;
	}

}
