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

    public static DashBoardPage transferToCard(String sum, String value, String number) {
        transferTo.shouldHave(Condition.value(value));
        transferFrom.sendKeys(number);
        amount.sendKeys(sum);
        transferButton.click();
        return new DashBoardPage();
    }



}
