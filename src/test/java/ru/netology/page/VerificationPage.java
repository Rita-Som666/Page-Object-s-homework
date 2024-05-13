package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.UserInfo;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
private final SelenideElement code = $("[data-test-id='code'] .input__control");
private final SelenideElement button = $("[data-test-id='action-verify']");

public void validCode(){
    code.sendKeys(UserInfo.getCode());
    button.click();
}
}
