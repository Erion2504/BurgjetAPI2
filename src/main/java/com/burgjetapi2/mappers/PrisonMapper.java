package com.burgjetapi2.mappers;

import com.burgjetapi2.entities.PrisonEntity;
import com.burgjetapi2.models.InmateReportDto;
import com.burgjetapi2.models.InmateReportListDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrisonMapper {
    public PrisonEntity toEntity(InmateReportDto dto) {
        var entity = new PrisonEntity();
        entity.setInmateDescription(dto.getDescription());
        entity.setId(dto.getId());
        entity.setIncarcerationDate(dto.getDate());
        entity.setPrisonLocation(dto.getAddress());
        entity.setCrimeType(dto.getCaseType());
        entity.setArrestingOfficer(dto.getReporter());
        entity.setAdmissionDate(LocalDateTime.now());
        entity.setIsInmateActive(dto.isActive());
        return entity;
    }

    public InmateReportDto toDto(PrisonEntity entity) {
        var dto = new InmateReportDto();
        dto.setDescription(entity.getInmateDescription());
        dto.setId(entity.getId());
        dto.setDate(entity.getIncarcerationDate());
        dto.setAddress(entity.getPrisonLocation());
        dto.setCaseType(entity.getCrimeType());
        dto.setReporter(entity.getArrestingOfficer());
        dto.setActive(entity.isIsInmateActive());
        return dto;
    }

    public InmateReportListDto toListDto(PrisonEntity entity) {
        InmateReportListDto dto = new InmateReportListDto();
        dto.setReportDate(entity.getIncarcerationDate());
        dto.setCaseType(entity.getCrimeType());
        dto.setId(entity.getId());
        return dto;
    }
}
