package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class DashBoardPage {
    private final List<SelenideElement> cards = $$("[data-test-id='action-deposit' .button]");
    private final SelenideElement card1 = cards.get(0);
    private final SelenideElement card2 = cards.get(1);

    public void actionTransferToCard1(){
        card1.click();
    }

    public void actionTransferToCard2(){
        card2.click();
    }
}
