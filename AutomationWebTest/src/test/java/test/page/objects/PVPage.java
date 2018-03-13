package test.page.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import test.common.WebQueryConstant;

import com.nashtech.core.web.WebDriverMethod;
import com.nashtech.utils.databases.SqlServerJDBC;

public class PVPage {
	private WebDriverMethod driverMethod;

	public PVPage(WebDriverMethod driverMethod) {
		this.driverMethod = driverMethod;
	}
	
	private String TooltipElement = "Tooltip CSV Icon";
	private String TyreFinderElement = "Tyre Finder";
	private String ByTyreSizeTab = "Tab Tyre Size";
	private String BrowseAllTyres = "Browse All Tyres";
	private String ResetLabel = "Reset";
	private String QuestionTyreSize = "Where i can find tyre size";
	private String FindMyTyre = "Find my tyre button";
	private String DDLWidth = "Width dropdown list";
	private String DDLAspectR = "AspectR dropdown list";
	private String DDLRim = "Rim dropdown list";
	private String CloseBtn = "Close Button";
	private String PopupTxt = "Popup where i can find my tyre size";
	private String SearchInput = "Input text to search";
	private String FindByVehicleBtn = "Find by vehicle";
	private String OneResultHomePage = "One result in homepage";
	private String FindTyres = "Find tyres";
	private String OneResult = "Result label display";
	private String SearchAgain = "Search again display";
	private String ProdName = "Product Name display";
	private String BtnViewDetail = "Button View Detail";
	private String InfoText = "Information text";
	private String ImgProd = "Image of product display";
	private String ValueTyre = "Value of Tyre";
	private String FindTyreMenu = "Find Tyre in nav bar";
	private String breadcrumbText = "Breadcumb display text";
	private String tyreResult = "Tyre Result and Modify Search";
	private String speedRatingElement = "Speed Rating";
	private String speedRatingDDLElement = "Speed Rating DDL";
	private String FilterElement = "Filter product";
	private String allSeasonText = "Best all season";
	private String otherSuitable = "Other options";
	private String labelFirstElement = "Label of First Prod";
	private String imgFirstElement = "Image of First Prod";
	private String fuelFirstElement = "Fuel of First Prod";
	private String lifespanFirstElement = "Lifespan of First Prod";
	private String brakingFirstElement = "Braking of First Prod";
	private String comfortFirstElement = "Comfort of First Prod";
	private String chevronFirstElement = "Chevron of First Prod";
	private String hoverTextElement = "Text after hover";
	private String rulerHoverElement = "Ruler displayed";
	private String contentHoverElement = "Content displayed";
	private String textHoverImgElement = "Text hover img";
	
