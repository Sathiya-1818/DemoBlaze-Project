package Tests;

import Base.DBProjectSpecifications;
import Pages.DBHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T2_DBLoginTest1 extends DBProjectSpecifications {

    @BeforeTest
    public void setup() throws IOException {

        ExtentSparkReporter Reporter= new ExtentSparkReporter("C:\\Users\\HOSUR PS\\IdeaProjects\\Project1\\DBReports\\DemoBlazeProjectReports.html");
        Extent = new ExtentReports();
        Extent.attachReporter(Reporter);

        TestName="Login Test";
        TestDescription="Testing the login functionality with data hard code";
        TestAuthor="Sathiya Priya";
        TestCategory="Smoke Testing";

    }


   @Test(priority = 1)
    public void DBLoginTest() throws InterruptedException {

        Test = Extent.createTest("Login Test","Testing the Login functionality");
        DBHomePage obj =new DBHomePage(driver);
        obj.DBLaunchAndLoad();
        obj.DBLoginClick()
                .DBUsername("Sri007")
                .DBPassword("star007")
                .DBLoginButton()
                ;
       Test.pass("Login Test executed successfully.");
    }
}
