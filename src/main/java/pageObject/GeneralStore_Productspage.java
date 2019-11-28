package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStore_Productspage {

	 public GeneralStore_Productspage(AndroidDriver driver) {
			// TODO Auto-generated constructor stub
			
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	 		 					   
	 	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
		public List<WebElement> producttobeSelected;

	 	
	 	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		public WebElement gotoCart;

	 	
	 	
	 	
}

//

