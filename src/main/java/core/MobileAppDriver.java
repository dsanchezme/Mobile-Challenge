package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileAppDriver {
    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getMoviesAppDriver(DesiredCapabilities capabilities)  {
        if (driver == null || driver.getSessionId() == null) {
            try {
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void waitUntilSomethingWithText(String text){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//*[contains(@text, \""+text+"\")]"))));
    }

    public static void printPageSource(){
        if (driver != null) {
            System.out.println("#############################");
            System.out.println(driver.getPageSource());
            System.out.println("#############################");
        }
    }
}