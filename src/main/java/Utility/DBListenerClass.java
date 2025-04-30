package Utility;

import Base.DBProjectSpecifications;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class DBListenerClass extends DBProjectSpecifications implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Test.fail(result.getThrowable());
        System.out.println("Test failed: " + result.getMethod().getMethodName());

        // Check if driver is still active before capturing screenshot
        if (driver == null) {
            System.out.println("Driver is closed, cannot take screenshot.");
            return;
        }

        // Capture screenshot on failure
        String filepath = captureScreenshot(result.getMethod().getMethodName());
        System.out.println("Captured screenshot path: " + filepath);

        // Ensure screenshot is not null before attaching to report
        if (filepath != null && !filepath.isEmpty()) {
            try {
                Test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
                System.out.println("Screenshot attached to report successfully.");
            } catch (Exception e) {
                System.out.println("Error attaching screenshot to report: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Screenshot path is invalid, skipping attachment.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed within success percentage: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test failed due to timeout: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished: " + context.getName());
    }}
