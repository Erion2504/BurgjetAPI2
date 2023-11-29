package com.burgjetapi2.models;

import lombok.Data;

@Data
public class InmateReportStatusChangeDto {
    private long id;
    private boolean isInmateActive;
}
