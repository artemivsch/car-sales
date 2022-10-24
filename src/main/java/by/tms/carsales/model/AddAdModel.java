package by.tms.carsales.model;

import by.tms.carsales.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
public class AddAdModel {

    @Pattern(regexp = "^[a-zA-Z0-9_]{2,8}$", message = "Car number must be like 0000-XX")
    private String carNumber;

    @Min(value = 1960) @Max(value = 2022)
    private int yearOfMade;

    @Min(0) @Max(1000000)
    private int runKm;

    @Min(800) @Max(6500)
    private int volumeOfEngine;

    private MultipartFile file;

    @Min(100) @Max(1000000)
    private int coast;

    private User user;
    @NotNull
    public Long modelId;



}
