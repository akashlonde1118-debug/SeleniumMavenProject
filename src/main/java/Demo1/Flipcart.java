package Demo1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flipcart {

	public static void main(String[] args) throws InterruptedException
	{
	
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='b3wTlE']")).click();
		
		WebElement search = driver.findElement(By.xpath("(//input[@class='nw1UBF v1zwn25'])[1]"));
		
		search.click();
		search.sendKeys("Mobile");
		search.sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement Electronics = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Electronics']")));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(Electronics);
	    action.pause(Duration.ofSeconds(2));
	    action.perform();

		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("//a[@title='Apple']")).isDisplayed());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Mobiles']")));
		
		List<WebElement> MobileBrands = driver.findElements(By.xpath("//a[@title='Mobiles']/following-sibling::a"));
		
		System.out.println("Mobile Brands");
		
		System.out.println(MobileBrands.size());
		
		for(WebElement AllBrands : MobileBrands)
		{
			System.out.println(AllBrands.getText());
		}
		
		System.out.println("--------------------------");
		
		WebElement Men = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Men']")));
		
		action.moveToElement(Men);
		action.pause(Duration.ofSeconds(3));
		action.perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Footwear']")));
		
		List<WebElement> ShoeType = driver.findElements(By.xpath("//a[@title='Footwear']/following-sibling::a[contains(@href,'/mens-footwear')]"));
		
		//List<WebElement> ShoeType = driver.findElements(By.xpath("//div[a[@title='Footwear']]/a[position()>1]"));
		
		System.out.println("Shoes");
		
		for(WebElement Footwear : ShoeType)
		{
			System.out.println(Footwear.getText());
		}
		
		
		driver.quit();
	}

}
