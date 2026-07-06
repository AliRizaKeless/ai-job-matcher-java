package no.alirizakeles.aijobmatcher.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateJobRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String companyName;

    @NotBlank
    private String location;

    @Size(max = 5000)
    private String description;

    private String url;

    private String employmentType;
}