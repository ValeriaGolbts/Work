package org.example;

import java.util.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Result
{
    private List<ResultAlternative> alternatives;
}
