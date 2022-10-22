package by.tms.carsales.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class LoginUserModel {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
