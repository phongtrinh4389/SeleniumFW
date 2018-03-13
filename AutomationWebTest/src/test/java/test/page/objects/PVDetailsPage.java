package test.page.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import test.common.WebQueryConstant;

import com.nashtech.core.web.WebDriverMethod;
import com.nashtech.utils.databases.SqlServerJDBC;
import com.nashtech.utils.report.Log;

public class PVDetailsPage {
	private WebDriverMethod driverMethod;

	public PVDetailsPage(WebDriverMethod driverMethod) {
		this.driverMethod = driverMethod;
	}

	private String BreadcrumbElement = "Breadcrumb display";
	private String ProductTextElement = "Product text display";
	private String BreadcrumbText = "Home Cars, Suvs & Vans Browse all tyres ";
	private String DescTxt = "Description text display";
	private String ProdImg = "Product imgage display";
	private String CameraIcon = "Camera icon display";
	private String ProdWarranty = "Product warranty display";
	private String FindPlaceElement = "Find place label display";
	private String FindPlaceLabel = "Find place to buy";
	private String SearchInpt = "Search box display";
	private String SearchTxt = "City or postal code";
	private String BtnLocation = "Location button display";
	private String BtnLocationTxt = "Use my location";
	private String SaveOShareTxt = "Save or share";
	private String BtnPrint = "Print button display";
	private String BtnShare = "Share button display";
	private String FeatureTab = "Feature Tab display";
	private String SpecifyTab = "Specification Tab display";
	private String WarantyTab = "Warranty Tab display";
	private String OptionDDL = "Options dropdownlist";
	private String SelectFilter = "Select filter";
	private String RowSpecify = "Row spec display";
	private String FABImage = "FAB Url Image display";
	private String Benefits = "Benefits display";
	private String Features = "Features display";
	private String Rtb = "Rtb display";
	private String RtbDisclaimer = "RTB Disclaimer";
	private String ListRim = "Rim diameter";
	private String BtnFb = "Share facebook button";
	private String UsrFb = "Username to login";
	private String PassFb = "Pwd to login";
	private String LoginFb = "Login button";
	private String FbContent = "Content to post to fb";
	private String FirstFeed = "First Feed on Fb";
	private String BtnTwt = "Share twitter button";
	private String BtnEmail = "Share email button";
	private String EmailInput = "Email input display";
	private String XBtn = "X Button";
	private String YtbBtn = "Youtube button";
	private String BackToTop = "Back to top";
	private String SendEmail = "Send email button";
	private String CloseEmail = "Close email button";
	
