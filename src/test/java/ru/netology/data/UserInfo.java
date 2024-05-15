package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class UserInfo {
    Faker faker = new Faker(new Locale("en"));

    @Value
    public static class User {
    private static String login = "vasya";
   static String password = "qwerty123";
     static String code = "12345";

        public static String getLogin(){
            return login;
        }

        public static String getPassword(){
            return password;
        }

        public static String getCode(){
            return code;
        }
    }


    @Value
            public static class CardsInfo{
     static String card1Number = "5559 0000 0000 0001";
   static String card2Number = "5559 0000 0000 0002";
    static String valueTopUpCard1 = "**** **** **** 0001";
    static String valueTopUpCard2 = "**** **** **** 0002";

     public static String getCard1Number(){
         return card1Number;
     }

     public static String getCard2Number(){
         return card2Number;
     }

     public static String getValueTopUpCard1(){
         return valueTopUpCard1;
     }

     public static String getValueTopUpCard2(){
         return valueTopUpCard2;
     }

    }


}
