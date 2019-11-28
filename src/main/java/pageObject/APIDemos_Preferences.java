	package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class APIDemos_Preferences {

	 public APIDemos_Preferences(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement PreferenceDependencies;
	
	@AndroidFindBy(id="android:id/checkbox/")
	public WebElement checkboxPreferences;
	
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement textboxClick;
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement textboxEntry;
	
	
	
	
	
	
}
