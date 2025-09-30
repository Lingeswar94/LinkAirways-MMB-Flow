package MMBLogin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UltityFunction.Commonfunction;

public class LoginPage {

	private static LoginPage mmbLoginPage;

	private LoginPage() {

	}

	public static LoginPage getmmbLoginPage() {
		if (mmbLoginPage == null) {
			mmbLoginPage = new LoginPage();
		}
		return mmbLoginPage;
	}

	@FindBy(xpath = "//input[@id='txtPNR']")
	private WebElement bookingPNR;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@id='txtLastName']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@id='btnRetreiveDetails']")
	private WebElement RetreiveDetails;

	@FindBy(xpath = "//div[@id='bodycontent_divAERBookingActions']/input")
	private List<WebElement> bookingActionmethod;

	public void BookingPNR(String PNR) {
		bookingPNR.sendKeys(PNR);
	}

	public void Firstname(String firstname) {
		FirstName.sendKeys(firstname);
	}

	public void Lastname(String lastname) {
		LastName.sendKeys(lastname);
	}

	public void RetreiveDetailscontinue() {
		RetreiveDetails.click();
	}

	public void BookingActions(String MMBMethod) {
		WebDriverWait wait=new WebDriverWait(Commonfunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(bookingActionmethod));
		
		try {
			int Size = bookingActionmethod.size();
			for (int i = 0; i < Size; i++) {
				String Managebooking = bookingActionmethod.get(i).getAttribute("value");
				String MMB[] = Managebooking.split(" ");

				if (MMB[0].equalsIgnoreCase(MMBMethod)) {
					bookingActionmethod.get(i).click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void paxcount() {
		
		
		
		
		
	}
}
