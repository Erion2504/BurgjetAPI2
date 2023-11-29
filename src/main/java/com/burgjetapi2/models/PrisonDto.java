package com.burgjetapi2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrisonDto {
    private long id;
    private String inmateDescription;
    private String crimeType;
    private String prisonLocation;
    private String arrestingOfficer;
    private LocalDateTime incarcerationDate;
    private boolean isActive;

}
