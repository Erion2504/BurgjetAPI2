package com.burgjetapi2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrisonListDto {
    private long id;
    private String crimeType;
    private LocalDateTime reportDate;
}
