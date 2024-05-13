package ru.netology.page;

import ru.netology.data.UserInfo;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void validLogin(){
        $("[data-test-id='login'] .input__control").sendKeys(UserInfo.getLogin());
        $("[data-test-id='password'] .input__control").sendKeys(UserInfo.getPassword());
        $("[data-test-id='action-login']").click();
    }
}
