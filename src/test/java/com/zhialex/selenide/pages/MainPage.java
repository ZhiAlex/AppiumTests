package com.zhialex.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.zhialex.selenide.helpers.Constants.*;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

    private SelenideElement
            searchInput = $(id(SEARCH_CONTAINER)),
            menuButton = $(id(MENU_BUTTON)),
            signUpButton = $(id(SIGNUP_BUTTON));

    @Step("Открытие страницы поиска")
    public SearchPage openSearchPage() {
        searchInput.click();
        return new SearchPage();
    }

    @Step("Открытие меню")
    public MainPage openMenu() {
        menuButton.click();
        return this;
    }

    @Step("Открытие страницы регистрации")
    public SignUpPage openSignUpPage() {
        signUpButton.click();
        return new SignUpPage();
    }
}
