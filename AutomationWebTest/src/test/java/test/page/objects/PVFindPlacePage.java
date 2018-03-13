package test.page.objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.nashtech.core.web.WebDriverMethod;

public class PVFindPlacePage {
	private WebDriverMethod driverMethod;
	
	public PVFindPlacePage(WebDriverMethod driverMethod) {
		this.driverMethod = driverMethod;
	}
	
	private String InputSearch = "Search box display ";
	private String Total = "Total Dealer have ";
	private String DealerDistance = "Distance of dealer";
	
	// WebElement locator
	private By searchBox = By.xpath("//input[@itemprop='codeCountry']");
	private By listDealer = By.xpath("//div[contains(@class,'dealer_item') and not (contains(@class,'ng-hide'))]");
	private By totalDealer = By.xpath("//span[@id='dealer-record-found-id']");
	private By viewAll = By.xpath("//div[contains(@class,'viewall')]");
	private By apolloZone = By.xpath("//a[@ng-show='dealer.IsApolloZone()' and not (contains(@class,'ng-hide'))]");
	private By distanceList = By.xpath("//div[contains(@class,'dealer_item') and not (contains(@class,'ng-hide'))]//span[@itemprop='distance']");
	
	public void verifyAddInSearchBox(String address) throws Exception{
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driverMethod);
		pvDetailsPage.inputAddToFindPlace(address);
		driverMethod.waitForPresenceOfElementLocated(searchBox, 60);
		driverMethod.verifyContainText(InputSearch, searchBox, address);
	}
	
	public void verifyNoOfListDealer() throws Exception{
		int totaldealer = Integer.parseInt(driverMethod.getText(Total, totalDealer));
		int noListDealer = driverMethod.findElements(listDealer).size();
		if(totaldealer >= 6){
			driverMethod.verifyEqual(noListDealer, 6);
			driverMethod.isElementPresent(viewAll);
		} else{
			driverMethod.verifyEqual(noListDealer, totaldealer);
		}
		verifyNoOfApolloZone();
	}
	
	public boolean verifyNoOfApolloZone() throws Exception{
		int apolloSize = driverMethod.findElements(apolloZone).size();
		if(apolloSize > 2)
			return false;
		else 
			return true;
	}
	
	public void verifyDistanceOfList() throws Exception{
		int apolloSize = driverMethod.findElements(apolloZone).size();
		driverMethod.scrollIntoView(DealerDistance, distanceList);
		List<String> listDistance = driverMethod.getListText(DealerDistance, distanceList);
		List<Double> dblList = new ArrayList<Double>();
		for(String s : listDistance) {
			dblList.add(Double.valueOf(s.toString().replace(" Km", "")));
		}
		verifyDistanceLessThanDefault(dblList);
		if(apolloSize == 2){
			List<Double> newList = dblList.subList(2, dblList.size());
			driverMethod.verifyListIsAscendingOrder(newList);
		} else if(apolloSize == 1){
			List<Double> newList = dblList.subList(1, dblList.size());
			driverMethod.verifyListIsAscendingOrder(newList);
		} else
			driverMethod.verifyListIsAscendingOrder(dblList);
	}
	
	public boolean verifyDistanceLessThanDefault(List<Double> dblList){
		for(Double s : dblList) {
			if(s > 50){
				return false;
			}
		}
		return true;
	}
	
	
	
	
}
