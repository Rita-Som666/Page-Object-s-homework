package ru.netology.page;

import ru.netology.data.UserInfo.User;

import static com.codeborne.selenide.Selenide.$;
import static ru.netology.data.UserInfo.User.getLogin;
import static ru.netology.data.UserInfo.User.getPassword;

public class LoginPage {

    public static VerificationPage validLogin() {
        $("[data-test-id='login'] .input__control").sendKeys(getLogin());
        $("[data-test-id='password'] .input__control").sendKeys(getPassword());
        $("[data-test-id='action-login']").click();
        return new VerificationPage();
    }
}
