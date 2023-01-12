package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import pm.academy.driver.DriverManager;

@Log4j2
public class ProfilePage extends BasePage {

    @AndroidFindBy(accessibility = "profile-tab")
    private MobileElement profileTab;

    @AndroidFindBy(accessibility = "LOGOUT")
    private MobileElement logoutButton;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmLogoutButton;

    @AndroidFindBy(accessibility = "LOGIN")
    private MobileElement loginButton;

    public ProfilePage clickProfileTab() {
        waitForExpectedElement(profileTab).click();
        log.info("Click on \"Profile\" tab was successful");
        return this;
    }

    public boolean isProfileTabOpened() {
        return waitForExpectedElement(logoutButton).isEnabled();
    }

    public ProfilePage clickLoginButton() {
        waitForExpectedElement(loginButton).click();
        log.info("Click on the button \"Logout\" was successful");
        return this;
    }

    public ProfilePage clickLogoutButton() {
        waitForExpectedElement(logoutButton).click();
        log.info("Click on the button \"Logout\" was successful");
        return this;
    }

    public ProfilePage clickConfirmLogoutButton() {
        waitForExpectedElement(confirmLogoutButton).click();
        log.info("Click on the button \"Confirm\" was successful");
        return this;
    }

    public ProfilePage scrollToLogoutButton() {
        TouchActions action = new TouchActions(DriverManager.getDriver());
        action.scroll(logoutButton, 10, 500);
        action.perform();
        return this;
    }
}
