package org.example;

import java.io.IOException;
import java.util.Arrays;


public class Client {
    public String generateSlideText(String frameTitle) throws IOException{
        final var gpt = new YandexGpt(
                new CompletionOptions(false, 0.7, 1024),
                Arrays.asList(
                        new Message("system", "Напиши для презентации текст слайда с заголовком"),
                        new Message("user", frameTitle)
                )
        );

        final var resp = gpt.doSync();
        return resp.getResult().getAlternatives().get(0).getMessage().getText();
    }
}
