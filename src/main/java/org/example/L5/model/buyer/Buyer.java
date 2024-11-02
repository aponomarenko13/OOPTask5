package org.example.L5.model.buyer;

import org.example.L5.model.Specialize;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Buyer {
    private String FIO;
    private Specialize preferences;
    private LocalDate birthday;
    private LocalDate visit;

}
