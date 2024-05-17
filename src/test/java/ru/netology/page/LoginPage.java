package ru.netology.page;

import ru.netology.data.UserInfo.User;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    public VerificationPage validLogin() {
        var login = new User();
        $("[data-test-id='login'] .input__control").sendKeys(login.getLogin());
        $("[data-test-id='password'] .input__control").sendKeys(login.getPassword());
        $("[data-test-id='action-login']").click();
        return new VerificationPage();
    }
}
