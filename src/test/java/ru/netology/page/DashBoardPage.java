package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import lombok.val;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Value
public class DashBoardPage {
    private static final ElementsCollection topUpCards = $$("[data-test-id='action-deposit'");
    private static final SelenideElement topUpCard1 = topUpCards.get(0);
    private static final SelenideElement topUpCard2 = topUpCards.get(1);
    private static final ElementsCollection cards = $$(".list__item div");
    private static final SelenideElement card1 = cards.get(0);
    private static final SelenideElement card2 = cards.get(1);
    private static final SelenideElement dashboard = $("[data-test-id='dashboard']");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";


    public DashBoardPage() {
        dashboard.shouldBe(Condition.visible);
    }


    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


    public static int getCard1Balance() {
        val text = card1.text();
        return extractBalance(text);
    }

    public static int getCard2Balance() {
        val text = card2.getText();
        return extractBalance(text);
    }


    public static ActionTransferPage actionTransferToCard1() {
        topUpCard1.click();
        return new ActionTransferPage();
    }

    public static ActionTransferPage actionTransferToCard2() {
        topUpCard2.click();
        return new ActionTransferPage();
    }
}
