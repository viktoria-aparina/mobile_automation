package pm.academy.cases;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pm.academy.base.BaseTest;
import pm.academy.pages.MainPage;

public class AcademyTests2 extends BaseTest {

    @Test
    public void mainMenuTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(new MainPage().isHeadTitleDisplayed()).as("Head title is not displayed").isTrue();
        softAssertions.assertThat(new MainPage().isMenuButtonDisplayed()).as(" Menu button is not displayed").isTrue();
        softAssertions.assertThat(new MainPage().isPromoPanelDisplayed()).as("Promo title is not displayed").isTrue();
        softAssertions.assertAll();
    }

    @Test
    public void menuButtonTest2() {
        Assertions.assertThat(new MainPage().isMenuButtonDisplayed())
                .as("not displayed")
                .isTrue();
    }
}
