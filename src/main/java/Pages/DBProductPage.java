package Pages;

import Base.DBProjectSpecifications;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DBProductPage extends DBProjectSpecifications {

    @FindBy(xpath="//*[@id=\"cat\"]")
    private WebDriverWait wait;
    private WebElement ProductName;


    public DBProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public DBProductPage PPVisibilityOfElement() {
        //Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a"))).click(); // Ensure click action
        return this;
    }


    public DBProductPage PPProductClick() throws InterruptedException {
        Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a"))).click(); // Ensure click action
        return this;
    }

    public DBProductPage PPAddProduct() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        element.click();
        return this;
    }

    public DBProductPage PPOrderconfirmok()
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public DBProductPage PPGoToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartur\"]"))).click();
        return this;
    }

    public boolean InCartVerifyProduct() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")));
        System.out.println("Product Name: " + ProductName.getText());
        return this.InCartVerifyProduct();
    }

    public DBProductPage OrderCheckOut() {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(25));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")));
        element.click();
        return this;
    }


}
