package adapter.bases;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import core.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMobileScreen {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    private AndroidElement androidElement;
    private String mobileElementDescription;

    public BaseMobileScreen(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        wait = new WebDriverWait(driver, 30);
        initElements();
    }

    private void initElements(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Ok\")")
    public AndroidElement okButton;

    public BaseMobileScreen findMobileElement(MobileElement mobileElement){
        mobileElementDescription = mobileElement.elementDescription;
        switch (mobileElement.by){
            case AndroidUISelector:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator(mobileElement.element)));
                break;
            case Id:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(mobileElement.element)));
                break;
            case ClassName:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.className(mobileElement.element)));
                break;
            case Xpath:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(mobileElement.element)));
                break;
        }
        return this;
    }

    public boolean exist(MobileElement mobileElement){
        WebDriverWait innerWait = new WebDriverWait(driver, 5);
        innerWait.ignoring(TimeoutException.class);
        innerWait.ignoring(WebDriverException.class);
        try {
            return innerWait.until(innerDriver -> {
                switch (mobileElement.by){
                    case Id:
                        return innerDriver.findElements(By.id(mobileElement.element)).size() > 0;
                    case ClassName:
                        return innerDriver.findElements(By.className(mobileElement.element)).size() > 0;
                    case Xpath:
                        return innerDriver.findElements(By.xpath(mobileElement.element)).size() > 0;
                }
                return false;
            });
        }catch (Exception e){
            return false;
        }
    }

    public BaseMobileScreen click(){
        androidElement.click();
        return this;
    }

    public BaseMobileScreen clear(){
        androidElement.clear();
        return this;
    }

    public BaseMobileScreen sendKeys(String text){
        androidElement.sendKeys(text);
        return this;
    }

    public String getText(){
        return androidElement.getText();
    }
}
