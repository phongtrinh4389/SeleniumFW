package test.page.objects;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import test.common.WebQueryConstant;

import com.nashtech.core.web.WebDriverMethod;
import com.nashtech.utils.databases.SqlServerJDBC;

public class PVTyresPage {
	private WebDriverMethod driverMethod;
	private String breadcrumbText = "Breadcumb display text";
	private String labelText = "Label display text";
	private String vehOptText = "Vehicle options display text";
	private String terrainOptText = "Product terrain options display text";
	private String nameProductText = "Name of product: ";
	private String sizeProductText = "Size of product: ";
	private String txtProductDesc = "Text of product: ";
	private String BreadcrumbText = "Home Cars, Suvs & Vans Browse All Tyres";
	private String LabelText = "results for Cars, SUVs, Vans";
	private String blockProductElement = "Block of product";
	private String imgProductElement = "Image of product";
	private String introProductElement = "Intro of product";
	private String btnDetailsElement = "Button details of product";
	private String formatMinSizeTyre = "Format minimum size of Tyre";
	private String formatMaxSizeTyre = "Format maximum size of Tyre";
	
	private String defaultColumn = "RESULT";
	private String productVariantIdColumn = "ProductVariantId";
	private String masterNameColumn = "MasterName";
	private String valueColumn = "Value";
	private String propertyIDColumn = "PropertyID";
	private String carClassID = "982";
	private String suvClassID = "983";
	private String optOnRoad = "On Road";
	private String optOffRoad = "Off Road";
	private String optMixed = "Mixed";
	private String optPopular = "Popular";
	private String optPremium = "Premium";
	private String optLuxury = "Luxury";
	private String txtNoTyreFound = "No tyres found. For more details, please get in touch with our team at 1800 212 7070.";
	public static String regexSizeTyre = "(\\d*[/]\\d*\\s[R]\\d*\\s\\d*[T,V,W,H,S])";
	private String labelFormat = "^\\d{0,2}.*";
	
	private Integer IndiaMarketID = 20;
	private Integer UKMarketID = 14;
	private Integer SAMarketID = 23;
	
	public PVTyresPage(WebDriverMethod driverMethod) {
		this.driverMethod = driverMethod;
	}

	// WebElement locators
	private By breadcrumb = By.xpath("//ol[@class='breadcrumb']");
	private By label = By.xpath(".//div[@class='control__column']/h5");
	private By vehicleOptions = By.xpath("//div[@id='classContainer']/button");
	private By terrainOptions = By.xpath("//div[@id='terrainContainer']/button");
	private By blockProduct = By.xpath("//div[contains(@class,'product-tile-item')][1]");
	private By masterNameProduct = By.xpath("(//h3[contains(@class,'product__name')])");
	private By nameProduct = By.xpath("(//h3[contains(@class,'product__name')])[1]");
	private By imgProduct = By.xpath("(//div[@class='img--product'])[1]");
	private By introProduct = By.xpath("(//p[contains(@class,'product__text')])[1]");
	private By sizeProduct = By.xpath("(//h6[@class='product__size'])[1]");
	private By btnDetails = By.xpath("(//a[contains(@class,'full product__btn')])[1]");
	private By textProduct = By.xpath("(//p[contains(@class,'product__text')])[1]");
	private By locatorNoTyreFound = By.xpath("//span[@class='noTyreFound']");
	private By btnCar = By.xpath("//button[@id='btnCar']");
	private By btnSuv = By.xpath("//button[@id='btnSuv']");
	private By btnOnRoad = By.xpath("//button[@filter-value='On Road']");
	private By btnOffRoad = By.xpath("//button[@filter-value='Off Road']");
	private By btnMixed = By.xpath("//button[@filter-value='Mixed']");
	private By btnPopular = By.xpath("//button[@id='btnPopular']");
	private By btnPremium = By.xpath("//button[@id='btnPremium']");
	private By btnLuxury = By.xpath("//button[@id='btnLyxury']");
	private By txtTerrain = By.xpath("//div[@id='blockTerrain']//label");
	
	Map<String, String> dictionary = new HashMap<String, String>();

	public void connectToDb() throws Exception {
		SqlServerJDBC.getConnection();
	}

	public List<String> getTextVehOpts() throws Exception {
		return driverMethod.getListText(vehOptText, vehicleOptions);
	}

	public List<String> getTextMasterName() throws Exception {
		return driverMethod.getListText(nameProductText, masterNameProduct);
	}
	public List<String> getTextTerrainOpts() throws Exception {
		return driverMethod.getListText(terrainOptText, terrainOptions);
	}

	public String getNameFirstProd() throws Exception {
		return driverMethod.getText(nameProductText, nameProduct);
	}

	public String getSizeProduct() throws Exception {
		return driverMethod.getText(sizeProductText, sizeProduct);
	}
	
	public String getFirstProdText() throws Exception{
		return driverMethod.getText(txtProductDesc, textProduct);
	}
	
