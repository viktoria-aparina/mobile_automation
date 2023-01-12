package pm.academy.base;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pm.academy.pages.BetslipPage;
import pm.academy.pages.LoginPage;
import pm.academy.pages.SportPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateSystemWithOneEventTest extends BaseTest {
    @BeforeMethod
    public void chooseBet() {
        if (new LoginPage().isCloseButtonDisplayed()) {
            new LoginPage().clickCloseButton();
        }

        new SportPage().clickSportTab();
        assertOpenBottomTab(new SportPage().isSportTabOpened());

        new SportPage().clickBasketballSport().clickFilter12HButton().clickP1BetFirstGame();
    }

    @TmsLink("C19")
    @Story("5-write-native_mobile-autotests")
    @Description("Creating parlay with a single bet in betslip")
    @Test(groups = {"Aparina MOBILE tests"})
    public void createParlayWithOneEvent() {
        new BetslipPage().clickAddToBetslipButton().clickMinimizedBetslip().clickSystemTab();
        assertThat(new BetslipPage().getParlaySystemAlert())
                .as("The text in alert is differ from expected")
                .isEqualTo("System must have at least three bets");

        assertThat(new BetslipPage().isEnabledPlaceBetButton())
                .as("The button \"Place bet\" is enabled")
                .isFalse();
    }

    @AfterMethod
    public void clearBetslip() {
        new BetslipPage().clickClearBetslipButton().clickConfirmClearBetslipButton();
    }
}
