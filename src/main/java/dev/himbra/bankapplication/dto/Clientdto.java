package dev.himbra.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor @Setter @Getter
public class Clientdto {
    private Long id;
    private String firstName;
    private String lastName;
}
