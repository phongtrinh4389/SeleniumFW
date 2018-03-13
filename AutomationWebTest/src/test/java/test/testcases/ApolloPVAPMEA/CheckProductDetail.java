package test.testcases.ApolloPVAPMEA;

import org.testng.annotations.Test;

import test.common.WebTestSetup;
import test.page.objects.PVDetailsPage;
import test.page.objects.PVFindPlacePage;
import test.page.objects.PVPage;
import test.page.objects.PVTyresPage;

public class CheckProductDetail extends WebTestSetup {
	private String TestCaseName = "TC_2";
	private String excelTestcaseSheetName = "PVBrowseAllTyres";

	private String addressInput = "Mumbai, Maharashtra";
	private String usernameFb = "lethientai.145858292@gmail.com";
	private String passFb = "Tailt01319";
	
	public CheckProductDetail() {
		strTestCaseName = TestCaseName;
		testCaseSheetName = excelTestcaseSheetName;
	}

	@Test(description = "Open Product Detail page", priority = 1)
	public void OpenProdDetailPage() throws Exception {
		PVPage pvPage = new PVPage(driver);
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		// click to Browse all tyres
		pvPage.clickBrowseAllTyres();
		// view First Tyre detail page
		pvTyresPage.viewFirstTyreDetails();
		// verify breadcrumb text
		pvDetailsPage.verifyBreadcrumbDisplayed();
		// verify intro text
		pvDetailsPage.verifyIntroTextDisplayed();
		// verify image displayed
		pvDetailsPage.verifyImgDisplayed();
		// verify Camera icon
		pvDetailsPage.verifyCameraDisplayed();
		// verify Warranty
		pvDetailsPage.verifyWarrantyDisplayed();
		// verify Find place to buy
		pvDetailsPage.verifyFindPlaceLabelDisplayed();
		// verify Search box
		pvDetailsPage.verifySearchBox();
		// verify Location button
		pvDetailsPage.verifyLocationBtn();
		// verify Save and Share btn
		pvDetailsPage.verifySaveShareDisplayed();
		// verify feature tab
		pvDetailsPage.verifyFeatureTabDisplayed();
		// verify specification tab
		pvDetailsPage.verifySpecifyTabDisplayed();
		// verify waranty tab
		pvDetailsPage.verifyWarantyTabDisplayed();
	}
	

	@Test(description = "Check all the value in Product Detail page", priority = 2)
	public void CheckAllValueDetailPage() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyValueOfRimSize();
	}
	
	@Test(description = "Check product image", priority = 3)
	public void CheckProdImage() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyProductImg();
	}
	
	@Test(description = "Check FAB image", priority = 4)
	public void CheckFABImage() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyFABImg();
	}
	
	@Test(description = "Check product tag line, product text, product benefits, product features", priority = 5)
	public void CheckProdTagTextBenefitsFeatures() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyProdTagTextBenefitsFeatures();
	}
	
	@Test(description = "verify \"RTB Disclaimer APMEA\"", priority = 6)
	public void VerifyRTBDisclaimerAPMEA() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyRTBDisclaimerTxt();
	}
	
	@Test(description = "Check Rim size dropdown", priority = 7)
	public void CheckRimSizeDDL() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyCheckRimSizeDDL();
	}
	
	@Test(description = "Wide open RIM size dropdown", priority = 8)
	public void OpenRimSizeDDL() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		// missing open???
		pvDetailsPage.verifyRimSizeDDLOpen();
	}
	
	@Test(description = "Select another RIM size on dropdown list ", priority = 9)
	public void VerifyMatchTyreSize() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyMatchTyreSize();
	}
	
	@Test(description = "Check 'Find a place to buy' ", priority = 10)
	public void OpenFindStorePage() throws Exception {
		PVFindPlacePage pvFind = new PVFindPlacePage(driver);
		pvFind.verifyAddInSearchBox(addressInput);
		pvFind.verifyNoOfListDealer();
		pvFind.verifyDistanceOfList();
	}
	
	@Test(description = "Share via Facebook ", priority = 11)
	public void loginFacebookPopAndShare() throws Exception {
		PVTyresPage pvTyresPage = new PVTyresPage(driver);
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvTyresPage.backToLastPage();
		pvDetailsPage.shareViaFacebook(usernameFb, passFb);
	}
	
	@Test(description = "Login facebook to verify data ", priority = 12)
	public void verifyOnFBAccount() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.verifyPostOnFacebook(usernameFb, passFb);
	}
	
	@Test(description = "Share via Twitter ", priority = 13)
	public void loginTwitterAndShare() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.shareViaTwitter(usernameFb, passFb);
	}
	
	@Test(description = "Share via Email ", priority = 14)
	public void inputEmailAndShare() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.shareViaEmail(usernameFb);
	}
	
	@Test(description = "Click X button to close share ", priority = 15)
	public void closeShareLink() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.showShareIcon();
	}
	
	@Test(description = "Drag through the end of the page ", priority = 16)
	public void dragToTheEnd() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.dragToTheEnd();
	}
	
	@Test(description = "Click on 'Back to top' button ", priority = 17)
	public void backToTop() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.backToTop();
	}
	
	@Test(description = "Click on 'Feature' button ", priority = 18)
	public void goToFeature() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.goToFeaturePart();
	}
	
	@Test(description = "Click on 'Specifycation' button ", priority = 19)
	public void goToSpec() throws Exception {
		PVDetailsPage pvDetailsPage = new PVDetailsPage(driver);
		pvDetailsPage.goToSpecPart();
	}
	
	/*@Test(description = "skip test ", priority = 11)
	public void skip() throws Exception {
		throw new SkipException("this test is na");
	}*/
}
