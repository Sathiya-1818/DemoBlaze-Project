package Tests;

import Base.DBProjectSpecifications;
import Pages.DBHomePage;
import Pages.DBOrderConfirmationPage;
import Pages.DBProductPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T3_DBLoginTest2 extends DBProjectSpecifications {

    @BeforeTest
    public void setup() throws IOException {

        ExtentSparkReporter Reporter = new ExtentSparkReporter("C:\\Users\\HOSUR PS\\IdeaProjects\\Project1\\DBReports\\DemoBlazeProjectReports.html");
        Extent = new ExtentReports();
        Extent.attachReporter(Reporter);

        TestName = "Login Test";
        TestDescription = "Testing the login functionality with data hard code";
        TestAuthor = "Sathiya Priya";
        TestCategory = "Smoke Testing";
    }



    @Test(priority = 1)
    public void DBLoginTest() throws InterruptedException {

        Test = Extent.createTest("Login Test","Testing the Login functionality");
        DBHomePage obj =new DBHomePage(driver);
        obj.DBLaunchAndLoad();
        obj.DBLoginClick()
                .DBUsername("Sri007")
                .DBPassword("star007")
                .DBLoginButton();
        Test.pass("Login Test executed successfully.");
    }

    @Test(priority = 2)
    public void DBProductPage() throws InterruptedException {

        Test = Extent.createTest("Product View Test","Testing the Product Page functionality whether the products are able to view");
        DBProductPage Obj =new DBProductPage(driver);
        Obj
                //.PPVisibilityOfElement()
                .PPProductClick()
                .PPAddProduct()
                .PPGoToCart()
                .OrderCheckOut();
        Test.pass("Product Viewing and aading to cart Test executed successfully.");

    }

    @Test(priority = 3)
    public void DBOrderConfirmationPage() throws InterruptedException {

        Test = Extent.createTest("Order Confirmation Page Test","Testing the functionality whther the produst is ordered correctly");
        DBOrderConfirmationPage obj =new DBOrderConfirmationPage(driver);
        obj //.OCVisibilityOfElement()
                .OCName()
                .Country()
                .City()
                .CreditCard()
                .Month()
                .Year()
                .purchase()
                .DBcloseBrowser();

        Test.pass("Product Purchasing Test executed successfully.");


        }
}