	public Integer getNumberOfProd() throws Exception {
		int number = 0;
		String[] splitStr = driverMethod.findElement(label).getText().split("\\s+");
		number = Integer.parseInt(splitStr[0]);
		return number;
	}

	public Integer getNumberAvailableFirstProd() throws Exception {
		int number = 0;
		String[] splitStr = driverMethod.findElement(sizeProduct).getText().split("\\s+");
		number = Integer.parseInt(splitStr[0]);
		return number;
	}

	public Integer getNumberOfProdInDb() throws Exception {
		return Integer.parseInt(SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryCountNoOfProd(IndiaMarketID), defaultColumn));
	}

	public Integer getNumberOfFirstProdInDb() throws Exception {
		return Integer.parseInt(SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryNoOfFristProd(IndiaMarketID,getNameFirstProd()), defaultColumn));
	}

	public Integer getMinValueInList(List<String> result) throws Exception {
		Integer minvalue = 0;
		minvalue = Integer.parseInt(Collections.min(result));
		return minvalue;
	}

	public Integer getMaxValueInList(List<String> result) throws Exception {
		Integer maxvalue = 0;
		maxvalue = Integer.parseInt(Collections.max(result));
		return maxvalue;
	}

	public String getInforTyre() {
		Integer width = Integer.parseInt(dictionary.get(String.valueOf(WebQueryConstant.Width)));
		Integer ratio = Integer.parseInt(dictionary.get(String.valueOf(WebQueryConstant.AspectR)));
		long rimsize = Math.round(Double.parseDouble(dictionary.get(String.valueOf(WebQueryConstant.RimSize))));
		Integer loadindex = Integer.parseInt(dictionary.get(String.valueOf(WebQueryConstant.LoadIndex)));
		String speedrating = dictionary.get(String.valueOf(WebQueryConstant.SpeedRating));
		return width + "/" + ratio + " " + "R" + rimsize + " " + loadindex + speedrating;
	}

	public String getValuesOfMinTyre() throws Exception {
		List<String> result = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryCountNoOfTyreSizeByFirstProd(IndiaMarketID, getNameFirstProd()),
				productVariantIdColumn);
		Integer minvalue = getMinValueInList(result);

		List<String> propertyIDValue = (SqlServerJDBC.getListValueInDatabase(
				WebQueryConstant.queryGetValuesOfTyre(Integer.toString(minvalue)), propertyIDColumn));
		List<String> valueTyres = (SqlServerJDBC.getListValueInDatabase(
				WebQueryConstant.queryGetValuesOfTyre(Integer.toString(minvalue)), valueColumn));
		for (int i = 0; i < propertyIDValue.size(); i++) {
			dictionary.put(propertyIDValue.get(i), valueTyres.get(i));
		}
		String minInforTyres = getInforTyre();
		return minInforTyres;
	}

	public String getValuesOfMaxTyre() throws Exception {
		List<String> result = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryCountNoOfTyreSizeByFirstProd(IndiaMarketID, getNameFirstProd()),
				productVariantIdColumn);
		Integer maxvalue = getMaxValueInList(result);

		List<String> propertyIDValue = (SqlServerJDBC.getListValueInDatabase(
				WebQueryConstant.queryGetValuesOfTyre(Integer.toString(maxvalue)), propertyIDColumn));
		List<String> valueTyres = (SqlServerJDBC.getListValueInDatabase(
				WebQueryConstant.queryGetValuesOfTyre(Integer.toString(maxvalue)), valueColumn));
		for (int i = 0; i < propertyIDValue.size(); i++) {
			dictionary.put(propertyIDValue.get(i), valueTyres.get(i));
		}
		String maxInforTyres = getInforTyre();
		return maxInforTyres;
	}

	public static String urlProductImg(String prodID) throws Exception {
		String urlImage = null;
		String queryGetURLProductImage = WebQueryConstant.queryGetURLProductImage(prodID);
		urlImage = SqlServerJDBC.getValueInDatabase(queryGetURLProductImage,"Url");
		return urlImage;
	}

	public void viewFirstTyreDetails() throws Exception {
		driverMethod.scrollIntoView("View First Tyre Details", btnDetails);
		driverMethod.click("View First Tyre Details", btnDetails);
	}

	public void filterByCar() throws Exception {
		driverMethod.click("Filter By Car", btnCar);
	}

	public void filterBySuv() throws Exception {
		driverMethod.click("Filter By Suv", btnSuv);
	}

	public void filterByOnRoad() throws Exception {
		driverMethod.click("Filter By On Road", btnOnRoad);
	}

	public void filterByOffRoad() throws Exception {
		driverMethod.click("Filter By Off Road", btnOffRoad);
	}

	public void filterByMixed() throws Exception {
		driverMethod.click("Filter By Mixed", btnMixed);
	}

	public void filterByPopular() throws Exception {
		driverMethod.click("Filter By Popular", btnPopular);
	}

	public void filterByPremium() throws Exception {
		driverMethod.click("Filter By Premium", btnPremium);
	}

	public void filterByLuxury() throws Exception {
		driverMethod.click("Filter By Luxury", btnLuxury);
	}

	public List<String> getListOfCars() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryFilterBy(IndiaMarketID, carClassID), masterNameColumn));
	}

	public List<String> getListOfSuvs() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryFilterBy(IndiaMarketID, suvClassID), masterNameColumn));
	}

	public List<String> getListOfOnRoad() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryTerrainFilterBy(IndiaMarketID, suvClassID, optOnRoad), masterNameColumn));
	}

	public List<String> getListOfOffRoad() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryTerrainFilterBy(IndiaMarketID, suvClassID, optOffRoad), masterNameColumn));
	}

	public List<String> getListOfMixed() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryTerrainFilterBy(IndiaMarketID, suvClassID, optMixed), masterNameColumn));
	}

	public List<String> getListOfPopular() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryProdRangeFilterBy(IndiaMarketID, suvClassID, optPopular), masterNameColumn));
	}

	public List<String> getListOfPremium() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryProdRangeFilterBy(IndiaMarketID, suvClassID, optPremium), masterNameColumn));
	}

	public List<String> getListOfLuxury() throws Exception {
		return (SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryProdRangeFilterBy(IndiaMarketID, suvClassID, optLuxury), masterNameColumn));
	}

	public void verifyResultDisplayed(List<String> actual, List<String> expected) throws Exception{
		if (actual != null && actual.isEmpty() && expected != null && expected.isEmpty()) {
			driverMethod.verifyText("No Tyre Found", locatorNoTyreFound, txtNoTyreFound);
		} else{
			driverMethod.verifyEqualTwoLists(actual, expected);
		}
	}
	
	public void verifyNameOfFirstProd() throws Exception{
		String actualName = getNameFirstProd();
		viewFirstTyreDetails();
		PVDetailsPage pvDetail = new PVDetailsPage(driverMethod);
		String prodID = pvDetail.getProductIDFromURL();
		driverMethod.backToLastPage();
		String expectedName = SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryGetProdNameByID(prodID), masterNameColumn);
		driverMethod.verifyEqual(actualName, expectedName);
	}
	
	public void verifyBreadcumbDisplayed() throws Exception{
		driverMethod.verifyText(breadcrumbText, breadcrumb, BreadcrumbText);
	}
	
	public void verifyLabelTxtDisplayed() throws Exception{
		String getLabel = driverMethod.getText(labelText, label);
		driverMethod.verifyFormatString(labelText, getLabel, labelFormat);
		driverMethod.verifyContainText(labelText, label, LabelText);
	}
	
	public void verifyBlockOfFirstProd() throws Exception{
		// verify block Product displayed, check in one block of product
		driverMethod.verifyElementDisplayed(blockProductElement,blockProduct);
		driverMethod.verifyElementDisplayed(nameProductText,nameProduct);
		driverMethod.verifyElementDisplayed(imgProductElement, imgProduct);
		driverMethod.verifyElementDisplayed(introProductElement,introProduct);
		driverMethod.verifyElementDisplayed(sizeProductText,sizeProduct);
		driverMethod.verifyElementDisplayed(btnDetailsElement, btnDetails);
	}
	
	public void verifyNoOfProd() throws Exception{
		driverMethod.verifyEqual(getNumberOfProd(),getNumberOfProdInDb());
	}
	
	public void verifyNoOfOptAvlb() throws Exception{
		driverMethod.verifyEqual(getNumberAvailableFirstProd(),getNumberOfFirstProdInDb());
	}
	
	public void verifyMinMaxSizeFormat() throws Exception{
		// get the Min Value of Tyres
		String minimumSize = getValuesOfMinTyre();
		// verify format of minimum size
		driverMethod.verifyFormatString(formatMinSizeTyre, minimumSize,PVTyresPage.regexSizeTyre);
		// get the Max Value of Tyres
		String maximumSize = getValuesOfMaxTyre();
		// verify format of maximum size
		driverMethod.verifyFormatString(formatMaxSizeTyre, maximumSize,PVTyresPage.regexSizeTyre);
		String formatPageDisplay = minimumSize + " - " + maximumSize;
		// verify Display text "Min size - Max size"
		driverMethod.verifyStringContainsText(getSizeProduct(),formatPageDisplay);
	}
	
	public void verifyProdTxt() throws Exception{
		String url = driverMethod.getAttribute(btnDetailsElement, btnDetails,"href");
		String prodID = (url.substring(url.lastIndexOf("/") + 1));
		driverMethod.verifyEqual(getFirstProdText(), SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryGetProdText(prodID), valueColumn));
	}
	
	public void backToLastPage(){
		driverMethod.backToLastPage();
	}
	
	public void verifyTerrainTextDisplay() throws Exception{
		driverMethod.verifyEqual(driverMethod.getText(terrainOptText, txtTerrain), "Terrain");
	}
	
}
