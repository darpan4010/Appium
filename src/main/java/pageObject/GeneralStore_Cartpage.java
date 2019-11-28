package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStore_Cartpage {

	 public GeneralStore_Cartpage(AndroidDriver driver) {
			// TODO Auto-generated constructor stub
			
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	 		 					   
	 	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
		public List<WebElement> productPrice;

	 	
	 	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
		public WebElement totalPurchaseAmount;

	 	
	 	@AndroidFindBy(className="android.widget.CheckBox")
		public WebElement termsCheckbox;

	 	@AndroidFindBy(xpath="//*[@text='Please read our terms of conditions']")
		public WebElement termsLongpress;
	 	
	 	@AndroidFindBy(id="android:id/button1")
		public WebElement closeButton;

	 	
	 	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
		public WebElement proceedButton;
	 	
}



