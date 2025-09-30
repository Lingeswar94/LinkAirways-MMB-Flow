package MMBChangeFlight;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import MMBChangeFlightPage.FlightSelectionPage;
import UltityFunction.Commonfunction;
import UltityFunction.Constant;

public class FlightSelection extends Commonfunction{

	Logger logger=Logger.getLogger(FlightSelection.class);
	
	@Test
	public void selectFarecabin() {

		
		WebDriverWait wait=new WebDriverWait(Commonfunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(FlightSelectionPage.getFlightSelectionPage().OBFlightFare));
		logger.info("User is to selected flight fare for change flight flow ");
		try {
			FlightSelectionPage.getFlightSelectionPage().Fareselecting(Constant.OBfare, Constant.IBfare);
		} catch (Exception e) {
			
			logger.error(e.getMessage());
		}

		try {
			FlightSelectionPage.getFlightSelectionPage().FlightContiune();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
