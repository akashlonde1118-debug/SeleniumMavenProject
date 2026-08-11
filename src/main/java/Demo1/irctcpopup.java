package Demo1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class irctcpopup {

	public static void main(String[] args) throws InterruptedException 
	{
			//-----Open Browser-----
		WebDriver driver = new ChromeDriver();
		
			//-----Open Website-----
		driver.get("https://www.irctc.co.in/nget/train-search");
		
			//-----Maximize the window-----
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		driver.findElement(By.xpath("//a[text()=' LOGIN / REGISTER ']")).click();
		
			//-----find username path-----
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='User Name']"));
		
		username.click();
		
		username.sendKeys("akashlonde822");
		
			//-----find password path-----
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		
		password.click();
		
		password.sendKeys("Akaishu@9881");
		
			//-----click on login/submit-----
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
			//-----suggestion dropdown from-----
		WebElement from = driver.findElement(By.xpath("//input[@aria-label='Enter From station. Input is Mandatory.']"));
		
		from.click();
			//-----suggestion box clear text and send the input-----
		from.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		from.sendKeys(Keys.DELETE);
		from.sendKeys("Thane");
		
		Thread.sleep(5000);
		
			//-----after send "from" input dropdown will open then get all text in dropdown-----
		List<WebElement> fromlist = driver.findElements(By.xpath("//li[@role='option']"));
		
		for(WebElement station : fromlist)
		{
			System.out.println(station.getText());
			if(station.getText().contains("THANE - TNA"))
			{
				station.click();
				break;
			}
		}
		
		Thread.sleep(5000);
			
		//-----after send "to" input dropdown will open then get all text in dropdown-----		
		WebElement to = driver.findElement(By.xpath("//input[@aria-label='Enter To station. Input is Mandatory.']"));
		
		to.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		to.sendKeys(Keys.DELETE);
		to.sendKeys("Amravati");
		
		Thread.sleep(5000);
		
		//-----select dropdown text-----
		driver.findElement(By.xpath("//span[text()=' AMRAVATI - AMI ']")).click();
		
		/*List<WebElement> tolist = driver.findElements(By.xpath("//ul[@role='listbox']"));
		
		for(WebElement station : tolist)
		{
			System.out.println(station.getText());
			if(station.getText().equals("AMRAVATI - AMI (AMARAVATI)"))
			{
				station.click();
				break;
			}
		}*/
		
		
		WebElement date = driver.findElement(By.xpath("//p-calendar[@dateformat='dd/mm/yy']"));
		
		date.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='21']")).click();
		
		WebElement Class = driver.findElement(By.xpath("//span[text()='All Classes']"));
		
		Class.click();
		
		Thread.sleep(2000);
		
		//Class.sendKeys("s");
		
		driver.findElement(By.xpath("//span[text()='Sleeper (SL)']")).click();
		
		driver.findElement(By.xpath("//span[text()='GENERAL']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='TATKAL']")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		
	}

}
