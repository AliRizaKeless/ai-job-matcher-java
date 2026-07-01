package no.alirizakeles.aijobmatcher.dto;

import lombok.Data;

@Data
public class CreateJobRequest {

    private String title;
    private String companyName;
    private String location;
    private String description;
    private String url;
    private String employmentType;
}