package test.page.objects;

import org.openqa.selenium.By;

import com.nashtech.core.web.WebDriverMethod;

public class BasePage {
	private WebDriverMethod driver;

	// WebElement locators
	private By carSuvVanPage = By
			.xpath("//div[@id='navbar-collapse-1']/ul/li/a[contains(@href,'car-suv-van')]/img");
	private By motorPage = By
			.xpath("//div[@id='navbar-collapse-1']//a[contains(@href,'motorbike')]");
	private By truckPage = By
			.xpath("//div[@id='navbar-collapse-1']//a[contains(@href,'cv')]");
	private By agriPage = By
			.xpath("//div[@id='navbar-collapse-1']//a[contains(@href,'agri')]");
	private By industriPage = By
			.xpath("//div[@id='navbar-collapse-1']//a[contains(@href,'industri')]");
	private By earthmovPage = By
			.xpath("//div[@id='navbar-collapse-1']//a[contains(@href,'earth')]");

	public BasePage(WebDriverMethod driverMethod) {
		this.driver = driverMethod;
	}

	public void gotoCarSuvVanPage() throws Exception {
		driver.click("Cars, Suvs & Vans", carSuvVanPage);
	}

	public void gotoMotorPage() throws Exception {
		driver.click("Motorbike", motorPage);
	}

	public void gotoTruckPage() throws Exception {
		driver.click("Trucks and Buses", truckPage);
	}

	public void gotoAgriPage() throws Exception {
		driver.click("Agricultural", agriPage);
	}

	public void gotoIndustryPage() throws Exception {
		driver.click("Industrial", industriPage);
	}

	public void gotoEarthmovPage() throws Exception {
		driver.click("Earthmover", earthmovPage);
	}
}
