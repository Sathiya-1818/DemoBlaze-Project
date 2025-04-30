package Pages;

import Base.DBProjectSpecifications;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DBOrderConfirmationPage extends DBProjectSpecifications {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//*[@id=\"name\"]")
    WebElement Name;

    public DBOrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public DBOrderConfirmationPage OCVisibilityOfElement() throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[1]/label"));
        return this;
    }

    public DBOrderConfirmationPage OCName() throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Akilesh");
        return this;
    }

    public DBOrderConfirmationPage Country() {
        driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("India");
        return this;
    }

    public DBOrderConfirmationPage City() {
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Salem");
        return this;
    }

    public DBOrderConfirmationPage CreditCard() {
       driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("Visa");;
        return this;
    }

    public DBOrderConfirmationPage Month() {
        driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("October");
        return this;
    }

    public DBOrderConfirmationPage Year() {
        driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2030");
        return this;
    }

    public DBOrderConfirmationPage purchase() {
        driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
        return this;
    }

    public DBOrderConfirmationPage OCOrderOK() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new DBOrderConfirmationPage(driver);
    }
    public DBOrderConfirmationPage OCLogout() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[6]/a")).click();
        return new DBHomePage(driver).DBOrderConfirmationPageClick();
    }

}
