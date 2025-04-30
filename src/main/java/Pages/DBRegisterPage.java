package Pages;

import Base.DBProjectSpecifications;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DBRegisterPage extends DBProjectSpecifications {

    private WebDriver driver;

    public DBRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public DBRegisterPage RegUsername() {
        driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys("Sri007");
        return this;
    }

    public DBRegisterPage RegPassword() {
        driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("star007");
        return this;
    }

    public DBRegisterPage RegButtonClick() {
        driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
        System.out.println("Registrstion is Successful");
        return new DBRegisterPage(driver);
    }
    public DBRegisterPage ConfirmOK() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new DBRegisterPage(driver);
    }

}
