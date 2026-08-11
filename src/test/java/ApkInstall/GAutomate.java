package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GAutomate {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "vivo I2403");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("automationName", "uiautomator2");

		capabilities.setCapability("udid", "10BE9X346H001UZ");

		capabilities.setCapability("platformVersion", "15");

		//capabilities.setCapability("browserName", "Chrome");

		//capabilities.setCapability("chromedriverAutodownload", true);

		capabilities.setCapability("appActivity","com.google.android.googlequicksearchbox.SearchActivity");
		capabilities.setCapability("appPackage", "com.google.android.googlequicksearchbox");
		
		URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
			
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.googlequicksearchbox:id/googleapp_discover_recycler_view\"]/android.widget.FrameLayout")).click();
		Thread.sleep(5000);
	WebElement Text =driver.findElement(By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box"));
	//Text.click();
	Thread.sleep(3000);
	Text.sendKeys("dresses");
	
	
	//WebElement text = driver.findElement(By.id("com.google.android.googlequicksearchbox:id/search_box"));text.sendKeys("Tajmahal\n");

	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	
		


	}

}
