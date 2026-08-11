package Demo1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class windowhandle {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://irctc.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@class='active']")).click();
		//driver.findElement(By.linkText("Login"));
		
		Thread.sleep(10000);
		
		String parentWindow = driver.getWindowHandle();
		
		WebElement Login = driver.findElement(By.xpath("(//a[@class='login-btn'])[1]"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(Login).perform();
		
		driver.findElement(By.linkText("Employee Login")).click();
		
		Thread.sleep(5000);
		
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window);
		        break;
		    }
		}
		
		WebElement username = driver.findElement(By.xpath("//input[@id='userName']"));
		
		username.click();
		
		username.sendKeys("akashlonde822");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		
		password.click();
		
		password.sendKeys("Akaishu@9881");
		
		
	}

}
