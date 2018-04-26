package scenarios;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainActivityMenuClick;

@Listeners({listeners.MainListener.class})
public class AppiumTest extends  AndroidSetup
{
    @BeforeClass
    public void setUp()throws Exception
    {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void mainActivityMenuClick()
    {
        Assert.assertFalse(new MainActivityMenuClick(driver).controlTest());
        System.out.print("Successssss");
    }
}