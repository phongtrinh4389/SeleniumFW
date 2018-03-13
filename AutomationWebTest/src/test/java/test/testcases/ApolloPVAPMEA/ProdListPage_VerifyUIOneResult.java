package test.testcases.ApolloPVAPMEA;

import org.testng.annotations.Test;

import test.common.WebTestSetup;
import test.page.objects.PVPage;

public class ProdListPage_VerifyUIOneResult extends WebTestSetup{

	private String TestCaseName = "TC_4";
	private String excelTestcaseSheetName = "PVFindSize";
	
	public ProdListPage_VerifyUIOneResult() {
		strTestCaseName = TestCaseName;
		testCaseSheetName = excelTestcaseSheetName;
	}
	
	private String width = "185";
	private String aspect = "60";
	private String rim = "14";
	
	@Test(description = "There is the first time to search", priority = 1)
	public void FirstTimeSearch() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.searchByTyreSize(width,aspect,rim);
		pvPage.verifyResultInHomePage();
	}
	
	@Test(description = "By clicking on the “Find Tyres” icon in the navigation when the user is not in the homepage", priority = 2)
	public void FindTyreSearchNotHomePage() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.searchAgain();
		pvPage.clickBrowseAllTyresByTyreSize();
		pvPage.clickFindTyreMenuAndSearch();
		pvPage.verifyResultInAnotherPage();
	}
	
	
}
