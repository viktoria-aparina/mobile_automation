package pm.academy.cases;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pm.academy.base.BaseTest;
import pm.academy.pages.LoginPage;
import pm.academy.pages.SportPage;

public class TestCaseScenarioTest extends BaseTest {

    @Test
    public void loginWindowTestWithFirstLoginPage() {
        new LoginPage().clickCloseButtonDisplayed();
        new SportPage().clickSportTabDisplayed();

        Assertions.assertThat(new SportPage().isSportTabOpened())
                .as("The tab \"Sport\" wasn't opened")
                .isTrue();

        new SportPage().clickP1BetFirstGame();

        Assertions.assertThat(new LoginPage().isLoginPageOpened())
                .as("The LoginPage wasn't opened")
                .isTrue();
    }
}
