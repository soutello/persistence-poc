package dev.lfsoutello.simpleservicetemplate.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExampleDTO {
    private final Long id;
    private final String text;

    public ExampleDTO(Example example) {
        id = example.getId();
        text = example.getText();
    }
}
