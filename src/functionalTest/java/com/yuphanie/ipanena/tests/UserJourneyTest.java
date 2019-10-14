package com.yuphanie.ipanena.tests;

import org.junit.Test;

public class UserJourneyTest extends UserJourneySetUp {

    @Test
    public void shouldLoadHomePage() {
        screen
                .shows_login();
    }
}
