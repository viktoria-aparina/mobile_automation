package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "com.parimatch:id/ivLogo")
    private MobileElement headTitle;

    public boolean isHeadTitleDisplayed() {
        return waitForExpectedElement(headTitle).isDisplayed();
    }
}
