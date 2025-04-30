package Tests;

import Base.DBProjectSpecifications;
import Pages.DBHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T1_DBRegisterTest extends DBProjectSpecifications {

    @BeforeTest
    public void setup() throws IOException {

        ExtentSparkReporter Reporter= new ExtentSparkReporter("C:\\Users\\HOSUR PS\\IdeaProjects\\Project1\\DBReports\\DemoBlazeProjectReports.html");
        Extent = new ExtentReports();
        Extent.attachReporter(Reporter);

        TestName="Register Test";
		TestDescription="Testing the register functionality with data hard code";
        TestAuthor="Sathiya Priya";
        TestCategory="Regression Testing";

    }


    @Test
    public void DBRegisterTest() {

        Test = Extent.createTest("Register Test","Testing the register functionality");
        DBHomePage Object = new DBHomePage(driver);
        //Object.DBLaunchAndLoad();
        Object.DBRegisterClick()
                .RegUsername()
                .RegPassword()
                .RegButtonClick()
                ;
        Test.pass("Register Test executed successfully.");
    }
}
