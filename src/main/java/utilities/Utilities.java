package utilities;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {

	@SuppressWarnings("rawtypes")
	AndroidDriver driver;
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
	}
		
	public void scrolltotextMethod(String scrolledtillText)
	{
		//Scroll till Argentina text is visible. 
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+scrolledtillText+"\"));");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                
	}
}
