package pe.edu.upc.techniciansearchapi.EasyJobs.resource;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SaveTechnicianResource {
    @NotBlank
    @NotNull
    @Size(max = 25)
    private String userName;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String password;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String email;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String identificationType;

    @NotBlank
    @NotNull
    @Min(0)
    private Long identificationNumber;

    @NotBlank
    @NotNull
    @Min(0)
    private Long phoneNumber;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String firstName;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String lastName;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String address;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String city;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String district;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String gender;
}
