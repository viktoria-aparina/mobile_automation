package pm.academy.base;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
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

    @TmsLink("C8")
    @Story("5-write-native_mobile-autotests")
    @Description("Creating a single bet with the smallest amount from proposed")
    @Test(groups = {"Aparina MOBILE tests"})
    public void addSingleBetWithSmallestAmountFromProposedTest() {
        new BetslipPage().clickSmallestProposedAmount().clickPlaceBetButton();
        assertThat(new BetslipPage().getSuccessAlert()).as("Single bet with smallest amount was created successfully! " +
                                                                   "The text in alert is differ from expected").isEqualTo("BET PLACED");
    }
}
