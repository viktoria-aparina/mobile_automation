package pm.academy.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pm.academy.pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceSingleBetTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        if (new MainPage().isHeadTitleDisplayed()) {
            new ProfilePage().clickProfileTab().clickLoginButton();
            new LoginPage().clickSelectLoginTypeButton()
                    .clickIdLoginTypeButton()
                    .putIdInLoginInput()
                    .putPasswordInPasswordInput()
                    .clickVisibilityPassword()
                    .clickLogInButton();
        }
        new SighUpPage().clickLoginButton();
        assertThat(new LoginPage().isLoginPageOpened()).as("Login Page wasn't opened")
                .isTrue();

        new LoginPage().clickSelectLoginTypeButton()
                .clickIdLoginTypeButton()
                .putIdInLoginInput()
                .putPasswordInPasswordInput()
                .clickVisibilityPassword()
                .clickLogInButton();

        new SportPage().clickSportTab();
        assertOpenBottomTab(new SportPage().isSportTabOpened());

        new SportPage().clickBasketballSport().clickP1BetFirstGame();
    }

    @Test(groups = {"Aparina MOBILE tests"})
    public void addSingleBetWithSmallestAmountFromProposedTest() {
        new BetslipPage().clickSmallestProposedAmount().clickPlaceBetButton();
        assertThat(new BetslipPage().getSuccessAlert()).as("Single bet with smallest amount was created successfully! " +
                                                                   "The text in alert is differ from expected").isEqualTo("BET ACCEPTED");
    }

    @AfterMethod
    public void cashout() {
        new MyBetsPage().clickMyBetsTab();
        assertThat(new MyBetsPage().isMyBetsTabOpened())
                .as("Tab \"My Bets\" wasn't opened")
                .isTrue();

        new MyBetsPage().clickCashoutButton()
                .clickCashoutButton();

        new ProfilePage().clickProfileTab()
                .scrollToLogoutButton()
                .clickLogoutButton()
                .clickConfirmLogoutButton();
    }
}
