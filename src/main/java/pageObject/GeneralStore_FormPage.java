package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStore_FormPage {

	 public GeneralStore_FormPage(AndroidDriver driver) {
			// TODO Auto-generated constructor stub
			
//			 PageFactory.initElements(driver, this);
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	 	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
		private WebElement nameField;
	 	 	
	 	@AndroidFindBy(id="android:id/text1")
		public WebElement dropdownElement;
	 	
	 	
	 	@AndroidFindBy(xpath="//*[@text='Argentina']")
		public WebElement selectCounrty;
	 	
	 	
	 	@AndroidFindBy(xpath="//*[@text='Female']")
		public WebElement checkboxGender;
	 	
	 	
	 	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
		public WebElement buttonLetsshop;
	 					   
	 	
	 	
	 	public WebElement getNamefield()
	 	{
	 		return nameField;
	 	}
	 	
}



