package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedCondition;

@Log4j2
public class MyBetsPage extends BasePage {

    @AndroidFindBy(accessibility = "my-bets-tab")
    private MobileElement myBetsTab;

    @AndroidFindBy(id = "com.parimatch:id/cashoutButton")
    private MobileElement cashoutButton;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement cashoutAlert;

    public MyBetsPage clickMyBetsTab() {
        waitForExpectedElement(myBetsTab).click();
        log.info("Click on the tab \"My Bets\" was successful");
        return this;
    }

    public MyBetsPage clickCashoutButton() throws InterruptedException {
        waitForExpectedElement(cashoutButton).isEnabled();
        cashoutButton.click();
        Thread.sleep(1500);
        log.info("Click on the button \"Cashout\"  was successful");
        return this;
    }

    public boolean isMyBetsTabOpened() {
        return waitForExpectedElement(cashoutButton).isEnabled();
    }

    public String getCashoutAlert() {
        return cashoutAlert.getText();
    }
}
