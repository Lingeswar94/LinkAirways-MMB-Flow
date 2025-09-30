package MMBChangeFlightPage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import UltityFunction.Commonfunction;

public class ChangeFlightEndTxPage {
	WebDriverWait wait=new WebDriverWait(Commonfunction.getDriver(), Duration.ofSeconds(20));
	private static ChangeFlightEndTxPage changeFlightEndTxPage;

	private ChangeFlightEndTxPage() {

	}

	public static ChangeFlightEndTxPage getChangeFlightEndTxPage() {
		if (changeFlightEndTxPage == null) {
			changeFlightEndTxPage = new ChangeFlightEndTxPage();
		}
		return changeFlightEndTxPage;
	}

	@FindBy(xpath = "//label[@for='bodycontent_ucBookingPayment_rdolstPaymentMethods_0']")
	private WebElement paymentmethod;
	
	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucCardDetails_txtFName']")
	private WebElement Cardname;
	
	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucCardDetails_txtCardNumber']")
	private WebElement Cardnumber;
	
	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucCardDetails_txtCVVCode']")
	private WebElement CCV;
	
	@FindBy(xpath = "//select[@id='bodycontent_ucBookingPayment_ucCardDetails_ddlMonth']")
	private WebElement Expirymonth;
	
	@FindBy(xpath = "//select[@id='bodycontent_ucBookingPayment_ucCardDetails_ddlYear']")
	private WebElement Expiryyear;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtFName']")
	private WebElement BillingName;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtLName']")
	private WebElement billinglastname;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtAdd1']")
	private WebElement Address;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtCity']")
	private WebElement city;

	@FindBy(id = "bodycontent_ucBookingPayment_ucBillingDetails_ddlCountry")
	private WebElement country;
	
	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtPostCode']")
	private WebElement Postcode;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtMobileNo']")
	private WebElement Contact;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_btnMakePayment']")
	private WebElement MakePayment;

	@FindBy(xpath = "//span[@id='bodycontent_lblErrorMsgs']")
	public WebElement Successmessage;

	
	public void Selectpayment() {
		
		wait.until(ExpectedConditions.visibilityOf(paymentmethod));
		paymentmethod.click();
	}

	public void Carddetails(String CardName , String CardNumber,String ccv) {
		wait.until(ExpectedConditions.visibilityOf(Cardname));
		Cardname.sendKeys(CardName);
		Cardnumber.sendKeys(CardNumber);
		CCV.sendKeys(ccv);
	}

	public void selectexpirymonth(String month , String Year) {
		Select select=new Select(Expirymonth);
		select.selectByVisibleText(month);
		
		Select select2=new Select(Expiryyear);
		select2.selectByVisibleText(Year);
	}

	
	public void Billingdataclear() {
		BillingName.clear();
		billinglastname.clear();
	}
	
	public void Billingdetails(String Billingname, String billlastname, String Addressdetails, String citydetails,
			String Post, String contactno ,String selectedCountry) {

		BillingName.sendKeys(Billingname);
		billinglastname.sendKeys(billlastname);
		Address.sendKeys(Addressdetails);
		city.sendKeys(citydetails);
		Select select=new Select(country);
		select.selectByVisibleText(selectedCountry);
		Postcode.sendKeys(Post);
		Contact.sendKeys(contactno);
	}


	public void paymentcontinue() {
		MakePayment.click();
	}
	
	public void getsuccessmessage(String success) {
	 success =Successmessage.getText();
	}
}
