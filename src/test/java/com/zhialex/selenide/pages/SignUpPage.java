package com.zhialex.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.zhialex.selenide.helpers.Constants.GO_TO_LOGIN_PAGE_BUTTON;
import static io.appium.java_client.AppiumBy.id;

public class SignUpPage {

    private SelenideElement
            loginButton = $(id(GO_TO_LOGIN_PAGE_BUTTON));

    @Step("Открытие страницы входа")
    public LoginPage openLoginPage() {
        loginButton.click();
        return new LoginPage();
    }
}
