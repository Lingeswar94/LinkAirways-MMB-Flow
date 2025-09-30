package MMBLogin;

import java.lang.invoke.ConstantBootstraps;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import UltityFunction.Commonfunction;
import UltityFunction.Constant;

public class MMBLoginTC extends Commonfunction {

	Logger logger=Logger.getLogger(MMBLoginTC.class);
	
	@Test
	public void ManageBookinglogin() {

		try {
			LoginPage.getmmbLoginPage().BookingPNR(Constant.BookingPNR);
			LoginPage.getmmbLoginPage().Firstname(Constant.Firstname);
			LoginPage.getmmbLoginPage().Lastname(Constant.Lastname);
			logger.info("Booking PNR is :"+Constant.BookingPNR +"__"+ "Firstname is :"+Constant.Firstname+"__ " +"Lastname is :"+Constant.Lastname);
			LoginPage.getmmbLoginPage().RetreiveDetailscontinue();
		} catch (Exception e) {
			logger.error(e.getMessage());
		
		}

		try {
			LoginPage.getmmbLoginPage().BookingActions(Constant.MMBMethod);
			logger.info("Selected MMB Flow is :"+Constant.MMBMethod);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
