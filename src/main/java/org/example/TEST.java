package org.example;

import java.io.IOException;
import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        try {
            YandexGpt yandexGpt = new YandexGpt(
                    new CompletionOptions(false, 0.7, 1024),
                    Arrays.asList(
                            new Message("system", "Ты — помощник для создания презентаций."),
                            new Message("user", "Напиши текст для слайда о Java.")
                    )
            );

            Response response = yandexGpt.doSync();
            System.out.println("Текст ответа: " +
                    response.getResult().getAlternatives().get(0).getMessage().getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
