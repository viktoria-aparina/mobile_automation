package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Map;

@Log4j2
public class SportPage extends BasePage {

    @AndroidFindBy(accessibility = "sport-tab")
    private MobileElement sportTab;

    @AndroidFindBy(accessibility = "B")
    private MobileElement basketball;

    @AndroidFindBy(accessibility = "timeFilter12h")
    private MobileElement filter12HButton;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])[1]")
    private MobileElement firstGame;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])[1]/child::*//android.widget.LinearLayout[contains(@content-desc, 'outcome_1')]")
    private MobileElement betP1FirstGame;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])")
    private ArrayList<MobileElement> events;

    public SportPage clickSportTab() { waitForExpectedElement(sportTab).click();
        log.info("Click on tab \"Sport\" in bottom navigation was successful");
        return this;
    }

    public boolean isSportTabOpened() {
        return waitForExpectedElement(firstGame).isDisplayed();
    }

    public void clickP1BetFirstGame() {
        waitForExpectedElement(betP1FirstGame).click();
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

    public ArrayList<Double> clickEventAndOutcome(Map<Bet, Integer> parameterCoefficients) {
        ArrayList<Double> coefficientsFromSportPage = new ArrayList<>();
        for (Map.Entry<Bet, Integer> entry : parameterCoefficients.entrySet()) {
            MobileElement coefficient = events.get(entry.getValue()).findElementByXPath(entry.getKey().getLocator());
            coefficient.click();
            coefficientsFromSportPage.add(Double.valueOf(coefficient.getText()));
        }
        log.info("The bet was chosen successfully");
        return coefficientsFromSportPage;
    }
}
