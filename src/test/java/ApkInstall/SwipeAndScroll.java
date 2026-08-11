package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SwipeAndScroll {

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
		
		Dimension size = driver.manage().window().getSize();
		
		int startX = size.getWidth()/2;
		int startY = size.getHeight()/2;
		
		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);
		
		PointerInput Finger1 = new PointerInput(PointerInput.Kind.TOUCH,"Finger1");
		
		Sequence sequence = new Sequence(Finger1,1);
		
		sequence.addAction(Finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		
		sequence.addAction(Finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		sequence.addAction(new Pause(Finger1,Duration.ofMillis(200)));
		
		sequence.addAction(Finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY));
		
		sequence.addAction(Finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(sequence));
		
		Thread.sleep(500);
		driver.quit();

	}

}
