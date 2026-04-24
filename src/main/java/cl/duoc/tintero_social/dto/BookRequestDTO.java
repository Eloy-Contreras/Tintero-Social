package cl.duoc.tintero_social.dto;

import jakarta.validation.constraints.NotBlank;

public class BookRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    private String title;

    @NotBlank(message = "El autor es obligatorio")
    private String author;


}