	// WebElement locators
	private By productImg = By.xpath("//img[@class='product__img_apo']");
	private By productContent = By.xpath("//div[@itemprop='productContent']");
	private By breadcrumb = By.xpath("//ol[contains(@class,'breadcrumb')]");
	private By prodTxt = By.xpath("//div[@itemprop='productContent']/h1");
	private By descriptionTxt = By.xpath("//p[@itemprop='description']");
	private By cameraIcon = By.xpath("//span[@itemprop='itemListElement']");
	private By prodWarranty = By.xpath("//div[@itemprop='itemListElement']/div[contains(@class,'product__warranty')]");
	private By labelFindPlace = By.xpath("//div[contains(@class,'find-dealer')]//h4");
	private By searchInput = By.xpath("//div[@class='search-box input-group']/input");
	private By locationBtn = By.xpath("(//a[@id='userLocation'])[1]");
	private By ssTxt = By.xpath("//h6[@id='hTitle']");
	private By printBtn = By.xpath("//span[@id='btnPrint']");
	private By shareBtn = By.xpath("//span[@id='share-button']");
	private By featureTab = By.xpath("//a[@href='#feature']");
	private By specifyTab = By.xpath("//a[@href='#specification']");
	private By warantyTab = By.xpath("//a[@href='#waranty']");
	private By filterDDL = By.xpath("//select[@id='filterspect']/option");
	private By selectDDL = By.xpath("//select[@id='filterspect']");
	private By rowSpec = By.xpath("//table[@id='dataTable']/tbody/tr[@role='row']");
	private By imgFAB = By.xpath("//section[@id='feature']");
	private By benefitTxt = By.xpath("//ul[@itemprop='itemList']//p[@itemprop='benefit']");
	private By featureTxt = By.xpath("//ul[@itemprop='itemList']//p[@itemprop='feature']");
	private By rtbTxt = By.xpath("//ul[@itemprop='itemList']//p[@itemprop='rtb']");
	private By rtbDisclaimerTxt = By.xpath("//div[contains(@class,'text-center')]//p[@class='para-small']");
	private By rimValue = By.xpath("//div[@id='dataTable_wrapper']//td[contains(@class,'rim')]");
	private By fbBtn = By.xpath("//span[contains(@class,'fbshare')]");
	private By twitterBtn = By.xpath("//span[contains(@class,'twsharelink')]");
	private By usrFb = By.xpath("//input[@id='email']");
	private By passFb = By.xpath("//input[@id='pass']");
	private By loginFb = By.xpath("//input[@type='submit']");
	private By postFb = By.xpath("//button[@name='__CONFIRM__']");
	private By unclickFb = By.xpath("//div[@class='unclickable']");
	private By firstFeedFb = By.xpath("(//div[@class='userContent'])[1]/following::div[1]");
	private By usrTwitter = By.xpath("//input[@id='username_or_email']");
	private By pwdTwitter = By.xpath("//input[@id='password']");
	private By sttTwitter = By.xpath("//textarea[@id='status']");
	private By emailBtn = By.xpath("//span[@id='btnEmail']");
	private By inputEmail = By.xpath("//input[contains(@class,'form-popup-email')]");
	private By h3Email = By.xpath("//h3[@class='modal-title']");
	private By sendEmailBtn = By.xpath("//button[@type='submit']");
	private By successEmail = By.xpath("//h3[@id='successfulMessage']");
	private By closeShare = By.xpath("//span[@class='close-share-btn']");
	private By ytbShare = By.xpath("//li[@class='youtube-bg']");
	private By aBackToTop = By.xpath("//a[@class='tab back-to-top']");
	private By closeEmail = By.xpath("//div[contains(@class,'modal-send-email')]//button[@class='close']");
	
	private String placeholderAtt = "placeholder";
	private String prodVariantIDColumn = "ProductVariantID";
	private String valueColumn = "Value";
	private String propertyIDColumn = "PropertyID";
	private String urlColumn = "Url";
	private String backgrdImg = "background-image";
	private String defaultFABUrl = "url(\"http://52.57.94.156:88/App_Themes/img/FAB_PV.jpg\")";
	
	private Integer SAMarketID = 23;
	private Integer IndiaMarketID = 20;
	
	Map<String, String> dictionary = new HashMap<String, String>();
	
	public String getUrlOfProductImg() throws Exception {
		String url = null;
		url = driverMethod.getAttribute("Get link of product image",
				productImg, "src");
		return url;
	}

	public void verifyProdContentDisplayed() throws Exception {
		driverMethod.verifyElementDisplayed("Product content is displayed",
				productContent);
	}

	public void verifyBreadcrumbDisplayed() throws Exception {
		String productText = getProdTxt();
		String breadcrum = BreadcrumbText + productText;
		driverMethod.verifyText(BreadcrumbElement, breadcrumb, breadcrum);
	}

	public void verifyIntroTextDisplayed() throws Exception {
		driverMethod.verifyElementDisplayed(DescTxt, descriptionTxt);
	}

	public void verifyImgDisplayed() throws Exception {
		driverMethod.verifyElementDisplayed(ProdImg, productImg);
	}

	public void verifyCameraDisplayed() throws Exception {
		driverMethod.verifyElementDisplayed(CameraIcon, cameraIcon);
	}

	public void verifyWarrantyDisplayed() throws Exception {
		if (driverMethod.verifyElementDisplayed(ProdWarranty, prodWarranty)) {
			Log.info("The element " + ProdWarranty + " is displayed");
		} else {
			Log.info("Dont have " + ProdWarranty);
		}
	}

	public void verifyFindPlaceLabelDisplayed() throws Exception {
		driverMethod.verifyEqual(
				driverMethod.getText(FindPlaceElement, labelFindPlace),
				FindPlaceLabel);
	}

