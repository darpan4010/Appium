package framework.AppiumFramework;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObject.GeneralStore_Productspage;
import utilities.Utilities;
import pageObject.GeneralStore_Cartpage;
import pageObject.GeneralStore_FormPage;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
public class Ecommerce_TC_2 extends CapabilitiesBase {

	/*@BeforeTest
	public void killallProcess() throws IOException
	{
		//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("");

	}*/

	@Test
	public void completeValidation() throws InterruptedException, IOException
	{
		service = startServer();
		System.out.println("Server Started");
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		System.out.println("Here");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GeneralStore_FormPage fp = new GeneralStore_FormPage(driver);
		//Enter the name in name field. 
		fp.getNamefield().sendKeys("Darpan");

		driver.hideKeyboard();
		//Click on the dropdown
		//driver.findElementById("android:id/text1").click();
		fp.dropdownElement.click();

		// to intitialize the constructor in utilities class. 
		Utilities u = new  Utilities(driver);
		//Scroll till Argentina text is visible.
		u.scrolltotextMethod("Argentina");		 


		//Click on Argentina
		if(fp.selectCounrty.isDisplayed())
		{
			System.out.println("True");
		}

		fp.selectCounrty.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Click on  gender checkbox(M/F).
		fp.checkboxGender.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Click on Let's shop button
		fp.buttonLetsshop.click();

		GeneralStore_Productspage pic = new GeneralStore_Productspage(driver);
		//Add two products in cart
		int countofProducts = pic.producttobeSelected.size();
		System.out.println(countofProducts);

		for(int i=0;i<countofProducts;i++)
		{
			String productText = pic.producttobeSelected.get(i).getText();
			System.out.println("Text of "+i+"th"+" Product is :->"  +productText);
			if(productText.equalsIgnoreCase("ADD TO CART"))
			{
				pic.producttobeSelected.get(i).click();

			}

		}
		pic.gotoCart.click();

		GeneralStore_Cartpage gscp = new GeneralStore_Cartpage(driver);
		// Take price for both the products.
		int countofProductscost = gscp.productPrice.size();
		System.out.println(countofProductscost);
		double sum = 0;
		for(int i=0;i<countofProductscost;i++)
		{
			String productCost1 = gscp.productPrice.get(i).getText();
			productCost1 = productCost1.substring(1);
			System.out.println(productCost1);
			double productCost11 = Double.parseDouble(productCost1);
			System.out.println(productCost1);
			sum =sum + productCost11;
		}

		System.out.println("Sum of two products is :-> $"+sum);

		String actualValue = gscp.totalPurchaseAmount.getText();
		actualValue = actualValue.substring(1);
		double actualValue1 = Double.parseDouble(actualValue);
		System.out.println("Actual value is :- "+actualValue1);
		Assert.assertEquals(sum, actualValue1);

		//Tap on the checkbox...OR just simple click will also work.
		WebElement chbxElement = gscp.termsCheckbox;
		TouchAction tactn = new TouchAction(driver) ;
		tactn.tap(tapOptions().withElement(element(chbxElement))).perform();


		//Long Press
		WebElement condElement =   gscp.termsLongpress;
		tactn.longPress(longPressOptions().withElement(element(condElement)).withDuration(ofSeconds(10))).perform();

		//Click on Close button
		gscp.closeButton.click();

		//Click on visit to website to complete purchase. 
		gscp.proceedButton.click();

		//For switching from Native to Webview use context swtching specified by appium docs. 
		Thread.sleep(8000);
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Set<String> contextSets = driver.getContextHandles();
		for(String contextNames : contextSets)
		{

			System.out.println((contextNames));
		}
		/*driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Hello");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
		driver.context("NATIVE_APP");*/
		service.stop();
//		System.out.println("Server Stopped");
	}

}
