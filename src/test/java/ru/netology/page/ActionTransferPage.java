package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ActionTransferPage {
    private static final SelenideElement transferTo = $("[data-test-id='to'] .input__control");
    private static final SelenideElement transferFrom = $("[data-test-id='from'] .input__control");
    private static final SelenideElement amount = $("[data-test-id='amount'] .input__control");
    private static final SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private static final SelenideElement canselButton = $("[data-test-id='action-cancel'] .button");

    public ActionTransferPage() {
        $(byText("Пополнение карты")).shouldBe(Condition.visible);
    }

    public static void transferToCard1(String sum) {
        transferTo.shouldHave(Condition.value("**** **** **** 0001"));
        transferFrom.sendKeys("5559 0000 0000 0002");
        amount.sendKeys(sum);
        transferButton.click();
    }

    public static void transferToCard2(String sum) {
        transferTo.shouldHave(Condition.value("**** **** **** 0002"));
        transferFrom.sendKeys("5559 0000 0000 0001");
        amount.sendKeys(sum);
        transferButton.click();
    }

}
