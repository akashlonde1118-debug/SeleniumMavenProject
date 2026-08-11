package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDrop {

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
		
		driver.findElements(By.id("android:id/text1")).get(7).click();
		
		WebElement Source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		WebElement Destination = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		
		TouchAction Action = new TouchAction(driver);
		
		//Action.longPress(LongPressOptions().withElement(Source))).m)
		//Action.longPress(LongPressOptions().withElement(Source))
		Action.longPress(LongPressOptions.longPressOptions().withElement(element(Source))).moveTo(element(Destination)).release().perform();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
