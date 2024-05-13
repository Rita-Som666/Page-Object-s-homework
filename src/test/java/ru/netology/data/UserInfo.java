package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserInfo {
    private static String login;
    private static String password;
    private static String code;
    private static final Faker faker = new Faker(new Locale("en"));

    public static String getLogin(){
        login = "vasya";
        return login;
    }

    public static String getPassword(){
        password = "qwerty123";
        return password;
    }

    public static String getCode(){
        code = "12345";
        return code;
    }

    public static String getInvalidLogin(){
        login = faker.name().username();
        return login;
    }

    public static String getInvalidPassword(){
        password = faker.internet().password();
        return password;
    }

    public static String getInvalidCode(){
        code = faker.number().digits(5);
        return code;
    }

}