	// WebElement locators
	public static By carSuvVanPageIcon = By.xpath("//div[@id='navbar-collapse-1']/ul/li/a[contains(@href,'car-suv-van')]/img");
	private By tooltipTextIcon = By.xpath("//a[contains(@href,'car-suv-van')]//div[@class='tooltip-inner']");
	private By tyreFinder = By.xpath("//div[@id='pvSearch']");
	private By browseAllTyresLink = By.xpath("//a[@id='browseAll1']");
	private By browseAllTyresLinkByTyreSize = By.xpath("//a[@id='browseAll2']");
	private By byTyreSize = By.xpath("//a[@id='navFindByTyreSize']");
	private By browseAllTyreSize = By.xpath("//a[@id='browseAll2']");
	private By btnReset = By.xpath("//label[@id='btnReset']");
	private By btnQuestion = By.xpath("//a[@id='qTyreSize']");
	private By btnFindMyTyre = By.xpath("//button[@id='btnFindBySize']");
	private By dropdownWidth = By.xpath("//select[@id='TyreFinder_TyreWidth']");
	private By widthValue = By.xpath("//select[@id='TyreFinder_TyreWidth']/option");
	private By dropdownAspectR = By.xpath("//select[@id='TyreFinder_TyreAspectRatio']");
	private By aspectValue = By.xpath("//select[@id='TyreFinder_TyreAspectRatio']/option");
	private By dropdownRim = By.xpath("//select[@id='TyreFinder_TyreRim']");
	private By rimValue = By.xpath("//select[@id='TyreFinder_TyreRim']/option");
	private By closePopUpQues = By.xpath("//div[@id='findTyreSizeModal']//button");
	private By txtQues = By.xpath("//div[@id='findTyreSizeModal']//h4");
	private By inputSearch = By.xpath("//input[@id='FullCarName']");
	private By findByVehicle = By.xpath("//span[@id='btnFindByVehicle']");
	private By viewOneHomePage = By.xpath("//div[@id='viewOneResult']");
	private By labelFindTyres = By.xpath("//div[@class='block__box']//div[@class='navbar-header']");
	private By searchAgain = By.xpath("//div[@class='block__box']//div[@class='navbar-link']");
	private By resultNo = By.xpath("//p[contains(@class,'result-number')]");
	private By prodName = By.xpath("//h3[@class='product-name']");
	private By btnViewDetail = By.xpath("//a[contains(@class,'button-block')]");
	private By inforText = By.xpath("//div[@id='viewOneResult']//p[contains(@class,'title')]");
	private By imgProd = By.xpath("//div[@class='img__wrapper']//img");
	private By tyreSize = By.xpath("//div[@class='information_wrapper']//span");
	private By findTyreNavBar = By.xpath("//div[@class='navbar-header nav-header']/a[@finder-type='tyre']");
	private By searchResult = By.xpath("//div[@class='block__box']");
	private By aLinkOfImg = By.xpath("//div[@class='img__wrapper']/a");
	private By infoTyre = By.xpath("//div[@id='viewOneResult']//h4[@class='value']");
	private By breadcrumb = By.xpath("//ol[@class='breadcrumb']");
	private By label = By.xpath(".//div[@class='control__column']/h5");
	private By speedRating = By.xpath("//label[text()='Speed Rating']");
	private By infoTitle = By.xpath(".//div[@class='control__column']/h4");
	private By speedRatingDDL = By.xpath(".//div[@class='control__column']//select");
	private By prodFilter = By.xpath(".//div[@class='product__filter']");
	private By bestAllSeason = By.xpath("//h6[@id='recommendMessage']");
	private By otherTyres = By.xpath("//h6[contains(text(),'SUITABLE TYRES')]");
	private By labelFirstItem = By.xpath("(//div[@class='item__content']//h3)[1]");
	private By imgFirstItem = By.xpath("(//div[@class='item__content']//img)[1]");
	private By lifespanFirstItem = By.xpath("(//div[@class='item-4'])[1]");
	private By fuelFirstItem = By.xpath("(//div[@id='item-5'])[1]");
	private By brakingFirstItem = By.xpath("(//div[@id='item-6'])[1]");
	private By comfortFirstItem = By.xpath("(//div[@id='item-7'])[1]");
	private By chevronBtn = By.xpath("(//span[contains(@class,'item__chevron')])[1]");
	private By hoverText = By.xpath("//h5[@class='popover__title']");
	private By contentHover = By.xpath("//div[@class='popover__content']");
	private By rulerHover = By.xpath("//div[@class='ruler']");
	private By textHoverImg = By.xpath("//div[contains(@class,'item__img-overlay')]/h6");
	
	private String TooltipText = "Cars, Suvs & Vans";
	private String Select = "Select";
	private String TextQuest = "Where can I find tyre size?";

	private String rimPropertyID = "283";
	private String aspectPropertyID = "354";

	private String leftProperty = "left";
	private String textAlign = "text-align";
	private String displayProperty = "display";
	private String displayValue = "inline-block";
	
	private String masterNameColumn = "MasterName";
	private String urlColumn = "Url";
	private String prodVariantIDColumn = "ProductVariantId";
	private String valueColumn = "value";
	
