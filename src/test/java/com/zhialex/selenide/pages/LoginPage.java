package com.zhialex.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.zhialex.selenide.helpers.Constants.*;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class LoginPage {

    private SelenideElement
            usernameInput = $(id(USERNAME_INPUT)).$(className("android.widget.EditText")),
            passwordInput = $(id(PASSWORD_INPUT)).$(className("android.widget.EditText")),
            logInButton = $(id(LOGIN_BUTTON)),
            errorMessageNotification = $(id(ERROR_MESSAGE_NOTIFICATION));

    @Step("Авторизация с неверными данными")
    public LoginPage loginWithIncorrectData(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
        return this;
    }

    @Step("Провека текста ошибки при вводе некорректных данных")
    public void checkErrorMessageNotification() {
        errorMessageNotification.shouldHave(text("Incorrect username or password entered. Please try again."));
    }
}
