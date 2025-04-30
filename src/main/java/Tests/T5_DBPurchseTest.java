package Tests;

import Base.DBProjectSpecifications;
import Pages.DBHomePage;
import Pages.DBOrderConfirmationPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T5_DBPurchseTest extends DBProjectSpecifications {

    @BeforeTest
    public void setup() throws IOException {

        ExtentSparkReporter Reporter= new ExtentSparkReporter("C:\\Users\\HOSUR PS\\IdeaProjects\\Project1\\DBReports\\DemoBlazeProjectReports.html");
        Extent = new ExtentReports();
        Extent.attachReporter(Reporter);

        TestName="Product Purchase Test";
        TestDescription="Testing the viewing the product and purchasing the selected product functionalities";
        TestAuthor="Sathiya Priya";
        TestCategory="Smoke Testing";

    }


    @Test(priority = 1)
    public void DBProductPage() throws InterruptedException {
        Test = Extent.createTest("Purchase Test","Testing the functionality whether the product is added and purchased correctly");
        DBHomePage Object = new DBHomePage(driver);
        //Object.DBLaunchAndLoad();
        Object.DBProductPageClick()
                //.PPVisibilityOfElement()
                .PPProductClick()
                .PPAddProduct()
                .PPGoToCart()
                .OrderCheckOut();
    }
    @Test(priority = 2)
    public void DBOrderConfirmationPage() throws InterruptedException {

        Test = Extent.createTest("Order Confirmation Page Test","Testing the functionality whther the produst is ordered correctly");
        DBOrderConfirmationPage obj =new DBOrderConfirmationPage(driver);
        obj.OCVisibilityOfElement()
                .OCName()
                .Country()
                .City()
                .CreditCard()
                .Month()
                .Year()
                .purchase()
                .DBcloseBrowser();
    }

}
