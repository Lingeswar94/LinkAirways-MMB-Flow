package MMBChangeFlight;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import MMBChangeFlightPage.ChangeFlightAddonPage;
import UltityFunction.Commonfunction;
import UltityFunction.Constant;

public class ChangeFlightAddonSelection extends Commonfunction {
	Logger logger = Logger.getLogger(ChangeFlightAddonSelection.class);

	@Test
	public void AddonSelection() {

		try {
			logger.info("User is to selected Addon  for change flight flow ");
			ChangeFlightAddonPage.getChangeFlightAddonPage().Addoncontinuebutton();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			ChangeFlightAddonPage.getChangeFlightAddonPage().AddonselectAlert(Constant.isAlertAddon);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
