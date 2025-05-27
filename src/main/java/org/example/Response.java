package org.example;

import lombok.*;

//import javax.xml.transform.Result;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Response //парсинг ответа
{
    private Result result;
}