	public void verifySearchBox() throws Exception {
		driverMethod.verifyElementDisplayed(SearchInpt, searchInput);
		String helpText = driverMethod.getAttribute(SearchInpt, searchInput,
				placeholderAtt);
		driverMethod.verifyEqual(helpText, SearchTxt);
	}

	public void verifyLocationBtn() throws Exception {
		driverMethod.verifyElementDisplayed(BtnLocation, locationBtn);
		String locationText = driverMethod.getText(BtnLocation, locationBtn);
		driverMethod.verifyEqual(locationText, BtnLocationTxt);
	}

	public void verifySaveShareDisplayed() throws Exception {
		String saveOShare = driverMethod.getText(SaveOShareTxt, ssTxt);
		driverMethod.verifyEqual(saveOShare, SaveOShareTxt);
		driverMethod.verifyElementDisplayed(BtnPrint, printBtn);
		driverMethod.verifyElementDisplayed(BtnShare, shareBtn);
	}

	public void verifyFeatureTabDisplayed() throws Exception {
		driverMethod.verifyElementDisplayed(FeatureTab, featureTab);
	}

	public void verifySpecifyTabDisplayed() throws Exception {
		driverMethod.verifyElementDisplayed(SpecifyTab, specifyTab);
	}

	public void verifyWarantyTabDisplayed() throws Exception {
		if (driverMethod.verifyElementDisplayed(WarantyTab, warantyTab)) {
			Log.info("The element " + WarantyTab + " is displayed");
		} else {
			Log.info("Dont have " + WarantyTab);
		}
	}

	public String getProductIDFromURL() throws Exception {
		String url = driverMethod.getUrl();
		String productID = (url.substring(url.lastIndexOf("/") + 1));
		return productID;
	}
	
	public String getDomainFromURL() throws Exception {
		String url = driverMethod.getUrl();
		String urlbreak[] = url.split("//");
		System.out.println(urlbreak[1]);
		String domain = (urlbreak[1].substring(0, (urlbreak[1].indexOf("/"))));
		if(domain.contains(":"))
			domain = domain.substring(0, (domain.indexOf(":")));
		return domain;
	}
	
	private String getFormatTyre() {
		Integer width = Integer.parseInt(dictionary.get("289"));
		Integer ratio = Integer.parseInt(dictionary.get("354"));
		long rimsize = Math.round(Double.parseDouble(dictionary.get("283")));
		Integer loadindex = Integer.parseInt(dictionary.get("235"));
		String speedrating = dictionary.get("295");
		return width + " " + ratio + " " + rimsize + " " + loadindex + " " + speedrating;
	}
	
