package edu.web.application.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {

    private Long id;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я ]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String name;

    @Email(message =  "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String email;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9-]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String cardNumber;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9-]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String groupName;

    @Max(value = 2, message = "required.value.error")
    @Min(value = 1, message = "required.value.error")
    private Integer subgroup;

}
