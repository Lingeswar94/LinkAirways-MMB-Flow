package MMBChangeFlightPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeFlightItinearyPage {

	private static ChangeFlightItinearyPage changeFlightItinearyPage;
	
	private ChangeFlightItinearyPage() {
		
	}

	public static ChangeFlightItinearyPage getChangeFlightItinearyPage() {
		if(changeFlightItinearyPage==null) {
			changeFlightItinearyPage=new ChangeFlightItinearyPage();
		}
		return changeFlightItinearyPage;
	}
	

	@FindBy(xpath="//input[@id='bodycontent_chkConfirm']")
	private WebElement Itinearyrule;
	
	@FindBy(xpath="//input[@id='bodycontent_btnConfirm']")
	private WebElement ItinearyContinue;
	
	
	public void Itinearyrulebutton() {
		Itinearyrule.click();
	}
	
	public void ItinearyContinuebutton() {
		ItinearyContinue.click();
	}
}
