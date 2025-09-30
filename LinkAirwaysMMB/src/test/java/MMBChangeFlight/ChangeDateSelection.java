package MMBChangeFlight;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import MMBChangeFlightPage.DateSelectionPage;

import UltityFunction.Commonfunction;
import UltityFunction.Constant;

public class ChangeDateSelection extends Commonfunction {

	
	Logger logger=Logger.getLogger(ChangeDateSelection.class);
	
	@Test
	public void Changedatemethod() {

		try {
			logger.info("User is to selected Change date for MMB Change flight flow ");
		DateSelectionPage.getDateSelectionPage().getsegmentselection(Constant.Trip, Constant.OBSegmentMonth,
				Constant.OBSegmentDate, Constant.OBSegmentYear, Constant.IBSegmentMonth, Constant.IBSegmentDate,
				Constant.IBSegmentYear);
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		try {
			DateSelectionPage.getDateSelectionPage().btnContinue();
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Flight(s) do not operate on the date you have searched.");
		}

	}
}
