package ApkInstall;

import java.net.URI;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AutomaticCalc {

    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "vivo I2403");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid", "10BE9X346H001UZ");
        capabilities.setCapability("platformVersion", "15");

        // Calculator package & activity
        capabilities.setCapability("appPackage", "com.vivo.calculator");
        capabilities.setCapability("appActivity", "com.android.bbkcalculator.Calculator");

        capabilities.setCapability("noReset", true);
        capabilities.setCapability("newCommandTimeout", 300);

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

        AndroidDriver driver = new AndroidDriver(url, capabilities);

        Thread.sleep(5000);

        // Click 8
        driver.findElement(By.id("com.vivo.calculator:id/digit_8")).click();

        // Click +
        driver.findElement(By.id("com.vivo.calculator:id/op_add")).click();

        // Click 2
        driver.findElement(By.id("com.vivo.calculator:id/digit_2")).click();

        // Click =
        driver.findElement(By.id("com.vivo.calculator:id/eq")).click();

        Thread.sleep(2000);

        // Get result
     // Get result
        WebElement result = driver.findElement(
                AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.EditText\").resourceId(\"com.vivo.calculator:id/formula\")"
        ));
        String value = result.getText();

        System.out.println("Calculator Result = [" + value + "]");

        if(value != null && value.contains("10"))
        {
            System.out.println("Test Passed");
        }
        else
        {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}