package MMBChangeFlight;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import MMBChangeFlightPage.ChangeFlightItinearyPage;
import UltityFunction.Commonfunction;

public class ChangeFlightItinerary extends Commonfunction {
	Logger logger = Logger.getLogger(ChangeFlightItinerary.class);

	@Test
	public void ChangeFlightPrice() {

		try {
			logger.info("User is to View flight fare Price and New Itinerary for change flight flow ");
			ChangeFlightItinearyPage.getChangeFlightItinearyPage().Itinearyrulebutton();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			ChangeFlightItinearyPage.getChangeFlightItinearyPage().ItinearyContinuebutton();
			Alert alert = Commonfunction.getDriver().switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
