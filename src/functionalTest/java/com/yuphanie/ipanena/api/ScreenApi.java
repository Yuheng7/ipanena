package com.yuphanie.ipanena.api;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.yuphanie.ipanena.helpers.URLs;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class ScreenApi {

    private WebDriver driver;

    public ScreenApi(WebDriver driver) {
        this.driver = driver;
    }

    public ScreenApi shows_home_page() {
        assertThat(driver.getCurrentUrl(), is(URLs.home()));
        return this;
    }

    public ScreenApi shows_login_page() {
        assertThat(driver.getCurrentUrl(), is(URLs.login()));
        return this;
    }

    public ScreenApi shows_about_page() {
        assertThat(driver.getCurrentUrl(), is(URLs.about()));
        return this;
    }

    public ScreenApi shows_home_logged_out() {
        assertThat(driver.findElement(By.id("login")).getText(), containsString("Login"));
        return this;
    }
    public ScreenApi shows_home_logged_in() {
        assertThat(driver.findElement(By.id("logout")).isDisplayed(), is(true));

        assertThat(driver.findElement(By.name("logout")).getText(), containsString("Log out"));
        return this;
    }
}
