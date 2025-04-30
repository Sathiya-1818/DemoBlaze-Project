package Pages;

import Base.DBProjectSpecifications;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DBLoginPage extends DBProjectSpecifications {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "/html/body/nav/div[1]/ul/li[5]/a")
    WebElement login2;

    public DBLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public DBLoginPage DBUsername(String name) throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("Sri007");
        return this;
    }

    public DBLoginPage DBPassword(String password) {
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("star007");
        return this;
    }

    public DBProductPage DBLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        return new DBProductPage(driver);
    }


}
