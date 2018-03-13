package test.testcases.ApolloPVAPMEA;

import org.testng.annotations.Test;

import test.common.WebTestSetup;
import test.page.objects.PVPage;

public class CheckTyreFinderPage extends WebTestSetup{

	private String TestCaseName = "TC_3";
	private String excelTestcaseSheetName = "PVFindSize";
	private String widthValue = "195";
	private String widthValueToChange = "215";
	private String aspectRValue = "60";
	private String aspectRValueToChange = "70";
	private String rimValue = "15";
	private String rimValueToChange = "16";
	
	public CheckTyreFinderPage() {
		strTestCaseName = TestCaseName;
		testCaseSheetName = excelTestcaseSheetName;
	}
	
	@Test(description = "Click on 'Tyre Size' button", priority = 1)
	public void ClickOnTyreSizeButton() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.clickByTyreSize();
		pvPage.verifyTyreSizeDesign();
	}

	@Test(description = "Click on link 'Where can I find my Tyresize'", priority = 2)
	public void ClickOnQuesFindTyreSize() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.clickQuesTyreSize();
		pvPage.verifyPopUpDisplay();
	}
	
	@Test(description = "Click [Close] or [x] button to close popup", priority = 3)
	public void ClosePopUpQuestion() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.closePopUpDisplay();
	}
	
	@Test(description = "Select value in DDL and Reset", priority = 4)
	public void CheckResetFunction() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.selectValueInDDL(widthValue,aspectRValue,rimValue);
		pvPage.clickResetBtn();
		pvPage.verifyValueDefaultInDDL();
	}
	
	@Test(description = "Check value in Width dropdown", priority = 5)
	public void CheckValueWidthInDB() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyWidthValueInDDL();
	}
	
	@Test(description = "Check value in AspectR dropdown", priority = 6)
	public void CheckValueAspectInDB() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyAspectValueInDDL();
	}
	
	@Test(description = "Check value in Width dropdown", priority = 7)
	public void CheckValueRimInDB() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyRimValueInDDL();
	}
	
	@Test(description = "Change value of remaining dropdown by just selected dropdown ", priority = 8)
	public void CheckValueOfAspecRimRemaining() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyValueChangeBySelectDDL(widthValueToChange);
	}
	
	@Test(description = " Select a value in 'Aspect Ratio' dropdown", priority = 9)
	public void CheckValueOfRimRemaining() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyRimValueChangeBySelectDDL(aspectRValueToChange);
	}
	
	@Test(description = " Check enble/disable button [Find my tyre]", priority = 10)
	public void CheckEnableDisableBtn() throws Exception {
		PVPage pvPage = new PVPage(driver);
		pvPage.verifyEnableBtnWhenDataIsFill(rimValueToChange);
	}
}
