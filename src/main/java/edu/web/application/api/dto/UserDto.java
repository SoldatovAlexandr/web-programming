package edu.web.application.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

//    @Pattern(regexp = "^[a-zA-Zа-яА-Я ]*$", message = "required.value.error")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String password;

    @Email(message =  "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String login;

    private List<RoleDto> roles;
}
