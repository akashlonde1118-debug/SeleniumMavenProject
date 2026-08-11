package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateDialing {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "vivo I2403");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("udid", "10BE9X346H001UZ");
		capabilities.setCapability("platformVersion", "15");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.dialer.TwelveKeyDialer");
		capabilities.setCapability("newCommandTimeout", 300);

		
		URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
	
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		Thread.sleep(15000);
		
	
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"9\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"8\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"8\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"1\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"5\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"9\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"8\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"6\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"9\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"3\"]")).click();
		
		driver.findElement(By.id("com.android.contacts:id/dialButton")).click();
		
		Thread.sleep(1000);
		
		driver.quit();


	}

}
