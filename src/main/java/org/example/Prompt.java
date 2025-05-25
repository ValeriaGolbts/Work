package org.example;

import java.util.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prompt //контейнер
{
    private String modelUri;
    private CompletionOptions completionOptions;  //настройки
    private List<Message> messages;
}