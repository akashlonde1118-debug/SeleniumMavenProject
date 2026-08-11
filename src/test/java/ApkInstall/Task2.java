package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Task2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "vivo I2403");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("automationName", "uiautomator2");

		capabilities.setCapability("udid", "10BE9X346H001UZ");

		capabilities.setCapability("platformVersion", "15");

		capabilities.setCapability("appActivity","com.google.android.googlequicksearchbox.SearchActivity");
		capabilities.setCapability("appPackage", "com.google.android.googlequicksearchbox");
		
		URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
			
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.googlequicksearchbox:id/googleapp_discover_recycler_view\"]/android.widget.FrameLayout")).click();
		
		Thread.sleep(5000);
		WebElement Text =driver.findElement(By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box"));

		Text.sendKeys("headfones");
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().textContains(\"Popular products\"))"));
		
		WebElement products = driver.findElement(By.xpath("//android.view.View[@text=\"boAt Rockerz 421 Bluetooth Headphones. Current price: ₹1,199. 52% off maximum retail price: ₹2,490. boAt & more. Free delivery. Rated 4.1 out of 5. 8 reviews. \"]"));
                
        String ProductTitle = products.getText();

        System.out.println("Second Product Title:" + ProductTitle);
        
       String ProductName =  ProductTitle.split(". Current price")[0].trim();
        
        System.out.println("Second Product before click:" + ProductName);
        
        products.click();
        
    	Thread.sleep(3000);
        
       WebElement DetailsTitle = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'boAt')]"));
       
        String detailText = DetailsTitle.getText();
        
        System.out.println("Second Product After click:" + detailText);
        
        Assert.assertTrue(detailText.contains(ProductName));
        
        System.out.println("Assertion Passed ProductName Match");
        
        driver.quit();
        
       
        
        
		
	}

}
