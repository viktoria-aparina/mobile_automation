package pm.academy.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pm.academy.pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CashoutTest extends BaseTest {

    @BeforeMethod
    public void chooseBet() {
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

        new SportPage().clickBasketballSport().clickFilter12HButton().clickP1BetFirstGame();
    }

    @Test(groups = {"Aparina MOBILE tests"})
    public void cashoutBetTest() {
        new BetslipPage().clickSmallestProposedAmount().clickPlaceBetButton();
        assertThat(new BetslipPage().getSuccessAlert())
                .as("Single bet with smallest amount was created successfully!"
                            + "The text in alert is differ from expected")
                .isEqualTo("BET ACCEPTED");

        new BetslipPage().clickDoneButton();
        new MyBetsPage().clickMyBetsTab();

        assertOpenBottomTab(new MyBetsPage().isMyBetsTabOpened());

        new MyBetsPage().clickCashoutButton().clickCashoutButton();
        assertThat(new MyBetsPage().getCashoutAlert())
                .as("Cashout alert doesn't match with expected")
                .contains("Cashout successful");
    }

    @AfterMethod
    public void logout() {
        new ProfilePage().clickProfileTab()
                .scrollToLogoutButton()
                .clickLogoutButton()
                .clickConfirmLogoutButton();
    }
}
