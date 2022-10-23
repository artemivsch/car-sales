package by.tms.carsales.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationUserModel {
    @NotBlank
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._]{2,6}$", message = "Username must contain at 2 characters")
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,20}$", message = "Password must contain at least 6 characters, one uppercase, one lowercase and one number")
    private String password;

    @Pattern(regexp = "^[0-9-+)(]{3,13}$", message = "Telephone must be like 375XXXXXXXXX")
    private String telephone;
}
