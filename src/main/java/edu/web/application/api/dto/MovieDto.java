package edu.web.application.api.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MovieDto {

    private Long id;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9 -]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String name;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я ]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String author;
}
