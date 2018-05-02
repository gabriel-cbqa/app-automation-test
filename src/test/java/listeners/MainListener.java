package listeners;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import scenarios.AppiumTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainListener implements ITestListener
{
    private AndroidDriver driver;

    private void takeScreenshot(ITestResult result)
    {
        this.driver = ((AppiumTest)result.getInstance()).driver;
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            String screenshotName = result.getMethod().getMethodName()
                    + new SimpleDateFormat("yyyy-MM-dd_HH-ss").format(new GregorianCalendar().getTime());
            File screenshotFile =  new File("~/screenshots/" + screenshotName+".png");
            FileUtils.copyFile(screenshot, screenshotFile);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void onTestStart(ITestResult iTestResult)
    {
        takeScreenshot(iTestResult);
    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult)
    {
        takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
