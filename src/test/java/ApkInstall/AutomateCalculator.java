package ApkInstall;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalculator {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "vivo I2403");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("udid", "10BE9X346H001UZ");
		capabilities.setCapability("platformVersion", "15");
		capabilities.setCapability("appPackage", "com.vivo.calculator");
		capabilities.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
		capabilities.setCapability("newCommandTimeout", 300);

		
		URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
	
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		Thread.sleep(5000);
	WebElement Num8 = driver.findElement(By.id("com.vivo.calculator:id/digit_8"));
		//WebElement Num8 = driver.findElement(By.xpath("//*[@content-desc='8']"));
		Num8.click();
		Thread.sleep(5000);
		String Eight = driver.findElement(By.id("com.vivo.calculator:id/formula")).getText();
		System.out.println("Number"+ Eight);
	driver.findElement(By.id("com.vivo.calculator:id/op_add")).click();
	
	driver.findElement(By.id("com.vivo.calculator:id/digit_2")).click();

	driver.findElement(By.id("com.vivo.calculator:id/eq")).click();
	Thread.sleep(5000);
	//String result = driver.findElement(By.id("com.vivo.calculator:id/result")).getText();
	//String stringvalue = result.getAttribute("content-desc");
	//String ResultString = result.getText();
	//int num = Integer.parseInt(stringvalue);
	 //WebElement Result = driver.findElement(By.id("com.vivo.calculator:id/result"));
	 //String value1 = Result.getText();
     //String resultValue = Result.getAttribute("content-desc");
     
	//WebElement result = driver.findElement(By.id("com.vivo.caresultlculator:id/result"));
	WebElement result =driver.findElements(By.id("com.vivo.caresultlculator:id/result")).get(1);
	String value = result.getText();
	//System.out.println("Text = " + result.getText());
	//String value = System.out.println("Content-desc = " + result.getAttribute("text"));
	//System.out.println("Value = " + result.getAttribute("value"));
	//System.out.println("Name = " + result.getAttribute("name"));
	//String value = result.getAttribute("content-desc");
	int num = Integer.parseInt(value);
     //System.out.println("Calculator Result = " + value1);
     
	System.out.println("Result = " + num);
	
	/*if(ResultString.contains("10"))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
	
	driver.quit();*/

	}

}
