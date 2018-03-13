package test.common;

import org.openqa.selenium.By;

import com.nashtech.core.web.WebDriverMethod;

public class WebCommon {

	public static void verifyElementDisplayed(String name, By by, WebDriverMethod driverMethod) throws Exception{
		if(! driverMethod.verifyElementDisplayed(name, by)) 
		{
			throw new Exception("fdgdfgfg");
		}
			
	}
}
