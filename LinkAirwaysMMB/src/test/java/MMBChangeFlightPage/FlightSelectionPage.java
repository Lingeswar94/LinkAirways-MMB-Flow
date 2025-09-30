package MMBChangeFlightPage;

import java.util.EmptyStackException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSelectionPage {

	private static FlightSelectionPage flightSelectionPage;

	private FlightSelectionPage() {

	}

	public static FlightSelectionPage getFlightSelectionPage() {

		if (flightSelectionPage == null) {
			flightSelectionPage = new FlightSelectionPage();
		}
		return flightSelectionPage;
	}

	// *[@id="divOBFlightResults"]/div/div[2]/ul/li[1]

	@FindBy(xpath = "//div[@id='divOBFlightResults']/div/div/ul/li")
	public List<WebElement> OBFlightFare;

	@FindBy(xpath = "//div[@id='divIBFlightResults']/div/div/ul/li")
	private List<WebElement> IBFlightFare;

	@FindBy(xpath = "//*[@id='btnContinue']")
	private WebElement flightcontinue;

	public void Fareselecting(String OBfare, String IBfare) {
		// Outbound flight selection
		Fareselect(OBFlightFare, OBfare);
		// If it's a return trip, select fare for inbound flight as well
		if (!IBFlightFare.isEmpty()) {
			Fareselect(IBFlightFare, IBfare);
		}
	}

	private void Fareselect(List<WebElement> flightResult, String flightfare) {
		int size = flightResult.size();
		boolean fareFound = false;
		
		for (int i = 0; i < size && !fareFound; i++) {
			WebElement fare = flightResult.get(i);
			String Farecabinselect = fare.getAttribute("class");
			String[] fareselected = Farecabinselect.split(" ");
			
			if (fareselected[0].equalsIgnoreCase(flightfare)) {
				fare.click();
				fareFound = true;
				return;
			}
		}
	}

	public void FlightContiune() {
		flightcontinue.click();
	}

}
