package org.example;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CompletionOptions
{
    private boolean stream; //вкл.(выкл.) потоковой передачи
    private double temperature;
    private int maxTokens;
}