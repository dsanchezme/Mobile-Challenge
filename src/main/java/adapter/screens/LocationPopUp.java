package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.qameta.allure.Step;
import org.tinylog.Logger;

public class LocationPopUp extends BaseMobileScreen {

    private MobileElement doNotAllowButton = new MobileElement(By.Id, "com.android.permissioncontroller:id/permission_deny_button", "Button to dismiss pop-up not allowing to access device's location");

    public LocationPopUp() {
        super();
    }

    @Step("Dismiss pop-up not allowing to access device's location")
    public void dismissPopUpNotAllowing(){
        if (exist(doNotAllowButton)){
            Logger.debug("Dismissing access device's location pop-up");
            findMobileElement(doNotAllowButton).click();
        }
    }
}
