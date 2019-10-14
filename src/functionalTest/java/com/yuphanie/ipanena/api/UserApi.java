package com.yuphanie.ipanena.api;

import org.openqa.selenium.WebDriver;

public class UserApi {

    private final String mainPageWindowHandle;
    private WebDriver driver;

    public UserApi(WebDriver driver) {
            this.driver = driver;
            this.mainPageWindowHandle = driver.getWindowHandle();
        }
}
