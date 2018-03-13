package test.testcases.ApolloPVAPMEA;

import org.testng.annotations.Test;

import test.common.WebTestSetup;
import test.page.objects.PVPage;

public class ProdListPage_VerifyUIMoreOneResult extends WebTestSetup {
	private String TestCaseName = "TC_6";
	private String excelTestcaseSheetName = "PVFindSize";

	public ProdListPage_VerifyUIMoreOneResult() {
		strTestCaseName = TestCaseName;
		testCaseSheetName = excelTestcaseSheetName;
	}
	
	private String width = "185";
	private String aspect = "70";
	private String rim = "14";
	private String breadcrumb = "Home Cars, Suvs & Vans Tyre Results ("+width+"/"+aspect+" R"+rim+")";
	
	@Test(description = "Choose search by tyre size and then choose value in ddl", priority = 1)
	public void VerifyListProdUI() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.searchByTyreSize(width,aspect,rim);
		pvPage.verifyManuResultInHomePage(breadcrumb);
	}
	
	@Test(description = "Check UI for one product", priority = 2)
	public void VerifyUIOneProd() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyUIOneProd();
	}
	
	@Test(description = "Hover on values of product", priority = 3)
	public void HoverOnValue() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyHoverOnValue();
	}
	
	@Test(description = "Hover on product image", priority = 4)
	public void HoverOnImage() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyHoverOnImage();
	}
}
