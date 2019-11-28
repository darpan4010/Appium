package framework.AppiumFramework;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class SwipeDemo extends CapabilitiesBase {

@Test
public void swipeDemo() throws IOException {
	
	service = startServer();
	System.out.println("Server Started");
	AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
	driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
	driver.findElementByXPath("//*[@content-desc='9']").click();

	
	WebElement element15 = driver.findElementByXPath("//*[@content-desc='15']");
	WebElement element45 = driver.findElementByXPath("//*[@content-desc='45']");
	
	TouchAction t = new TouchAction(driver);
	t.longPress(longPressOptions().withElement(element(element15)).withDuration(ofSeconds(2))).moveTo(element(element45)).release().perform();
	service.stop();
	System.out.println("Server Stopped");
}

}
