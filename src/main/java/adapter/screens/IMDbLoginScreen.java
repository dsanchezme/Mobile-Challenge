package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import org.tinylog.Logger;
import utils.SystemVariablesUtil;

public class IMDbLoginScreen extends BaseMobileScreen {

    private final MobileElement emailInput = new MobileElement(By.Xpath, "//android.widget.EditText[@resource-id='ap_email']", "Email input");
    private final MobileElement passwordInput = new MobileElement(By.Xpath, "//android.widget.EditText[@resource-id='ap_password']", "Email input");
    private final MobileElement submitButton = new MobileElement(By.Xpath, "//android.widget.Button[@resource-id='signInSubmit']", "Submit credentials button");


    public IMDbLoginScreen() {
        super();
    }

    private void setCredentials(String email, String password){
        Logger.debug("Setting IMDb credentials...");
        findMobileElement(emailInput).click().clear().sendKeys(email);
        findMobileElement(passwordInput).click().clear().sendKeys(password);
    }

    public void signIn(){
        String email = SystemVariablesUtil.getEmail();
        String password = SystemVariablesUtil.getPassword();
        setCredentials(email, password);
        findMobileElement(submitButton).click();
        Logger.debug("Logging in...");
    }
}
