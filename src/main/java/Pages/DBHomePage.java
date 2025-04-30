package Pages;

import Base.DBProjectSpecifications;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class DBHomePage extends DBProjectSpecifications {

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    WebElement register;
    @FindBy(xpath = "//*[@id=\"login2\"]")
    WebElement login;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a")
    WebElement Phones;

    private static final String SCREENSHOT_FOLDER = "C:\\Users\\HOSUR PS\\IdeaProjects\\Project1\\DBSnaps\\";
    public String TestName;
    private String ActualUsername;


    public DBHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public DBRegisterPage DBRegisterClick() {
        driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
        return new DBRegisterPage(driver);
    }

    public DBLoginPage DBLoginClick() {
        if (driver == null) {
            System.out.println("Driver is null, cannot perform login action.");
            return null;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login2\"]")));
        element.click();
        return new DBLoginPage(driver);
    }

    public DBProductPage DBProductPageClick() {
        //Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a"))).click(); // Ensure click action
        return new DBProductPage(driver);
    }

    public DBOrderConfirmationPage DBOrderConfirmationPageClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='name']")));
        return new DBOrderConfirmationPage(driver);
    }

    public DBHomePage DBLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='logout2']")));
        element.click();
        return this;
    }

    public DBLoginPage DBinvalidLoginClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login2\"]")));
        element.click();

        WebElement Username = driver.findElement(By.xpath("//*[@id=\"loginusername\"]"));

        String ExpectedUsername = "Ravi992";
        DBVisibilityofElement(Username);
        String ActualUsername = Username.getText();
        System.out.println(ActualUsername);
        if (ExpectedUsername==ActualUsername) {
            System.out.println("Login is Successfull");
        } else {System.out.println("Login is Unsuccessfull");
        }
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Ensure folder exists
            File folder = new File(SCREENSHOT_FOLDER);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = SCREENSHOT_FOLDER + TestName + "_" + timestamp + ".png";

            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("Screenshot saved successfully: " + filePath);

            //return filePath; // Returns the saved path for reference
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
            e.printStackTrace(); // Helps debug any issues
        }
        return new DBLoginPage(driver);

    }
}


