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
        assertThat(driver.findElement(By.className("Login")).getText(), is("Login"));
        return this;
    }
    public ScreenApi shows_home_logged_in() {
        driver.get(URLs.home());
        assertThat(driver.findElement(By.className("LogOut")).getText(), is("Log Out"));
        return this;
    }

    public ScreenApi shows_login_page_error() {
        assertThat(driver.getCurrentUrl(), is(URLs.loginError()));
        return this;
    }

    public ScreenApi shows_create_account_page() {
        assertThat(driver.getCurrentUrl(), containsString(URLs.createAccount()));
        return this;
    }

    public ScreenApi shows_create_account_error_page() {
        assertThat(driver.getPageSource(), containsString("error"));
        return this;
    }

    public ScreenApi shows_create_account_success() {
        assertThat(driver.getPageSource(), containsString("account has been created"));
        return this;
    }

    public ScreenApi shows_credit_card_page() {
        assertThat(driver.getCurrentUrl(), containsString("cards"));
        return this;
    }
}
