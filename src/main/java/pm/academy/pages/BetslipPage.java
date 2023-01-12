package pm.academy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;

@Log4j2
public class BetslipPage extends BasePage {

    @AndroidFindBy(accessibility = "quickBetPlaceButton")
    private MobileElement placeBetButton;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'hotBet')][1]")
    private MobileElement smallestProposedAmount;

    @AndroidFindBy(accessibility = "tvAddToBetslip")
    private MobileElement addToBetslipOutcome;

    @AndroidFindBy(accessibility = "tvOddCoefficient")
    private ArrayList<MobileElement> coefficients;

    @AndroidFindBy(accessibility = "placeBetSuccessText")
    private MobileElement successAlert;

    @AndroidFindBy(accessibility = "doneButtonQuickBet")
    private MobileElement doneButton;

    @AndroidFindBy(accessibility = "etBetSum")
    private MobileElement betAmount;

    @AndroidFindBy(accessibility = "betslipOutcomeView")
    private MobileElement betslipOutcome;

    @AndroidFindBy(accessibility = "minimizedBetslip")
    private MobileElement minimizedBetslip;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'betslipOutcomeView')])")
    private ArrayList<MobileElement> betslipOutcomes;

    @AndroidFindBy(xpath = "(//*[@content-desc='ivDelete'])[1]")
    private MobileElement deleteFirstButton;

    @AndroidFindBy(accessibility = "EXPRESS")
    private MobileElement expressTab;

    @AndroidFindBy(accessibility = "tvSnackBarError")
    private MobileElement expressSystemAlert;

    @AndroidFindBy(accessibility = "SYSTEM")
    private MobileElement systemTab;

    @AndroidFindBy(accessibility = "ivActionDelete")
    private MobileElement clearBetslipButton;

    @AndroidFindBy(accessibility = "confirmButton")
    private MobileElement confirmButtonClearBetslip;

    @AndroidFindBy(accessibility = "tvOddCoefficient")
    private MobileElement coefficientFromBetslip;

    @AndroidFindBy(accessibility = "tvCancelBet")
    private MobileElement cancelButton;

    public BetslipPage clickPlaceBetButton() {
        waitForExpectedElement(placeBetButton).click();
        log.info("Click on \"Select login type\" was successful");
        return this;
    }

    public BetslipPage clickSmallestProposedAmount() {
        waitForExpectedElement(smallestProposedAmount).click();
        log.info("Click on \"Smallest amount\" was successful");
        return this;
    }

    public BetslipPage clickAddToBetslipButton() {
        waitForExpectedElement(addToBetslipOutcome).click();
        log.info("Click on the button \"Add to betslip\" was successful");
        return this;
    }

    public BetslipPage clickMinimizedBetslip() {
        waitForExpectedElement(minimizedBetslip).click();
        log.info("Click on the button \"Minimized betslip\" was successful");
        return this;
    }

    public BetslipPage clickExpressTab() {
        expressTab.click();
        log.info("Click on the tab \"Parlay\" was successful");
        return this;
    }

    public BetslipPage clickSystemTab() {
        systemTab.click();
        log.info("Click on the tab \"System\" was successful");
        return this;
    }

    public BetslipPage clickClearBetslipButton() {
        clearBetslipButton.click();
        log.info("Click on the button \"Clear betslip\" was successful");
        return this;
    }

    public BetslipPage clickConfirmClearBetslipButton() {
        confirmButtonClearBetslip.click();
        log.info("Click on the button \"Confirm\" in alert was successful");
        return this;
    }

    public BetslipPage clickCancelButton() {
        cancelButton.click();
        log.info("Click on the button \"Cancel\" in alert was successful");
        return this;
    }

    public String getSuccessAlert() {
        return successAlert.getText();
    }

    public String getParlaySystemAlert() {
        return expressSystemAlert.getText();
    }

    public BetslipPage clickDoneButton() {
        waitForExpectedElement(doneButton).click();
        log.info("Click on \"Done\" button was successful");
        return this;
    }

    public boolean isEnabledPlaceBetButton() {
        return waitForExpectedElement(placeBetButton).isEnabled();
    }

    public BetslipPage enterValueBet(String value) {
        waitForExpectedElement(betAmount).setValue(value);
        waitForExpectedElement(betAmount).isDisplayed();
        return this;
    }

    public Double getBetAmount() {
        return Double.parseDouble(waitForExpectedElement(betAmount).getText());
    }

    public boolean isBetslipOutcomeDisplayed() {
        return waitForExpectedElement(betslipOutcome).isDisplayed();
    }

    public String getOddFromBetslipOutcome() {
        return waitForExpectedElement(coefficientFromBetslip).getText();
    }

    public Integer getBetslipOutcomesSize() {
        return betslipOutcomes.size();
    }

    public void deleteOutcomeFirst() {
        waitForExpectedElement(deleteFirstButton).click();
    }
}
