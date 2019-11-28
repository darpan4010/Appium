package framework.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesBase {

	public static AppiumDriverLocalService service;
	public static 	AndroidDriver<AndroidElement> driver;
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
				service = AppiumDriverLocalService.buildDefaultService();
				service.start();
			}
		return service;
	}
	
	public static void startEmulator() throws IOException
	{
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startemulator.bat");
	}
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;	
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//If control comes here that means port is already in use. 
			isServerRunning = true;
		}finally {
			serverSocket = null;
		}		
		return isServerRunning;			
	}
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\framework\\AppiumFramework\\global.properties");
		Properties props = new Properties();
		props.load(fis);

	
		File f = new File("src");
		File fs = new File(f,(String) props.get(appName));
		DesiredCapabilities caps = new DesiredCapabilities();

		//String device = (String) props.get("device");
		String device = System.getProperty("devicename");
		//Start the device on the fly
		/*if(device.contains("DARPAN"))
		{
			startEmulator();
		}*/
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		caps.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub") , caps); 
		return driver;
	}
	
	public static void takeScreenshot(String testCasename) throws IOException
	{
		File scrsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrsht, new File(System.getProperty("user.dir")+"\\"+testCasename+".png"));
		
	}
	
}
