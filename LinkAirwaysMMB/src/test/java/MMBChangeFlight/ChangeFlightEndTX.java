package MMBChangeFlight;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import MMBChangeFlightPage.ChangeFlightEndTxPage;
import UltityFunction.Commonfunction;
import UltityFunction.ExcelData;

public class ChangeFlightEndTX extends Commonfunction {
	Logger logger = Logger.getLogger(ChangeFlightEndTX.class);
	ExcelData excelData = new ExcelData();

	@Test
	public void getpaymentmethod() {

		try {
			logger.info("User is to pay to exchange fare for change flight flow in END Transaction  ");
			ChangeFlightEndTxPage.getChangeFlightEndTxPage().Selectpayment();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			String da = excelData.getStringBiilingdata("Payment", 2, 1);
			//System.out.println(da);
			ChangeFlightEndTxPage.getChangeFlightEndTxPage().Carddetails(
					excelData.getStringBiilingdata("Payment", 2, 1), excelData.getStringBiilingdata("Payment", 3, 1),
					excelData.getStringBiilingdata("Payment", 4, 1));
			ChangeFlightEndTxPage.getChangeFlightEndTxPage().selectexpirymonth(
					excelData.getStringBiilingdata("Payment", 5, 1), excelData.getStringBiilingdata("Payment", 6, 1));
			logger.info("User is given Credit card details for exchange fare ");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {

			ChangeFlightEndTxPage.getChangeFlightEndTxPage().Billingdataclear();
			ChangeFlightEndTxPage.getChangeFlightEndTxPage().Billingdetails(
					excelData.getStringBiilingdata("Payment", 10, 1), excelData.getStringBiilingdata("Payment", 11, 1),
					excelData.getStringBiilingdata("Payment", 12, 1), excelData.getStringBiilingdata("Payment", 13, 1),
					excelData.getStringBiilingdata("Payment", 14, 1), excelData.getStringBiilingdata("Payment", 15, 1),
					excelData.getStringBiilingdata("Payment", 16, 1));
			logger.info("User has completed Billing details ");
			ChangeFlightEndTxPage.getChangeFlightEndTxPage().paymentcontinue();
			logger.info("Application moved to Payment is Processing");
			String success = ChangeFlightEndTxPage.getChangeFlightEndTxPage().Successmessage.getText();
			logger.info(success);
		} catch (Exception e) {
			 logger.error(e.getMessage());
		}
	}
}
