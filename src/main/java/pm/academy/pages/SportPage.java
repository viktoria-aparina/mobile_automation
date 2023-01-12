package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;

@Log4j2
public class SportPage extends BasePage {

    @AndroidFindBy(accessibility = "sport-tab")
    private MobileElement sportTab;

    @AndroidFindBy(accessibility = "B")
    private MobileElement basketball;

    @AndroidFindBy(accessibility = "timeFilter12h")
    private MobileElement filter12HButton;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])[1]/child::*//android.widget.LinearLayout[contains(@content-desc, 'outcome_1')]")
    private MobileElement betP1FirstGame;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])[1]/child::*//android.widget.LinearLayout[contains(@content-desc, 'outcome_3')]")
    private MobileElement betP2FirstGame;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])[2]/child::*//android.widget.LinearLayout[contains(@content-desc, 'outcome_3')]")
    private MobileElement betP2SecondGame;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])")
    private ArrayList<MobileElement> events;

    public SportPage clickSportTab() { waitForExpectedElement(sportTab).click();
        log.info("Click on tab \"Sport\" in bottom navigation was successful");
        return this;
    }

    public boolean isSportTabOpened() {
        return waitForExpectedElement(basketball).isDisplayed();
    }

    public void clickP1BetFirstGame() {
        waitForExpectedElement(betP1FirstGame).click();
    }

    public void clickBetP2FirstGame() {
        waitForExpectedElement(betP2FirstGame).click();
        waitForExpectedElement(betP2FirstGame).isSelected();
    }

    public void clickBetP2SecondGame() {
        waitForExpectedElement(betP2SecondGame).click();
    }

    public SportPage clickFilter12HButton() {
        waitForExpectedElement(filter12HButton).click();
        log.info("Click on tab \"12H\" was successful");
        return this;
    }

    public SportPage clickBasketballSport() {
        waitForExpectedElement(basketball).click();
        log.info("Click on tab \"Basketball\" was successful");
        return this;
    }

    public String getCoefficientP1FirstEventFromSportPage() {
        return betP1FirstGame.getText();
    }

    public String getCoefficientP2FirstEventFromSportPage() {
        return betP2FirstGame.getText();
    }

    public boolean isFirstOutcomeSelected() {
        return waitForExpectedElement(betP1FirstGame).isSelected();
    }
}
