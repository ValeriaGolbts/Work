package org.example;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ResultMessage
{
    private String role, text;
}