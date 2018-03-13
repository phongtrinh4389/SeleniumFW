package test.testcases.ApolloPVAPMEA;

import org.testng.annotations.Test;

import test.common.WebTestSetup;
import test.page.objects.PVPage;

public class ProdListPage_VerifyFuncProd extends WebTestSetup{

	private String TestCaseName = "TC_5";
	private String excelTestcaseSheetName = "PVFindSize";
	
	public ProdListPage_VerifyFuncProd() {
		strTestCaseName = TestCaseName;
		testCaseSheetName = excelTestcaseSheetName;
	}
	
	private String width = "185";
	private String aspect = "60";
	private String rim = "14";
	
	@Test(description = "Check name result search", priority = 1)
	public void VerifyNameOfProd() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.searchByTyreSize(width,aspect,rim);
		pvPage.verifyProdNameAfterSearch(width,aspect,rim);
	}
	
	@Test(description = "Image of product", priority = 2)
	public void VerifyImgOfProd() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyImgLinkAfterSearch();
	}
	
	@Test(description = "Value of comfort, braking and Lifespan,warranty  item", priority = 3)
	public void VerifyValueOfProd() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyValueAfterSearch(width,aspect,rim);
	}
	
	@Test(description = "Click to link [Search again]", priority = 4)
	public void ClickSearchAgain() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.searchAgain();
		pvPage.verifyTyreSizeAfterSearch(width,aspect,rim);
	}
	
	@Test(description = "Click to button [View Tyre Details]", priority = 5)
	public void ClickViewAgain() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.searchByFindTyre();
		pvPage.verifyResultInHomePage();
	}
}
