package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test1 {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "vivo I2403");
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability("automationName", "uiautomator2"); capabilities.setCapability("app", "C:\\Users\\HP\\Downloads\\Google_17.8.62.ve.arm64_apkcombo.com.apk");
		capabilities. setCapability(" app", "C:\\Users\\HP\\Downloads\\Google_17.8.62.ve.arm64_apkcombo.com.apk");
		capabilities. setCapability(" udid", "10BE9X346H001UZ");
		capabilities. setCapability(" platformVersion", "15");
		
		
		URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		//Object  AndroidDriver;
	
 AndroidDriver driver = new AndroidDriver(url,capabilities);
 
 //driver.quit();
 System.out.println("Hii Akash");
	}

}
 