package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DragandDropW3CAction {

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
		
		Point sourceElementCenter = getCenter(Source);
		
		Point DestinationElementCenter = getCenter(Destination);
		
		PointerInput Finger1 = new PointerInput(PointerInput.Kind.TOUCH,"Finger1");
		
		Sequence sequence = new Sequence(Finger1,1);
		
		sequence.addAction(Finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter));
		
		sequence.addAction(Finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		sequence.addAction(new Pause(Finger1, Duration.ofMillis(500)));
		
		sequence.addAction(Finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), DestinationElementCenter));
		
		sequence.addAction(Finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(sequence));
		
		Thread.sleep(2000); 
	}

	private static Point getCenter(WebElement element) {
		
		Point location = element.getLocation();
		Dimension size = element.getSize();
		
		Point center = new Point(location.x + size.width/2 , location.y + size.height/2);
		
		return center;
	}

}
