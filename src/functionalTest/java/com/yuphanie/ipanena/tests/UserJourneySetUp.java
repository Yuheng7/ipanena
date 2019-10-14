package com.yuphanie.ipanena.tests;

import com.yuphanie.ipanena.api.ScreenApi;
import com.yuphanie.ipanena.api.UserApi;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserJourneySetUp {

    private static WebDriver driver;

    protected static UserApi user;
    protected static ScreenApi screen;

    @BeforeClass
    public static void before() {
        setChromeDriver();
        driver = new ChromeDriver();

        user = new UserApi(driver);
        screen = new ScreenApi(driver);

        //Toggling
        enableAllFeatures();
    }

    private static void enableAllFeatures() {
    }

    private static void setChromeDriver() {
        String osName = System.getProperty("os.name");
        if (osName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver_mac");
        } else if (osName.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver_linux_64bit");
        }
    }

    @AfterClass
    public static void after() {
        driver.quit();
    }
}
