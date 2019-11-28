package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class APIDemos_HomePage {

	//Create a constructor to call driver from APIDemoOperation class. 
	// Create an object in APIDemoOperation of HomePage class==>"homepage"
	//Create a constructor in Home page class.
	//Once APIDemoOperation is executed i.e. an object is called this constructor is called 
	// And driver is available to be used in this class scope. 
	//Use pagefactory method to initialize the driver using "initelements"
	public APIDemos_HomePage(AndroidDriver driver)
	{
		//PageFactory.initElements(driver, this);
		//You can use AppiumFieldDecorator for to work in both i.e.Compatible ios and Android as well.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;

	//Above two lines are nothing but 
	//==>findElementByXPath("//android.widget.TextView[@text='Preference']").click();


}
