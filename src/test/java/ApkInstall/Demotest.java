package ApkInstall;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demotest {

    static String DOWNLOAD_FOLDER = "C:\\Users\\HP\\Downloads";
    static String SPREADSHEET_ID = "13wsC-6dbJSUbfd2ADPiiYbR6oEN4Ss5dVT9NRt6TE5M";

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://seller.ajio.com/ajiocommerce/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Login
        driver.findElement(By.id("ui-btn")).click();
        driver.findElement(By.id("Username / Email ID*")).sendKeys("marketplace@strch.in");
        driver.findElement(By.id("Password*")).sendKeys("Strch@12345");
        driver.findElement(By.xpath("//*[@id='ui-form']/button")).click();

        Thread.sleep(5000);

        // Open Reporting
        driver.findElement(By.xpath("//*[contains(text(),'Reporting')]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/ul/div[6]/div/div/div/a[1]/div[2]/span")).click();

        Thread.sleep(4000);

        // Currency selection
        driver.findElement(By.id("standard-select-currency")).click();
        driver.findElement(By.xpath("//*[@id='mui-18']/li[3]")).click();

        // Date selection
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.withDayOfMonth(1);
        LocalDate endDate = today.minusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        WebElement startField = driver.findElement(By.xpath("(//input[@type='date'])[1]"));
        startField.clear();
        startField.sendKeys(startDate.format(formatter));

        WebElement endField = driver.findElement(By.xpath("(//input[@type='date'])[2]"));
        endField.clear();
        endField.sendKeys(endDate.format(formatter));

        driver.findElement(By.xpath("//*[@id='root']/div/main/div[2]/form/div[2]/div/button")).click();

        Thread.sleep(3000);

        // Download report
        driver.findElement(By.xpath("//*[@id='root']/div/main/div[3]/div[1]/button")).click();

        System.out.println("Waiting for download...");

        Thread.sleep(8000);

        // Get latest downloaded file
        File latestFile = getLatestFile(DOWNLOAD_FOLDER);
        System.out.println("Downloaded file: " + latestFile.getName());

        // Read Excel
        List<List<Object>> data = readExcel(latestFile.getAbsolutePath());

        // Upload to Google Sheet
        Sheets service = getSheetsService();

        ValueRange body = new ValueRange().setValues(data);

        service.spreadsheets().values()
                .update(SPREADSHEET_ID, "Sheet1!A1", body)
                .setValueInputOption("RAW")
                .execute();

        System.out.println("Data uploaded successfully to Google Sheet");

        driver.quit();
    }

    // Find latest downloaded file
    public static File getLatestFile(String folderPath) {

        File dir = new File(folderPath);
        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            throw new RuntimeException("No downloaded files found");
        }

        File latest = files[0];

        for (File file : files) {
            if (file.lastModified() > latest.lastModified()) {
                latest = file;
            }
        }

        return latest;
    }

    // Read Excel file
    public static List<List<Object>> readExcel(String filePath) throws Exception {

        List<List<Object>> data = new ArrayList<>();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {

            List<Object> rowData = new ArrayList<>();

            for (Cell cell : row) {
            	CellType type = cell.getCellType();

                switch (cell.getCellType()) {

                    case STRING:
                        rowData.add(cell.getStringCellValue());
                        break;

                    case NUMERIC:
                        rowData.add(cell.getNumericCellValue());
                        break;

                    case BOOLEAN:
                        rowData.add(cell.getBooleanCellValue());
                        break;

                    default:
                        rowData.add("");
                }
            }

            data.add(rowData);
        }

        workbook.close();
        fis.close();

        return data;
    }

    // Connect Google Sheets
    public static Sheets getSheetsService() throws Exception {

        HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();

        GoogleCredential credential = GoogleCredential
                .fromStream(new FileInputStream("credentials.json"))
                .createScoped(Collections.singleton("https://www.googleapis.com/auth/spreadsheets"));

        return new Sheets.Builder(transport, GsonFactory.getDefaultInstance(), credential)
                .setApplicationName("Selenium Automation")
                .build();
    }
}