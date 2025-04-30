package Tests;

import Base.DBProjectSpecifications;
import Pages.DBHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T4_DBInvalidLoginTest extends DBProjectSpecifications {

    @BeforeTest
    public void setup() throws IOException {

        ExtentSparkReporter Reporter= new ExtentSparkReporter("C:\\Users\\HOSUR PS\\IdeaProjects\\Project1\\DBReports\\DemoBlazeProjectReports.html");
        Extent = new ExtentReports();
        Extent.attachReporter(Reporter);

        TestName="InvalidLogin Test";
        TestDescription="Testing the invalid login functionality with data hard code";
        TestAuthor="Sathiya Priya";
        TestCategory="Regression Testing";

    }


    @Test(priority = 1)
    public void DBInvalidLoginTest() throws InterruptedException {

        Test = Extent.createTest("Invalid Login Test","Testing the Invalid Login functionality");
        DBHomePage obj = new DBHomePage(driver);
        obj.DBLaunchAndLoad();
        obj.DBinvalidLoginClick()
                .DBUsername("Adhi1885")
                .DBPassword("star1995")
                .DBLoginButton()
                .DBcloseBrowser()
                ;
        Test.fail("Login is unsuccessfull. Check the Login Details again");

    }

}
