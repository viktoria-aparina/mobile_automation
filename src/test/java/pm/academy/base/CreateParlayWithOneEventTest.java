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

public class CreateParlayWithOneEventTest extends BaseTest {

    @BeforeMethod
    public void chooseBet() {
        if (new LoginPage().isCloseButtonDisplayed()) {
            new LoginPage().clickCloseButton();
        }

        new SportPage().clickSportTab();
        assertOpenBottomTab(new SportPage().isSportTabOpened());

        new SportPage().clickBasketballSport().clickFilter12HButton().clickP1BetFirstGame();
    }

    @TmsLink("C18")
    @Story("5-write-native_mobile-autotests")
    @Description("Creating parlay with a single bet in betslip")
    @Test(groups = {"Volosiuk MOBILE tests"})
    public void createParlayWithOneEvent() {
        new BetslipPage().clickAddToBetslipButton().clickMinimizedBetslip().clickExpressTab();
        assertThat(new BetslipPage().getParlaySystemAlert())
                .as("The text in alert is differ from expected")
                .isEqualTo("Parlay must contain at least two bets");

        assertThat(new BetslipPage().isEnabledPlaceBetButton())
                .as("The button \"Place bet\" is enabled")
                .isFalse();
    }

    @AfterMethod
    public void clearBetslip() {
        new BetslipPage().clickClearBetslipButton().clickConfirmClearBetslipButton();
    }
}
