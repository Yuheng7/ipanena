package com.yuphanie.ipanena.tests;

import org.junit.Test;

public class UserJourneyTest extends UserJourneySetUp {

    @Test
    public void shouldLoadHomePage() {

        user
                .visits_home_page();
        screen
                .shows_home_page();
    }
}
