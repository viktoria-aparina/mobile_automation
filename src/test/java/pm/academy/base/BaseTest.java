package pm.academy.base;

import org.testng.annotations.*;
import pm.academy.driver.DriverManager;
import pm.academy.pages.*;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;
import static pm.academy.driver.DriverManager.getDriver;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"UDID", "WDA", "DeviceName", "PlatformVersion"})
    public void setupSession(
            @Optional String udid,
            @Optional String wda,
            @Optional String deviceName,
            @Optional String platformVersion) {
        try {
            DriverManager.createDriver(udid, wda, deviceName, platformVersion);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite(alwaysRun = true)
    @Parameters("UDID")
    public void closeSession(@Optional String udid) {
        DriverManager.terminateDriver();
        DriverManager.terminateAppium();
    }

    @AfterMethod(alwaysRun = true)
    public void resetApp() {
        getDriver().resetApp();
    }

    protected void assertOpenBottomTab(boolean actualResult) {
        assertThat(actualResult)
                .as("The tab wasn't opened")
                .isTrue();
    }
}
