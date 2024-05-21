package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;

import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.UserInfo;
import ru.netology.data.UserInfo.CardsInfo;
import ru.netology.data.UserInfo.User;
import ru.netology.data.UserInfo.Verify;
import ru.netology.page.ActionTransferPage;
import ru.netology.page.DashBoardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

public class Steps {
    private static LoginPage loginPage;
    private static VerificationPage verificationPage;
    private static DashBoardPage dashBoardPage;
    private static ActionTransferPage actionTransferPage;
    private static User user;

    @Пусть("пользователь залогинен с именем 'vasya' и паролем 'qwerty123'")
    public void authorise(String url, User user, Verify verify){
        loginPage = Selenide.open(url, LoginPage.class);
        verificationPage = loginPage.validLogin(user);
        dashBoardPage = verificationPage.validCode(verify);
    }

    @Когда("пользователь переводит {string} рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы")
    void transfer(String sum){
        actionTransferPage = dashBoardPage.actionTransferToCard1();
        actionTransferPage.transferToCard(sum, UserInfo.getCards().getValueTopUpCard1(), UserInfo.getCards().getCard2Number());

    }

    @Тогда("баланс его 1 карты из списка на главной странице должен стать {string} рублей")
    void balance(String sum){
        int balance = Integer.parseInt(sum);
        Assertions.assertEquals(balance, dashBoardPage.getCard1Balance());
    }
}
