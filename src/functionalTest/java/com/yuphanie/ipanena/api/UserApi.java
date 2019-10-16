package com.yuphanie.ipanena.api;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.yuphanie.ipanena.helpers.URLs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserApi {

    private final String mainPageWindowHandle;
    private WebDriver driver;

    public UserApi(WebDriver driver) {
            this.driver = driver;
            this.mainPageWindowHandle = driver.getWindowHandle();
        }

    public UserApi visits_home_page() {
        driver.get(URLs.home());
        return this;
    }

    public UserApi visits_login_page() {
        driver.get(URLs.login());
        return this;
    }

    public UserApi logs_in_with(String userName, String userPassword) {
        driver.get(URLs.login());

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(userPassword);

        driver.findElement(By.className("Login")).click();

        return this;
    }

    public UserApi visits_about_page() {
        driver.get(URLs.about());
        return this;
    }

    public UserApi logs_out() {
        //right now logging out is in home page, could be elsewhere, who knows
        driver.get(URLs.home());
        driver.findElement(By.className("LogOut")).click();
        return this;
    }

    public UserApi clicks_create_account() {
        driver.findElement(By.className("CreateAccount")).click();
        return this;
    }

    public UserApi creates_account(String userName, String userPassword, String emailAddress) {
        driver.get(URLs.createAccount());
        
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
        driver.findElement(By.name("user_name")).sendKeys(userName);
        driver.findElement(By.name("user_password")).sendKeys(userPassword);
        driver.findElement(By.name("user_email")).sendKeys(emailAddress);

        driver.findElement(By.className("CreateAccount")).click();

        return this;
    }

    public UserApi deletes_made_account(String userName) {
        try {
            driver.get(URLs.home());
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
            driver.findElement(By.name("user_name")).sendKeys(userName);
            driver.findElement(By.className("deleteAccount")).click();

            return this;
        } catch (Exception e) {
            return this;
        }
    }

    public UserApi visits_credit_card_page() {
        driver.get(URLs.creditCards());
        return this;
    }
}
