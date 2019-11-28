package framework.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.APIDemos_Dependencies;
import pageObject.APIDemos_HomePage;
import pageObject.APIDemos_Preferences;

public class APIDemosOperation extends CapabilitiesBase {

	@Test
	public void apiDemosCompleteValidation() throws IOException, InterruptedException
	{
		
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
		
		APIDemos_HomePage homepage = new APIDemos_HomePage(driver);
		homepage.Preferences.click();Thread.sleep(10);
		
		APIDemos_Preferences preferences = new APIDemos_Preferences(driver);
		preferences.PreferenceDependencies.click();Thread.sleep(10);
		preferences.checkboxPreferences.click();Thread.sleep(10);
		preferences.textboxEntry.click();Thread.sleep(10);
		preferences.textboxEntry.sendKeys("Hello");Thread.sleep(10);
		
	}
	
	
	
}
