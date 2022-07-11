package com.zhialex.selenide.tests;

import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {

    @Test
    void checkFailedLogin() {

        mainPage
                .openMenu()
                .openSignUpPage()
                .openLoginPage()
                .loginWithIncorrectData("lomtik", "cat")
                .checkErrorMessageNotification();
    }
}
