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

public class FillingBetWithValidDataTest extends BaseTest {

    @BeforeMethod
    public void chooseBet() {
        if (new LoginPage().isCloseButtonDisplayed()) {
            new LoginPage().clickCloseButton();
        }

        new SportPage().clickSportTab();
        assertOpenBottomTab(new SportPage().isSportTabOpened());

        new SportPage().clickBasketballSport().clickFilter12HButton().clickP1BetFirstGame();
    }

    @TmsLink("C10")
    @Story("5-write-native_mobile-autotests")
    @Description("Filling the field \"Bet Total\" with valid data")
    @Test(groups = {"Riabtseva Mobile tests"})
    public void fillBetTotalWithValidData() {
        for (double betAmount : new double[]{20., 21., 45.76}) {
            new BetslipPage().enterValueBet(String.valueOf(betAmount));

            assertThat(new BetslipPage().getBetAmount())
                    .as("Bet amount is not equal to the one entered")
                    .isEqualTo(betAmount);
            assertThat(new BetslipPage().isEnabledPlaceBetButton())
                    .as("\"Place Bet\" button is disabled")
                    .isTrue();
        }
    }
}
