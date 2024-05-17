package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.data.UserInfo.User;

import static com.codeborne.selenide.Selenide.$;

@Data
@AllArgsConstructor
public class VerificationPage {
    private SelenideElement code = $("[data-test-id='code'] .input__control");
    private SelenideElement button = $("[data-test-id='action-verify']");

    public VerificationPage() {
        code.shouldBe(Condition.visible);
    }

    public DashBoardPage validCode() {
        var user = new User();
        code.sendKeys(user.getCode());
        button.click();
        return new DashBoardPage();
    }
}
