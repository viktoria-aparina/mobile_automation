package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyBetsPage extends BasePage {

    @AndroidFindBy(accessibility = "my-bets-tab")
    private MobileElement myBetsTab;

    @AndroidFindBy(accessibility = "OPEN BETS")
    private MobileElement openedBetsTab;

    @AndroidFindBy(id = "com.parimatch:id/cashoutButton")
    private MobileElement cashoutButton;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement cashoutAlert;

    public MyBetsPage clickMyBetsTab() {
        waitForExpectedElement(myBetsTab).click();
        log.info("Click on the tab \"My Bets\" was successful");
        return this;
    }

    public MyBetsPage clickCashoutButton() {
        waitForExpectedElement(cashoutButton).click();
        log.info("Click on the button \"Cashout\"  was successful");
        return this;
    }

    public boolean isMyBetsTabOpened() {
        return waitForExpectedElement(openedBetsTab).isDisplayed();
    }

    public String getCashoutAlert() {
        return cashoutAlert.getText();
    }
}
