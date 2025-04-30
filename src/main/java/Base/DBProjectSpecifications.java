package Base;

import Utility.DBUtilityClass;
import org.testng.ITestResult;
import org.testng.annotations.*;


public abstract class DBProjectSpecifications extends DBUtilityClass {
    @BeforeClass
	public void testDetails() {

        if (Extent == null) {
            System.out.println("ExtentReports is not initialized! Check DBUtilityClass.");
        }
		Test = Extent.createTest(TestName,TestDescription);
		Test.assignCategory(TestCategory);
		Test.assignAuthor(TestAuthor);

	}


    public void DBLaunchAndLoad() {

        if(driver ==null)
        {
            DBbrowserLaunch();
        }

    }


    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            DBUtilityClass.captureScreenshot(result.getName()); // Call screenshot method
        }else {
            System.out.println("Driver is null, cannot capture screenshot!");
        }
        if (driver != null) {
            driver.quit();
        }
    }


    @AfterSuite
    public void DBreportClose() {

        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver closed successfully.");
        }

        if (Extent != null) {
            Extent.flush();
            System.out.println("ExtentReports flushed and saved.");
        }

    }

}