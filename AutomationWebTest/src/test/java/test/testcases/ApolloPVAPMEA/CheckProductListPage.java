package test.testcases.ApolloPVAPMEA;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import test.common.WebTestSetup;
import test.page.objects.PVDetailsPage;
import test.page.objects.PVPage;
import test.page.objects.PVTyresPage;

public class CheckProductListPage extends WebTestSetup {

	private String TestCaseName = "TC_1";
	private String excelTestcaseSheetName = "PVBrowseAllTyres";
	List<String> terrainText = Arrays.asList("On Road", "Off Road", "Mixed");

	public CheckProductListPage() {
		strTestCaseName = TestCaseName;
		testCaseSheetName = excelTestcaseSheetName;
	}
	
	@Test(description = "Open PV Page", priority = 1)
	public void OpenPVPage() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.mouseHoverOnIcon();
		pvPage.verifyTooltipText();
		pvPage.verifyTyreFinderDisplayed();
	}

	@Test(description = "Click on 'Browse all tyres' link", priority = 2)
	public void ClickPVBrowseAll() throws Exception {
		PVPage pvPage = new PVPage(driver);
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		pvPage.clickBrowseAllTyres();
		pvTyresPage.verifyBreadcumbDisplayed();
		// check label int
		pvTyresPage.verifyLabelTxtDisplayed();
		// get the text in options (missing verify?)
		pvTyresPage.getTextVehOpts();
		// verify block Product displayed, check in one block of product
		pvTyresPage.verifyBlockOfFirstProd();
	}
	
	@Test(description = "Verify number of products and Product Name", priority = 3)
	public void VerifyNumberAndName() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		pvTyresPage.verifyNoOfProd();
		pvTyresPage.verifyNameOfFirstProd();
	}
	
	@Test(description = "Check number of option available", priority = 4)
	public void CheckNumberOptAvlb() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		pvTyresPage.verifyNoOfOptAvlb();
	}

	@Test(description = "Verify [maximum tyre size- Minimum tyre size]", priority = 5)
	public void VerifyMinMaxSize() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		pvTyresPage.verifyMinMaxSizeFormat();
	}
	
	@Test(description = "Check product text", priority = 6)
	public void CheckProductText() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		pvTyresPage.verifyProdTxt();
	}
	
	@Test(description = "Click on 'View tyre detail' button", priority = 7)
	public void GotoDetailsPage() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		PVDetailsPage pvDetails = new PVDetailsPage(driver);
		pvTyresPage.viewFirstTyreDetails();
		pvDetails.verifyProdContentDisplayed();
		pvDetails.verifyProductImg();
	}

	@Test(description = "Filter by Car", priority = 8)
	public void FilterByCar() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// back to filter
		pvTyresPage.backToLastPage();
		// filter by Car
		pvTyresPage.filterByCar();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfCars());
	}

	@Test(description = "Filter by Suv", priority = 9)
	public void FilterBySuv() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// filter by Suv
		pvTyresPage.filterBySuv();
		pvTyresPage.verifyTerrainTextDisplay();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfSuvs());
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextTerrainOpts(),terrainText);
	}

	@Test(description = "Filter by On Road", priority = 10)
	public void FilterByOnRoad() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// filter by On Road
		pvTyresPage.filterByOnRoad();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfOnRoad());
	}

	@Test(description = "Filter by Off Road", priority = 11)
	public void FilterByOffRoad() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// filter by Off Road
		pvTyresPage.filterByOffRoad();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfOffRoad());
	}

	@Test(description = "Filter by Mixed", priority = 12)
	public void FilterByMixed() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// filter by Mixed
		pvTyresPage.filterByMixed();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfMixed());
	}

	@Test(description = "Filter by Popular", priority = 13)
	public void FilterByPopular() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// filter by Popular
		pvTyresPage.filterByPopular();
		// tap to remove filter by Mixed
		pvTyresPage.filterByMixed();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfPopular());
	}

	@Test(description = "Filter by Premium", priority = 14)
	public void FilterByPremium() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// filter by Premium
		pvTyresPage.filterByPremium();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfPremium());
	}

	@Test(description = "Filter by Luxury", priority = 15)
	public void FilterByLuxury() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		// filter by Luxury
		pvTyresPage.filterByLuxury();
		pvTyresPage.verifyResultDisplayed(pvTyresPage.getTextMasterName(),pvTyresPage.getListOfLuxury());
	}
}
