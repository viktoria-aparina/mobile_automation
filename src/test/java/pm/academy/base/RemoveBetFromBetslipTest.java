package pm.academy.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pm.academy.pages.BetslipPage;
import pm.academy.pages.LoginPage;
import pm.academy.pages.SportPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveBetFromBetslipTest extends BaseTest {

    @BeforeMethod
    public void chooseBet() {
        if (new LoginPage().isCloseButtonDisplayed()) {
            new LoginPage().clickCloseButton();
        }

        new SportPage().clickSportTab();
        assertOpenBottomTab(new SportPage().isSportTabOpened());

        new SportPage().clickBasketballSport().clickFilter12HButton();
    }

    @Test(groups = "Riabtseva Mobile tests")
    public void removeBetFromBetslip() {
        new SportPage().clickP1BetFirstGame();;
        assertThat(new BetslipPage().isBetslipOutcomeDisplayed())
                .as("Outcome is not shown in betslip")
                .isTrue();

        new BetslipPage().clickAddToBetslipButton();
        new SportPage().clickBetP2SecondGame();

        new BetslipPage().clickMinimizedBetslip();

        assertThat(new BetslipPage().getBetslipOutcomesSize()).
                as("There should be 2 outcomes in the array")
                .isEqualTo(2);

        new BetslipPage().deleteOutcomeFirst();
        assertThat(new BetslipPage().getBetslipOutcomesSize())
                .as("There should be 1 outcome in the array")
                .isEqualTo(1);
    }

    @AfterMethod
    public void clearBetslip() {
        new BetslipPage().clickClearBetslipButton().clickConfirmClearBetslipButton();
    }
}
