package com.burgjetapi2.services;

import com.burgjetapi2.models.PrisonDto;
import com.burgjetapi2.models.InmateReportStatusChangeDto;

import java.util.List;

public interface PrisonService {
    void add(PrisonDto prisonDto);

    void modify(long id, PrisonDto updatedPrisonDto);

    void removeById(long id);

    PrisonDto findById(long id);

    List<PrisonDto> findAll();

    void changeStatus(long id, InmateReportStatusChangeDto statusChangeDto);
}
