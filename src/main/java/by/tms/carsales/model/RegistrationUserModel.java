package by.tms.carsales.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationUserModel {
    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._]{2,6}$", message = "Username must contain at 2 english characters")
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,20}$", message = "Password must contain at least 6 characters, one uppercase, one lowercase and one number")
    private String password;
}
