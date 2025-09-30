package UltityFunction;

import org.openqa.selenium.support.PageFactory;

import MMBChangeFlight.ChangeFlightItinerary;
import MMBChangeFlightPage.ChangeFlightAddonPage;
import MMBChangeFlightPage.ChangeFlightEndTxPage;
import MMBChangeFlightPage.ChangeFlightItinearyPage;
import MMBChangeFlightPage.DateSelectionPage;
import MMBChangeFlightPage.FlightSelectionPage;
import MMBLogin.LoginPage;

public class Helper {

	
	
	
	
	public static void Initelement() {
		
		PageFactory.initElements(Commonfunction.getDriver(), LoginPage.getmmbLoginPage());
		PageFactory.initElements(Commonfunction.getDriver(),DateSelectionPage.getDateSelectionPage());
		PageFactory.initElements(Commonfunction.getDriver(), FlightSelectionPage.getFlightSelectionPage());
		PageFactory.initElements(Commonfunction.getDriver(), ChangeFlightAddonPage.getChangeFlightAddonPage());
		PageFactory.initElements(Commonfunction.getDriver(),ChangeFlightItinearyPage.getChangeFlightItinearyPage());
		PageFactory.initElements(Commonfunction.getDriver(), ChangeFlightEndTxPage.getChangeFlightEndTxPage());
		
	}
	
	
	
}