	private Integer leftValue = 40;
	private Integer IndiaMarketID = 20;
	
	Map<String, String> dictionary = new HashMap<String, String>();
	
	public void mouseHoverOnIcon() throws Exception {
		driverMethod.mouseHover("Car Suv Van Icon", carSuvVanPageIcon);
	}

	public void clickBrowseAllTyres() throws Exception {
		driverMethod.click(BrowseAllTyres, browseAllTyresLink);
	}
	
	public void clickBrowseAllTyresByTyreSize() throws Exception {
		driverMethod.click(BrowseAllTyres, browseAllTyresLinkByTyreSize);
	}
	
	public void verifyTooltipText() throws Exception{
		// verify tooltip text
		driverMethod.verifyText(TooltipElement, tooltipTextIcon, TooltipText);
		// click CSV Icon
		driverMethod.click(TooltipElement, carSuvVanPageIcon);
	}
	
	public void verifyTyreFinderDisplayed() throws Exception{
		driverMethod.verifyElementDisplayed(TyreFinderElement, tyreFinder);
	}
	
	public void clickByTyreSize() throws Exception{
		driverMethod.click(ByTyreSizeTab, byTyreSize);
	}
	
	public void verifyTyreSizeDesign() throws Exception{
		driverMethod.verifyElementDisplayed(BrowseAllTyres, browseAllTyreSize);
		driverMethod.verifyElementDisplayed(ResetLabel, btnReset);
		driverMethod.verifyElementDisplayed(QuestionTyreSize, btnQuestion);
		verifyValueDefaultInDDL();
		driverMethod.verifyButtonIsDisable(FindMyTyre,btnFindMyTyre);
	}
	
	public void verifyTyreSizeAfterSearch(String width, String aspect, String rim) throws Exception{
		driverMethod.verifyElementDisplayed(BrowseAllTyres, browseAllTyreSize);
		driverMethod.verifyElementDisplayed(ResetLabel, btnReset);
		driverMethod.verifyElementDisplayed(QuestionTyreSize, btnQuestion);
		verifyValueAfterSearchInDDL(width, aspect, rim);
		driverMethod.verifyButtonIsEnable(FindMyTyre,btnFindMyTyre);
	}
	
	public void clickQuesTyreSize() throws Exception{
		driverMethod.click(QuestionTyreSize, btnQuestion);
	}
	
	public void verifyPopUpDisplay() throws Exception{
		driverMethod.verifyElementDisplayed(PopupTxt, txtQues);
		driverMethod.verifyEqual(driverMethod.getText(PopupTxt, txtQues), TextQuest);
	}
	
	public void closePopUpDisplay() throws Exception{
		driverMethod.click(CloseBtn, closePopUpQues);
	}
	
	public void selectValueInDDL(String width, String aspect, String rim) throws Exception{
		driverMethod.selectDDLByText(DDLWidth, dropdownWidth, width);
		driverMethod.selectDDLByText(DDLAspectR, dropdownAspectR, aspect);
		driverMethod.selectDDLByText(DDLRim, dropdownRim, rim);
	}
	
	public void clickResetBtn() throws Exception{
		driverMethod.click(ResetLabel, btnReset);
	}
	
	public void verifyValueDefaultInDDL() throws Exception{
		driverMethod.verifyDisplayDDL(DDLWidth, dropdownWidth, Select);
		driverMethod.verifyDisplayDDL(DDLAspectR, dropdownAspectR, Select);
		driverMethod.verifyDisplayDDL(DDLRim, dropdownRim, Select);
	}
	
	public void verifyValueAfterSearchInDDL(String width, String aspect, String rim) throws Exception{
		driverMethod.verifyDisplayDDL(DDLWidth, dropdownWidth, width);
		driverMethod.verifyDisplayDDL(DDLAspectR, dropdownAspectR, aspect);
		driverMethod.verifyDisplayDDL(DDLRim, dropdownRim, rim);
	}
	
