package ru.netology.test;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.UserInfo;
import ru.netology.page.ActionTransferPage;
import ru.netology.page.DashBoardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.UserInfo.CardsInfo.*;

import ru.netology.data.UserInfo.CardsInfo;

public class TransferTest {
    @BeforeEach
    void shouldAuthorization() {
        open("http://localhost:9999/");
        var loginPge = new LoginPage();
        loginPge.validLogin();
        VerificationPage.validCode();
    }

    @Test
    void shouldTransferToCard1() {

        var balance = DashBoardPage.getCard2Balance();
        var balanceTo = DashBoardPage.getCard1Balance();
        int amount = 700;
        if (balance - amount >= 0) {
            String sum = String.valueOf(amount);
            DashBoardPage.actionTransferToCard1();


            ActionTransferPage.transferToCard(sum, getValueTopUpCard1(), getCard2Number());
            int balance1 = balanceTo + amount;
            String sum1 = String.valueOf(balance1);
            $(withText(sum1)).shouldBe(Condition.visible);
            int balance2 = balance - amount;
            String sum2 = String.valueOf(balance2);
            $(withText(sum2)).shouldBe(Condition.visible);
        }


    }

    @Test
    void shouldTransferToCard2() {

        var balance = DashBoardPage.getCard1Balance();
        var balanceTo = DashBoardPage.getCard2Balance();
        int amount = 1000;

        if (balance - amount >= 0) {
            String sum = String.valueOf(amount);
            DashBoardPage.actionTransferToCard2();


            ActionTransferPage.transferToCard(sum, getValueTopUpCard2(), getCard1Number());
            $(byText("Ваши карты")).shouldBe(Condition.visible);
            int balance1 = balanceTo + amount;
            String sum1 = String.valueOf(balance1);
            $(withText(sum1)).shouldBe(Condition.visible);
            int balance2 = balance - amount;
            String sum2 = String.valueOf(balance2);
            $(withText(sum2)).shouldBe(Condition.visible);
        }


    }

    @Test
    void shouldNotTransferToCard1() {

        var balance = DashBoardPage.getCard2Balance();
        int amount = balance + 10;
        String sum = String.valueOf(amount);
        DashBoardPage.actionTransferToCard1();

        ActionTransferPage.transferToCard(sum, getValueTopUpCard1(), getCard2Number());

        $("[data-test-id='error-notification']").shouldBe(Condition.visible);

    }

    @Test
    void shouldNotTransferToCard2() {

        var balance = DashBoardPage.getCard1Balance();
        int amount = balance + 10;
        String sum = String.valueOf(amount);
        DashBoardPage.actionTransferToCard2();

        ActionTransferPage.transferToCard(sum, getValueTopUpCard2(), getCard1Number());

        $("[data-test-id='error-notification']").shouldBe(Condition.visible);

    }
}
