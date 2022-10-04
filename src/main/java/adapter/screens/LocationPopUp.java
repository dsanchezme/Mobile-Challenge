package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class LocationPopUp extends BaseMobileScreen {

    private MobileElement dontAllowButton = new MobileElement(By.Id, "com.android.permissioncontroller:id/permission_deny_button", "Button to dismiss pop-up not allowing to access device's location");

    public LocationPopUp() {
        super();
    }

    public void dismissPopUpNotAllowing(){
        findMobileElement(dontAllowButton).click();
    }
}
