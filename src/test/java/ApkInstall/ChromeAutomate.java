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

public class ChromeAutomate {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "vivo I2403");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("automationName", "uiautomator2");

		capabilities.setCapability("udid", "10BE9X346H001UZ");

		capabilities.setCapability("platformVersion", "15");

		capabilities.setCapability("browserName", "Chrome");

		//capabilities.setCapability("chromedriverAutodownload", true);

		capabilities.setCapability("chromedriverExecutable","C:\\chromedriver\\chromedriver.exe");
				
		URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
			
		WebDriver driver = new AndroidDriver(url,capabilities);
		
		Thread.sleep(5000);

		driver.get("https://www.google.com/");
		
		WebElement input = driver.findElement(By.name("q"));
		
		input.sendKeys("Taj Mahal");
		
		input.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);	
		
		driver.quit();



	}

}