	public void verifyWidthValueInDDL() throws Exception{
		List<String> WidthDB = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryCheckWidthValueInDDL(IndiaMarketID), valueColumn);
		List<String> WidthDDL = driverMethod.getListText(DDLWidth, widthValue);
		WidthDDL = WidthDDL.subList(1, WidthDDL.size());
		driverMethod.verifyEqualTwoLists(WidthDDL, WidthDB);
	}
	
	public void verifyAspectValueInDDL() throws Exception{
		List<String> AspectDB = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryCheckAspectValueInDDL(IndiaMarketID), valueColumn);
		List<String> AspectDDL = driverMethod.getListText(DDLAspectR, aspectValue);
		AspectDDL = AspectDDL.subList(1, AspectDDL.size());
		driverMethod.verifyEqualTwoLists(AspectDDL, AspectDB);
	}
	
	public void verifyRimValueInDDL() throws Exception{
		List<String> RimDB = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryCheckRimValueInDDL(IndiaMarketID), valueColumn);
		String rimSizeDb =  RimDB.toString().replace(".000", "");
		List<String> RimDDL = driverMethod.getListText(DDLRim, rimValue);
		RimDDL = RimDDL.subList(1, RimDDL.size());
		String rimDDL =  RimDDL.toString();
		driverMethod.verifyEqual(rimDDL, rimSizeDb);
	}
	
	public void verifyValueChangeBySelectDDL(String width) throws Exception{
		driverMethod.selectDDLByText(DDLWidth, dropdownWidth, width);
		List<String> AspectDB = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.querySelectValueInWidthDDL(IndiaMarketID,aspectPropertyID), valueColumn);
		List<String> AspectDDL = driverMethod.getListText(DDLAspectR, aspectValue);
		AspectDDL = AspectDDL.subList(1, AspectDDL.size());
		driverMethod.verifyEqualTwoLists(AspectDDL, AspectDB);
		List<String> RimDB = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.querySelectValueInWidthDDL(IndiaMarketID,rimPropertyID), valueColumn);
		String rimSizeDb =  RimDB.toString().replace(".000", "");
		List<String> RimDDL = driverMethod.getListText(DDLRim, rimValue);
		RimDDL = RimDDL.subList(1, RimDDL.size());
		String rimDDL =  RimDDL.toString();
		driverMethod.verifyEqual(rimDDL, rimSizeDb);
	}
	
	public void verifyRimValueChangeBySelectDDL(String aspect) throws Exception{
		driverMethod.selectDDLByText(DDLAspectR, dropdownAspectR, aspect);
		String RimDB = SqlServerJDBC.getValueInDatabase(WebQueryConstant.querySelectValueInAspectDDL(IndiaMarketID), valueColumn);
		String rimSizeDb =  RimDB.toString().replace(".000", "");
		List<String> RimDDL = driverMethod.getListText(DDLRim, rimValue);
		RimDDL = RimDDL.subList(1, RimDDL.size());
		String rimDDL =  RimDDL.toString().replace("[", "").replace("]", "");;
		driverMethod.verifyEqual(rimDDL, rimSizeDb);
	}
	
	public void verifyEnableBtnWhenDataIsFill(String rim) throws Exception{
		driverMethod.verifyButtonIsDisable(FindMyTyre,btnFindMyTyre);
		driverMethod.selectDDLByText(DDLRim, dropdownRim, rim);
		driverMethod.verifyButtonIsEnable(FindMyTyre, btnFindMyTyre);
	}
	
	public void inputValueToSearch(String prodName) throws Exception{
		driverMethod.inputText(SearchInput, inputSearch, prodName);
		driverMethod.click(FindByVehicleBtn, findByVehicle);
	}
	
	public void verifyResultInHomePage() throws Exception{
		driverMethod.verifyElementDisplayed(OneResultHomePage, viewOneHomePage);
		String pixel = driverMethod.findElement(viewOneHomePage).getCssValue(leftProperty);
		int value = Integer.parseInt(pixel.substring(0, 2));
		driverMethod.verifyEqual(value, leftValue);
		verifyCommonElementSearchByTyreSize();
	}
	
	public void verifyManuResultInHomePage(String breadcrumText) throws Exception{
		verifyBreadcumbDisplayed(breadcrumText);
		verifyTextDisplayed();
		driverMethod.verifyElementDisplayed(InfoText, infoTitle);
		driverMethod.verifyElementDisplayed(speedRatingDDLElement, speedRatingDDL);
		driverMethod.verifyElementDisplayed(FilterElement, prodFilter);
		driverMethod.verifyElementDisplayed(allSeasonText, bestAllSeason);
		driverMethod.verifyElementDisplayed(otherSuitable, otherTyres);
	}
	
	//verify UI of First Prod in List
	public void verifyUIOneProd() throws Exception{
		driverMethod.verifyElementDisplayed(labelFirstElement, labelFirstItem);
		driverMethod.verifyElementDisplayed(imgFirstElement, imgFirstItem);
		driverMethod.verifyElementDisplayed(lifespanFirstElement, lifespanFirstItem);
		driverMethod.verifyElementDisplayed(brakingFirstElement, brakingFirstItem);
		driverMethod.verifyElementDisplayed(fuelFirstElement, fuelFirstItem);
		driverMethod.verifyElementDisplayed(comfortFirstElement, comfortFirstItem);
		driverMethod.verifyElementDisplayed(chevronFirstElement, chevronBtn);
	}
	
	//verify hover on First Prod in List
	public void verifyHoverOnValue() throws Exception{
		driverMethod.scrollIntoView(lifespanFirstElement, lifespanFirstItem);
		driverMethod.mouseHover(lifespanFirstElement, lifespanFirstItem);
		driverMethod.verifyEqual(driverMethod.getText(hoverTextElement, hoverText), "LIFESPAN");
		driverMethod.verifyElementDisplayed(rulerHoverElement, rulerHover);
		driverMethod.verifyElementDisplayed(contentHoverElement, contentHover);

		driverMethod.mouseHover(fuelFirstElement, fuelFirstItem);
		driverMethod.waitForTextChange(hoverText, 30, "FUEL EFFICIENCY");
		driverMethod.verifyEqual(driverMethod.getText(hoverTextElement, hoverText), "FUEL EFFICIENCY");
		if(!driverMethod.verifyElementDisplayed(rulerHoverElement, rulerHover)){
			throw new Exception();
		}
		driverMethod.verifyElementDisplayed(contentHoverElement, contentHover);
		
		driverMethod.mouseHover(brakingFirstElement, brakingFirstItem);
		driverMethod.waitForTextChange(hoverText, 30, "BRAKING");
		driverMethod.verifyEqual(driverMethod.getText(hoverTextElement, hoverText), "BRAKING");
		driverMethod.verifyElementDisplayed(rulerHoverElement, rulerHover);
		driverMethod.verifyElementDisplayed(contentHoverElement, contentHover);
	
		driverMethod.mouseHover(comfortFirstElement, comfortFirstItem);
		driverMethod.waitForTextChange(hoverText, 30, "COMFORT");
		driverMethod.verifyEqual(driverMethod.getText(hoverTextElement, hoverText), "COMFORT");
		driverMethod.verifyElementDisplayed(rulerHoverElement, rulerHover);
		driverMethod.verifyElementDisplayed(contentHoverElement, contentHover);
	}
	
	//verify hover on Img of First Prod in List
	public void verifyHoverOnImage() throws Exception{
		driverMethod.verifyElementDisplayed(textHoverImgElement, textHoverImg);
	}
	
	public void verifyTextDisplayed() throws Exception{
		driverMethod.verifyElementDisplayed(tyreResult, label);
		driverMethod.verifyElementDisplayed(speedRatingElement, speedRating);
	}
	
	public void verifyBreadcumbDisplayed(String breadcrumText) throws Exception{
		driverMethod.verifyText(breadcrumbText, breadcrumb, breadcrumText);
	}
	
	public void searchByTyreSize(String width, String aspect, String rim) throws Exception{
		clickByTyreSize();
		selectValueInDDL(width, aspect, rim);
		searchByFindTyre();
	}
	
	public void clickFindTyreMenuAndSearch() throws Exception{
		driverMethod.click(FindTyreMenu, findTyreNavBar);
		searchByFindTyre();
	}
	
	public void searchByFindTyre() throws Exception{
		driverMethod.click(FindTyres, btnFindMyTyre);
	}
	
	public void verifyResultInAnotherPage() throws Exception{
		driverMethod.verifyElementDisplayed(OneResultHomePage, viewOneHomePage);
		String value = driverMethod.findElement(searchResult).getCssValue(displayProperty);
		driverMethod.verifyEqual(value, displayValue);
		verifyCommonElementSearchByTyreSize();
	}
	
	private void verifyCommonElementSearchByTyreSize() throws Exception{
		driverMethod.verifyElementDisplayed(FindTyres, labelFindTyres);
		String result = driverMethod.getText(OneResult, resultNo);
		driverMethod.verifyEqual(result, "1 possible tyre result for your search");
		driverMethod.verifyElementDisplayed(SearchAgain, searchAgain);
		driverMethod.verifyElementDisplayed(ProdName, prodName);
		driverMethod.verifyElementDisplayed(BtnViewDetail, btnViewDetail);
		driverMethod.verifyElementDisplayed(ImgProd, imgProd);
		String alignText = driverMethod.findElement(viewOneHomePage).getCssValue(textAlign);
		driverMethod.verifyEqual(alignText, "center");
		driverMethod.verifyElementDisplayed(ValueTyre, tyreSize);
		driverMethod.verifyElementDisplayed(InfoText, inforText);
	}
	
	public void searchAgain() throws Exception{
		driverMethod.click(SearchAgain, searchAgain);
	}
	
	public void verifyProdNameAfterSearch(String width, String aspect, String rim) throws Exception{
		String masterNameDB = SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryGetProductNameAfterSearch(IndiaMarketID,width, aspect, rim), masterNameColumn);
		String resultName = driverMethod.getText(ProdName, prodName);
		driverMethod.verifyEqual(resultName, masterNameDB);
	}
	
	private String getProdIDFromImg() throws Exception{
		String url = driverMethod.getAttribute(ImgProd, aLinkOfImg, "href");
		String productID = (url.substring(url.lastIndexOf("/") + 1));
		return productID;
	}
	
	public void verifyImgLinkAfterSearch() throws Exception{
		String prodID = getProdIDFromImg();
		String url = SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryGetURLProductImage(prodID), urlColumn);
		String src = driverMethod.getAttribute(ImgProd, imgProd, "src");
		driverMethod.verifyEqual(src, url);
	}
	
	public void verifyValueAfterSearch(String width, String aspect, String rim) throws Exception{
		String prodVariantID = SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryGetProductNameAfterSearch(IndiaMarketID,width, aspect, rim), prodVariantIDColumn);
		List<String> propertyIDValue = (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryGetValueAfterSearch(prodVariantID),valueColumn));
		if(propertyIDValue.contains("False"))
			propertyIDValue.remove("False");
		else if(propertyIDValue.contains("True")){
			propertyIDValue.remove("True");
			propertyIDValue.add("2");
		}
		List<String> valueProperty = driverMethod.getListText(ValueTyre, infoTyre);
		for (int b=0; b<valueProperty.size(); b++) {
			   String replaceLetters  = valueProperty.get(b);
			   replaceLetters = replaceLetters.replaceAll("/5","");
			   System.out.println(replaceLetters);
			   valueProperty.set(b, replaceLetters);
			}
		
		driverMethod.verifyEqualTwoLists(valueProperty, propertyIDValue);
		
	}
}
