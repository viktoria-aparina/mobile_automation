package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;
import pm.academy.utils.PropertiesLoader;

@Log4j2
public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.parimatch:id/tvButtonTitle")
    private MobileElement logInButton;

    @AndroidFindBy(accessibility = "Select login type button")
    private MobileElement selectLoginTypeButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'text1')][2]")
    private MobileElement idLoginType;

    @AndroidFindBy(accessibility = "Login field")
    private MobileElement loginInput;

    @AndroidFindBy(accessibility = "Password field")
    private MobileElement passwordInput;

    @AndroidFindBy(accessibility = "password_visibility_check_box")
    private MobileElement visibilityPassword;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;

    @AndroidFindBy(accessibility = "close_button")
    private MobileElement closeButton;

    public boolean isLoginPageOpened() {
        return waitForExpectedElement(logInButton).isDisplayed();
    }

    public LoginPage clickSelectLoginTypeButton() {
        waitForExpectedElement(selectLoginTypeButton).click();
        log.info("Click on \"Select login type\" was successful");
        return this;
    }

    public LoginPage clickIdLoginTypeButton() {
        waitForExpectedElement(idLoginType).click();
        log.info("Click on \"Login with id\" was successful");
        return this;
    }

    public LoginPage putIdInLoginInput() {
        waitForExpectedElement(loginInput).sendKeys(PropertiesLoader.loadProperties().getProperty("login"));
        log.info("The field \"Login\" was filled in successfully");
        return this;
    }

    public LoginPage putPasswordInPasswordInput() {
        waitForExpectedElement(passwordInput).click();
        passwordInput.sendKeys(PropertiesLoader.loadProperties().getProperty("password"));
        passwordInput.click();
        log.info("The field \"Password\" was filled in successfully");
        return this;
    }

    public SportPage clickLogInButton() {
        logInButton.click();
        log.info("Click on \"Log In\" was successful");
        return new SportPage();
    }

    public LoginPage clickVisibilityPassword() {
        visibilityPassword.click();
        log.info("Click on \"Visibility password\" was successful");
        return this;
    }

    public LoginPage clickOkButton() {
        waitForExpectedElement(okButton).click();
        log.info("Click on the button \"Ok\" was successful");
        return this;
    }

    public boolean isCloseButtonDisplayed() {
        return waitForExpectedElement(closeButton).isDisplayed();
    }

    public void clickCloseButton() {
        waitForExpectedElement(closeButton).click();
    }
}
