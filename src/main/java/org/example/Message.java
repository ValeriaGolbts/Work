package org.example;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Message
{
    private String role, text;
}