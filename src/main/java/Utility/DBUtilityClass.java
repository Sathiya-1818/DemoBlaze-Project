package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.Date;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class DBUtilityClass {
    public static WebDriver driver;
    private static final String SCREENSHOT_FOLDER = "C:\\Users\\HOSUR PS\\IdeaProjects\\Project1\\DBSnaps\\";
    //public static ExtentReports Report;
    public static ExtentTest Test;
    public static ExtentReports Extent = new ExtentReports();

    public String TestName, TestDescription, TestCategory, TestAuthor;

    @BeforeTest
    public void DBbrowserLaunch() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterTest
    public void DBcloseBrowser(){
        driver.quit();
    }

    public void DBVisibilityofElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String captureScreenshot(String testName) {

        if (driver == null) {
            System.out.println("Driver is closed or not initialized—unable to capture screenshot.");
            return null;
        }

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Ensure folder exists
            File folder = new File(SCREENSHOT_FOLDER);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = SCREENSHOT_FOLDER + testName + "_" + timestamp + ".png";

            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("Screenshot saved successfully: " + filePath);

            return filePath; // Returns the saved path for reference
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
            e.printStackTrace(); // Helps debug any issues
        }
        return null;
    }
}


