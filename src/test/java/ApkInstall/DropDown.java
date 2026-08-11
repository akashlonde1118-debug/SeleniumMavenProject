package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DropDown {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "vivo I2403");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("udid", "10BE9X346H001UZ");
		capabilities.setCapability("platformVersion", "15");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		capabilities.setCapability("newCommandTimeout", 300);

		
		URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
	
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		Thread.sleep(5000);
		
		driver.findElements(By.id("android:id/text1")).get(11).click();
		
		driver.findElements(By.id("android:id/text1")).get(4).click();
		
		driver.findElements(By.id("android:id/text1")).get(0).click();
		
		WebElement DropDown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
		
		DropDown.click();
		
		WebElement Jupiter = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Jupiter\"]"));
		
		Jupiter.click();
		
		driver.quit();
		
	

	}

}
