package com.zhialex.selenide.tests;

import org.junit.jupiter.api.Test;

public class SearchTest extends TestBase {

    @Test
    void searchTest() {
        mainPage
                .openSearchPage()
                .enterText("Appium")
                .checkSearchResult();
    }
}
