package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LongPress {
	static AndroidDriver driver;
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
		Thread.sleep(5000);
		
	
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
		
		WebElement Backspace = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Delete\"]"));
		
		Backspace.click();
		
		Thread.sleep(2000);
		
		longpress(Backspace);
		
		Thread.sleep(2000);
		
		driver.quit();
		

	}
	
	static void longpress (WebElement el)
	{
		Point location = el.getLocation();
				
		PointerInput Finger = new PointerInput(PointerInput.Kind.TOUCH, "Finger");
		
		Sequence Longpress = new Sequence(Finger,1);
		
		Longpress.addAction(Finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), location.x , location.y));

		Longpress.addAction(Finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		Longpress.addAction(Finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), location.x, location.y));
		
		Longpress.addAction(Finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(Longpress));
	}

}
