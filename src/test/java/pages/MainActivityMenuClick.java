package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivityMenuClick
{
    AndroidDriver driver;
    By mainMenu;
    List<WebElement> menuItems;
    List<WebElement> menu2Items;
    public MainActivityMenuClick(AndroidDriver driver)
    {
        this.driver = driver;
        mainMenu = By.id("android:id/text1");
        menuItems=driver.findElementsById("android:id/text1");
    }

    public void goToAnimationMenu()
    {
        try {
            menuItems.get(1).click();
            menu2Items = driver.findElementsById("text1");
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void bouncingAnimation()
    {
        goToAnimationMenu();
        menu2Items.get(0).click();
        TouchAction action = new TouchAction(driver);
        action.press(500,500).moveTo(500,500).perform();

    }
    public void defaultLayoutAnimations()
    {
        goToAnimationMenu();
        menu2Items.get(3).click();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(10);
                driver.findElementById("io.appium.android.apis:id/addNewButton").click();
            }
            List<WebElement> buttons = driver.findElementsByClassName("android.widget.Button");
            final int TOTAL_BUTTONS = buttons.size();
            for(int i=1; i<TOTAL_BUTTONS;i++)
            {
                buttons.get(1).click();
                buttons = driver.findElementsByClassName("android.widget.Button");
            }
            Thread.sleep(3000);
        }catch(Exception ex)
        {

        }
    }

    public AndroidDriver animationSeeking()
    {
        try
        {
            goToAnimationMenu();
            menu2Items.get(10).click();
            WebElement seekbar = driver.findElementById("io.appium.android.apis:id/seekBar");
            TouchAction action = new TouchAction(driver);
            action.press(seekbar).moveTo(50,0).moveTo(-300,0).moveTo(500,0).moveTo(-800,0).release().perform();
            driver.findElementById("io.appium.android.apis:id/startButton").click();
            return this.driver;
        }catch (Exception ex)
        {
            System.out.print(ex.getMessage());
            return null;
        }
    }
    public void scrolling() {
        String uiAutomatorString = "new UiScrollable(new UiSelector().scrollable(true).instance(0))"+
                                    ".scrollIntoView(new UiSelector().textContains(\"Rotating Button\").instance(0))";

        try {
            menuItems.get(menuItems.size() - 1).click();
            WebElement scrollable = driver.findElementByAndroidUIAutomator(uiAutomatorString);
            scrollable.click();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean controlTest()
    {
        try{
            menuItems.get(menuItems.size()-1).click();
            menu2Items = driver.findElementsById("android:id/text1");
            menu2Items.get(4).click();
            menu2Items.get(3).click();
            driver.findElementById("io.appium.android.apis:id/edit").sendKeys("Hola hola hola hola hola");
            driver.findElementById("io.appium.android.apis:id/check2").click();
            driver.findElementById("io.appium.android.apis:id/radio1").click();
            driver.findElementById("io.appium.android.apis:id/radio2").click();
            driver.findElementById("io.appium.android.apis:id/star").click();
            return true;
        }catch (Exception ex)
        {
            return false;
        }

    }
}
