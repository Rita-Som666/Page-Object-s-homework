package ru.netology.data;

import lombok.Value;

public class UserInfo {


    @Value
    public static class User {
        String login = "vasya";
        String password = "qwerty123";
        String code = "12345";

    }


    @Value
    public static class CardsInfo {
        String card1Number = "5559 0000 0000 0001";
        String card2Number = "5559 0000 0000 0002";
        String valueTopUpCard1 = "**** **** **** 0001";
        String valueTopUpCard2 = "**** **** **** 0002";


    }


}
