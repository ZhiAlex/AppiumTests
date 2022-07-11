package com.zhialex.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.zhialex.selenide.drivers.LocalMobileDriver;
import com.zhialex.selenide.helpers.Attach;
import com.zhialex.selenide.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase {

    public MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setup() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
        back();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
    }
}
