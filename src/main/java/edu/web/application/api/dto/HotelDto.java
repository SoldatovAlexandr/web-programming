package edu.web.application.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelDto {
    private Long id;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9 -]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String name;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я ]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String directorName;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я ]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String address;

    @Min(value = 0, message = "")
    private Long countVisitor;
}
