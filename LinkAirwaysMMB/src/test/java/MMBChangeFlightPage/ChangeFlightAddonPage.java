package MMBChangeFlightPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UltityFunction.Commonfunction;

public class ChangeFlightAddonPage {

	private static ChangeFlightAddonPage changeFlightAddonPage;

	private ChangeFlightAddonPage() {

	}

	public static ChangeFlightAddonPage getChangeFlightAddonPage() {
		if (changeFlightAddonPage == null) {
			changeFlightAddonPage = new ChangeFlightAddonPage();
		}
		return changeFlightAddonPage;
	}

	@FindBy(xpath = "//input[@id='btnProceedBooking']")
	private WebElement Addoncontinue;
	//*[@id="baggagemsgModel"]/div/div
	@FindBy(xpath = "//div[@class='modal-footer']/ul/li")
	private List<WebElement> Addonalert;
	
	@FindBy(xpath="//div[@class='modal-footer']")
	private WebElement Addonalertshow;

	@FindBy(xpath = "//button[@onclick='ProceedTopaymentWithoutFreeBaggage(false)']")
	private WebElement Addonfalse;

	@FindBy(xpath = "//button[@onclick='DontProceed(true)']")
	private WebElement Addontrue;

	public void Addoncontinuebutton() {

		WebDriverWait wait = new WebDriverWait(Commonfunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Addoncontinue));
		Addoncontinue.click();
	}

	public void AddonselectAlert(boolean alert) {

		
		WebDriverWait wait=new WebDriverWait(Commonfunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Addonalertshow));
		if(Addonalertshow.isDisplayed()) {
			if(!alert) {
				Addonfalse.click();
			}else {
				Addontrue.click();
			}
		}
	}
				
}
