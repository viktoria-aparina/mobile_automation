package pm.academy.base;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pm.academy.pages.BetslipPage;
import pm.academy.pages.LoginPage;
import pm.academy.pages.SportPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoOutcomesOneEventTest extends BaseTest {

    @BeforeMethod
    public void chooseBet() {
        if (new LoginPage().isCloseButtonDisplayed()) {
            new LoginPage().clickCloseButton();
        }

        new SportPage().clickSportTab();
        assertOpenBottomTab(new SportPage().isSportTabOpened());

        new SportPage().clickBasketballSport().clickFilter12HButton().clickP1BetFirstGame();
    }

    @TmsLink("C22")
    @Story("5-write-native_mobile-autotests")
    @Description("Parlay bet with two outcomes of one event \"My bets\"")
    @Test(groups = {"Volosiuk MOBILE tests"})
    public void twoOutcomesOneEvent() {
        new SportPage().clickBetP2FirstGame();
        assertThat(new SportPage().isFirstOutcomeSelected())
                .as("Outcome was selected in Sport page")
                .isFalse();

        String oddFromSportPage = new SportPage().getCoefficientP2FirstEventFromSportPage();
        String oddFromBetslip = new BetslipPage().getOddFromBetslipOutcome();
        assertThat(oddFromBetslip)
                .as("Odds in Betslip and outcome in Sport page must be equal")
                .isEqualTo(oddFromSportPage);

        new BetslipPage().clickCancelButton();
    }
}
