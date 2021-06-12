package com.example.BlackMan1.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Person {

    private final UUID id;

    @NotNull(message = "First name is a required field")
    @NotBlank
    @Size(min = 2, max = 30, message = "Name should be at least 2 characters up to 30.")
    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name.trim();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
