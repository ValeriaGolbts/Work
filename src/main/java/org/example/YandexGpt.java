package org.example;

import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import static java.util.Objects.*;

public final class YandexGpt
{
    static private final String
    //ENV_VAR_KEY = "LWR_CLOUD_YAGPT_KEY",       // имя переменной окружения для API-ключа
    //ENV_VAR_FOLDER = "LWR_CLOUD_YAGPT_FOLDER", // имя переменной окружения для folderId
    //URL_ASYNC = ".../completionAsync",         // URL для асинхронного запроса
    URL_SYNC = ".../completion";                // URL для синхронного запроса

    private static String aje5q6bu3uie86gn8q62;
    private static final String API_KEY = aje5q6bu3uie86gn8q62 ;
    private static String b1gul7mru1iq5c93j2tp;
    private static final String FOLDER_ID = b1gul7mru1iq5c93j2tp ;

    static private final Gson gson = new Gson();    // экземпляр Gson для работы с JSON

    private final Prompt prompt;  // объект с данными запроса

    public YandexGpt(CompletionOptions options, List<Message> messages)
    {
        this.prompt = new Prompt();
        prompt.setCompletionOptions(requireNonNull(options, "options can't be null"));
        prompt.setMessages(requireNonNull(messages, "messages can't be null"));
        prompt.setModelUri("gpt://" + FOLDER_ID + "/yandexgpt");
    }

    public Response doSync() throws IOException
    {
        final URL url = new URL(URL_SYNC); // URL-объект для синхронного API-эндпоинта
        final var b = new StringBuilder(); //  JSON-тело запроса
        gson.toJson(prompt, b);
        final byte[] postData       = new String(b).getBytes( java.nio.charset.StandardCharsets.UTF_8 );
        final int    postDataLength = postData.length;

        final HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        // параметры соеденения
        httpCon.setDoOutput(true);
        httpCon.setInstanceFollowRedirects( false );
        httpCon.setRequestMethod("POST");
        httpCon.setRequestProperty("Authorization", "Api-Key " + API_KEY );
        httpCon.setRequestProperty("Content-Type", "application/json");
        httpCon.setRequestProperty( "charset", "utf-8");
        httpCon.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        httpCon.setUseCaches( false );
        // отпрака данных
        try( DataOutputStream w = new DataOutputStream( httpCon.getOutputStream())) {
            w.write( postData );
            w.flush();
        }
        if (httpCon.getResponseCode() != 200)  // проверяем код
            throw new IllegalStateException("HTTP Code is " + httpCon.getResponseCode());
        // читаем
        try (final var r = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "UTF-8"))){
            return gson.fromJson(r, Response.class);
        }
    }
}