	public void verifyValueOfRimSize() throws Exception{
		String prodID = getProductIDFromURL();
		List<String> options = driverMethod.getListText(OptionDDL, filterDDL);
		for(int i = 0; i < options.size(); i++){
			driverMethod.scrollIntoView(SelectFilter, selectDDL);
			driverMethod.selectDDLByText(SelectFilter, selectDDL, options.get(i));
			String rimSize = options.get(i).substring(0, 2);
			List<String> listProdVariantID = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryValueInProDetailPage(IndiaMarketID,prodID,rimSize), prodVariantIDColumn);
			listProdVariantID = listProdVariantID.stream().distinct().collect(Collectors.toList());
			for(int j = 0; j < listProdVariantID.size(); j++){
				String queryGetDetail = WebQueryConstant.queryValueInProDetailPage(IndiaMarketID,prodID,rimSize) + "and vp.productvariantid="+listProdVariantID.get(j);
				List<String> propertyIDValue = (SqlServerJDBC.getListValueInDatabase(queryGetDetail, propertyIDColumn));
				List<String> valueTyres = (SqlServerJDBC.getListValueInDatabase(queryGetDetail, valueColumn));
				for (int k = 0; k < propertyIDValue.size(); k++) {
					dictionary.put(propertyIDValue.get(k), valueTyres.get(k));
				}
				String row = getFormatTyre();
				List<String> expectTxt = driverMethod.getListText(RowSpecify, rowSpec);
				driverMethod.stringContainsItemFromList(row, expectTxt);
			}
		}
	}
	
	public String getFABUrlImageFromDb(String prodID) throws Exception{
		String urlFABImage = null;
		String queryGetURLProductImage = WebQueryConstant.queryGetUrlFABImage(prodID);
		urlFABImage = SqlServerJDBC.getValueInDatabase(queryGetURLProductImage,urlColumn);
		return urlFABImage;
	}
	
	public void verifyProductImg() throws Exception{
		String urlImgOfProdDetail = getUrlOfProductImg();
		String prodID = getProductIDFromURL();
		driverMethod.verifyEqual(urlImgOfProdDetail, PVTyresPage.urlProductImg(prodID));
	}
	
	public void verifyFABImg() throws Exception{
		String urlFABOnSite = driverMethod.getCSSValue(FABImage, imgFAB, backgrdImg);
		String prodID = getProductIDFromURL();
		driverMethod.verifyEqual(urlFABOnSite, getFABUrlImageFromDb(prodID));
	}
	
	public void verifyProdTagTextBenefitsFeatures() throws Exception{
		String prodID = getProductIDFromURL();
		driverMethod.scrollIntoView(Benefits, benefitTxt);
		String query = WebQueryConstant.queryGetProdText(prodID);
		String prodText = SqlServerJDBC.getValueInDatabase(query, valueColumn);
		String descTxt = getDescTxt();
		List<String> benefitText = driverMethod.getListText(Benefits, benefitTxt);
		List<String> benefitTextDb = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryGetProdBenefits(prodID), valueColumn);
		List<String> featureText = driverMethod.getListText(Features, featureTxt);
		List<String> featureTextDb = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryGetProdFeatures(prodID), valueColumn);
		List<String> rtbText = driverMethod.getListText(Rtb, rtbTxt);
		List<String> rtbTextDb = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryGetProdRtb(prodID), valueColumn);
		driverMethod.verifyEqual(descTxt, prodText);
		driverMethod.verifyEqual(benefitText, benefitTextDb);
		driverMethod.verifyEqual(featureText, featureTextDb);
		driverMethod.verifyEqual(rtbText, rtbTextDb);
	}
	
	public void verifyRTBDisclaimerTxt() throws Exception{
		String rtbDisclaimer = null;
		String actualRTBDisclaimer = null;
		boolean rtbDisclaimerDisplayed = driverMethod.verifyElementDisplayed(RtbDisclaimer, rtbDisclaimerTxt);
		if (rtbDisclaimerDisplayed == false){
			rtbDisclaimer = " ";
		} else
			rtbDisclaimer = driverMethod.getText(RtbDisclaimer, rtbDisclaimerTxt);
		String prodID = getProductIDFromURL();
		String RTBDisclaimer = SqlServerJDBC.getValueInDatabase(WebQueryConstant.queryGetRTBDisclaimer(prodID), valueColumn);
		if(RTBDisclaimer == null)
			actualRTBDisclaimer = " ";
		else
			actualRTBDisclaimer = RTBDisclaimer;
		driverMethod.verifyEqual(rtbDisclaimer, actualRTBDisclaimer);
	}
	
	public void verifyCheckRimSizeDDL() throws Exception{
		String productText = getProdTxt();
		List<String> prodVariantID = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryCountNoOfTyreSizeByFirstProd(IndiaMarketID,productText), prodVariantIDColumn);
		String listProVariantID =  prodVariantID.toString().replace("[", "").replace("]", "");
		List<String> rimSizeDDL = SqlServerJDBC.getListValueInDatabase(WebQueryConstant.queryGetRimSizeDDL(listProVariantID), valueColumn);
		String rimSizeDb =  rimSizeDDL.toString().replace(".000", "");
		List<String> options = driverMethod.getListText(OptionDDL, filterDDL);
		String optSize =  options.toString().replace("\" rim", "");
		driverMethod.verifyEqual(optSize, rimSizeDb);
	}
	
	public void verifyRimSizeDDLOpen() throws Exception{
		List<String> options = driverMethod.getListText(OptionDDL, filterDDL);
		List<Integer> intList = new ArrayList<Integer>();
		for(String s : options) {
			intList.add(Integer.valueOf(s.toString().replace("\" rim", "")));
		}
		driverMethod.verifyListIsAscendingOrder(intList);
	}
	
	public void verifyMatchTyreSize() throws Exception{
		List<String> options = driverMethod.getListText(OptionDDL, filterDDL);
		for(int i = 0; i < options.size(); i++){
			driverMethod.selectDDLByText(SelectFilter, selectDDL, options.get(i));
			List<String> rimSize = driverMethod.getListText(ListRim, rimValue);
			rimSize = rimSize.stream().distinct().collect(Collectors.toList());
			String rim = rimSize.toString().replace("[", "").replace("]", "");
			driverMethod.verifyEqual(rim, options.get(i).replace("\" rim", ""));
		}
	}
	
	public void inputAddToFindPlace(String address) throws Exception{
		driverMethod.scrollIntoView(SearchInpt, searchInput);
		driverMethod.inputText(SearchInpt, searchInput, address);
		Thread.sleep(2*1000);
		driverMethod.findElement(searchInput).sendKeys(Keys.ARROW_DOWN);
		driverMethod.findElement(searchInput).sendKeys(Keys.ENTER);
	}
	
	public void shareViaFacebook(String username, String pass) throws Exception{
		String handle = driverMethod.getWindowHandle();
		try {
			List<String> ls = getProdAndDescTxt();
			String domain = getDomainFromURL();
			ls.add(domain);
			String newlist = ls.toString().replace("[", "").replace("]", "");
			newlist = newlist.replace(", ", "\n");
			driverMethod.click(BtnShare, shareBtn);
			driverMethod.click(BtnFb, fbBtn);		
			Thread.sleep(5*1000);
			// Switch to new window opened
			for (String winHandle : driverMethod.getWindowHandles()){
					driverMethod.switchHandle(winHandle);
					if (driverMethod.getTitle().contains("Facebook")){
					    driverMethod.inputText(UsrFb, usrFb, username);
					    driverMethod.inputText(PassFb, passFb, pass);
					    driverMethod.click(LoginFb, loginFb);
					    Thread.sleep(1000);
					    // verify prod Text and prod Desc
					    driverMethod.verifyEqual(driverMethod.getText(FbContent, unclickFb), newlist);
					    // verify prod Img (?)
					    driverMethod.click(FbContent, postFb);
					    Thread.sleep(5*1000);
					}
				}
		} catch (AssertionError e) {
			throw e;
		}
		finally {
			if(driverMethod.getWindowHandles().size() > 1) {
				driverMethod.close();
			}
			driverMethod.switchHandle(handle);
		}
	}
	
	public void verifyPostOnFacebook(String username, String pass) throws Exception{
		String titleExpect = driverMethod.getTitle();
		List<String> ls = getProdAndDescTxt();
		String domain = getDomainFromURL();
		ls.add(domain);
		String newlist = ls.toString().replace("[", "").replace("]", "");
		newlist = newlist.replace(", ", "\n");
		String fbUrl = "window.open('https://facebook.com/','_blank')";
		driverMethod.executeJavascript(fbUrl);
	    Thread.sleep(5*1000);
		ArrayList<String> tabs2 = new ArrayList<String>(driverMethod.getWindowHandles());
		driverMethod.switchHandle(tabs2.get(1));
		if (driverMethod.getTitle().contains("Facebook")){
			boolean check = driverMethod.verifyElementDisplayed(FirstFeed, firstFeedFb);
			if(!check){
			    driverMethod.inputText(UsrFb, usrFb, username);
			    driverMethod.inputText(PassFb, passFb, pass);
			    driverMethod.click(LoginFb, loginFb);
			    Thread.sleep(5000);
			}
		    // verify prod Text and prod Desc
		    driverMethod.verifyEqual(driverMethod.getText(FirstFeed, firstFeedFb),newlist);
		    driverMethod.click(FirstFeed, firstFeedFb);
		    Thread.sleep(5*1000);
		    ArrayList<String> tabs3 = new ArrayList<String>(driverMethod.getWindowHandles());
			driverMethod.switchHandle(tabs3.get(2));
		    driverMethod.verifyEqual(driverMethod.getTitle(), titleExpect);
		    driverMethod.close();
		    driverMethod.switchHandle(tabs3.get(1));
		}
		driverMethod.close();
		driverMethod.switchHandle(tabs2.get(0));
	}
	
	public List<String> getProdAndDescTxt() throws Exception{
		String descTxt = getDescTxt();
		String productText = getProdTxt();
		if(descTxt == " "){
			descTxt = "We use cookies to ensure that we give you the best experience on our website. "
					+ "If you continue without changing your settings we’ll assume that you are happy to receive all cookies on the Apollo website.";
		}
		List<String> ls = new ArrayList<String>();
		ls.add(productText);
		ls.add(descTxt);
		return ls;
	}
	
	private String getProdTxt() throws Exception{
		String productText = driverMethod.getText(ProductTextElement, prodTxt);
		return productText;
	}
	
	private String getDescTxt() throws Exception{
		String descTxt = driverMethod.getText(DescTxt, descriptionTxt);
		return descTxt;
	}
	
	public void shareViaTwitter(String username, String pass) throws Exception{
		String url = driverMethod.getUrl();
		String handle = driverMethod.getWindowHandle();
		try {
			driverMethod.click(BtnTwt, twitterBtn);		
			Thread.sleep(5*1000);
			// Switch to new window opened
			for (String winHandle : driverMethod.getWindowHandles()){
					driverMethod.switchHandle(winHandle);
					driverMethod.getDriver().manage().window().maximize();
					if (driverMethod.getTitle().contains("Twitter")){
						driverMethod.verifyEqual(url, driverMethod.getText(FbContent, sttTwitter));
					    driverMethod.inputText(UsrFb, usrTwitter, username);
					    driverMethod.inputText(PassFb, pwdTwitter, pass);
					    driverMethod.click(LoginFb, loginFb);
					    Thread.sleep(1000);
					    driverMethod.click(LoginFb, loginFb);
					}
				}
		} catch (AssertionError e) {
			throw e;
		}
		finally {
			if(driverMethod.getWindowHandles().size() > 1) {
				driverMethod.close();
			}
			driverMethod.switchHandle(handle);
		}
	}
	
	public void shareViaEmail(String email) throws Exception{
		driverMethod.click(BtnEmail, emailBtn);	
		try {
			// Switch to new window opened
			for (String winHandle : driverMethod.getWindowHandles()){
				driverMethod.switchHandle(winHandle);
				if (driverMethod.isElementPresent(h3Email)){
					driverMethod.inputText(EmailInput, inputEmail, email);
					driverMethod.click(SendEmail, sendEmailBtn);
					Thread.sleep(1000);
					boolean isDisplayed = driverMethod.verifyElementDisplayed(EmailInput, successEmail);
					if(!isDisplayed)
						throw new Exception("Element is not displayed!");
				}
			}
		}
		finally {
			driverMethod.click(CloseEmail, closeEmail);
		}
	}
	
	public void showShareIcon() throws Exception{
		driverMethod.click(XBtn, closeShare);
		driverMethod.verifyElementDisplayed(BtnShare, shareBtn);
	}
	
	public void dragToTheEnd() throws Exception{
		driverMethod.scrollIntoView(YtbBtn, ytbShare);
		driverMethod.isElementPresent(aBackToTop);
		driverMethod.isElementPresent(specifyTab);
	}
	
	public void backToTop() throws Exception{
		driverMethod.scrollIntoView(YtbBtn, ytbShare);
		driverMethod.verifyElementDisplayed(YtbBtn, ytbShare);
		if(!driverMethod.isElementPresent(PVPage.carSuvVanPageIcon)){
			driverMethod.click(BackToTop, aBackToTop);
			driverMethod.isElementPresent(PVPage.carSuvVanPageIcon);
		}
	}
	
	public void goToFeaturePart() throws Exception{
		driverMethod.scrollIntoView(YtbBtn, ytbShare);
		if(driverMethod.isElementPresent(featureTab)){
			driverMethod.click(Features, featureTab);
			driverMethod.verifyElementDisplayed(Benefits, benefitTxt);
		}
	}
	
	public void goToSpecPart() throws Exception{
		driverMethod.scrollIntoView(YtbBtn, ytbShare);
		if(driverMethod.isElementPresent(specifyTab)){
			driverMethod.click(SpecifyTab, specifyTab);
			driverMethod.verifyElementDisplayed(OptionDDL, filterDDL);
		}
	}
}
