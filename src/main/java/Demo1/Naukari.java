package Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Naukari {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");
		
		driver.manage().window().maximize();
		
		Thread.sleep(500);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='usernameField']"));
		
		username.click();
		
		username.sendKeys("akashlonde1118@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='passwordField']"));
		
		password.click();
		
		password.sendKeys("Akaishu@1118");
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		
	
}

}
