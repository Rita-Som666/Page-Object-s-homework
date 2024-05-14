package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.UserInfo;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private static final SelenideElement code = $("[data-test-id='code'] .input__control");
    private static final SelenideElement button = $("[data-test-id='action-verify']");

    public VerificationPage() {
        code.shouldBe(Condition.visible);
    }

    public static DashBoardPage validCode() {
        code.sendKeys(UserInfo.getCode());
        button.click();
        return new DashBoardPage();
    }
}
