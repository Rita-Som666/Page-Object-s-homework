package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ActionTransferPage {
    private final SelenideElement transferTo = $("[data-test-id='to']");
    private final SelenideElement transferFrom = $("[data-test-id='from' .input__control]");
    private final SelenideElement count = $("[data-test-id='amount'] .input__control");
    private final SelenideElement transferButton = $("[data-test-id='action-transfer'] .button");
    private final SelenideElement canselButton = $("[data-test-id='action-cancel'] .button");

    public void transferToCard1(){
        transferTo.shouldHave(Condition.value("**** **** **** 0001"));
    }

    public void transferToCard2(){
        transferTo.shouldHave(Condition.value("**** **** **** 0002"));
    }

}
