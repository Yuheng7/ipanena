package com.yuphanie.ipanena.api;
import org.openqa.selenium.WebDriver;
import com.yuphanie.ipanena.helpers.URLs;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ScreenApi {

    private WebDriver driver;

    public ScreenApi(WebDriver driver) {
        this.driver = driver;
    }

    public ScreenApi shows_login() {
        assertThat(driver.getCurrentUrl(), is(URLs.login()));
        return this;
    }
}
