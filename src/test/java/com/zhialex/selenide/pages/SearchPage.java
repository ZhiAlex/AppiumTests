package com.zhialex.selenide.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.zhialex.selenide.helpers.Constants.SEARCH_INPUT;
import static com.zhialex.selenide.helpers.Constants.SEARCH_RESULT_TITLES;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    private SelenideElement
            searchInput = $(id(SEARCH_INPUT));
    private ElementsCollection
            resultTitles = $$(id(SEARCH_RESULT_TITLES));

    @Step("Ввод текста поиска")
    public SearchPage enterText(String value) {
        searchInput.sendKeys(value);
        return this;
    }

    @Step("Проверка, что поиск выдал хотя бы 1 результат")
    public void checkSearchResult() {
        resultTitles.shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
