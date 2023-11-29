package com.burgjetapi2.mappers;

import com.burgjetapi2.entities.PrisonEntity;
import com.burgjetapi2.models.PrisonDto;
import com.burgjetapi2.models.PrisonListDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrisonMapper {
    public PrisonEntity toEntity(PrisonDto dto) {
        var entity = new PrisonEntity();
        entity.setInmateDescription(dto.getInmateDescription());
        entity.setId(dto.getId());
        entity.setIncarcerationDate(dto.getIncarcerationDate());
        entity.setPrisonLocation(dto.getPrisonLocation());
        entity.setCrimeType(dto.getCrimeType());
        entity.setArrestingOfficer(dto.getArrestingOfficer());
        entity.setAdmissionDate(LocalDateTime.now());
        entity.setIsInmateActive(dto.isActive());
        return entity;
    }

    public PrisonDto toDto(PrisonEntity entity) {
        var dto = new PrisonDto();
        dto.setInmateDescription(entity.getInmateDescription());
        dto.setId(entity.getId());
        dto.setIncarcerationDate(entity.getIncarcerationDate());
        dto.setPrisonLocation(entity.getPrisonLocation());
        dto.setCrimeType(entity.getCrimeType());
        dto.setArrestingOfficer(entity.getArrestingOfficer());
        dto.setActive(entity.isInmateActive());
        return dto;
    }

    public PrisonListDto toListDto(PrisonEntity entity) {
        PrisonListDto dto = new PrisonListDto();
        dto.setReportDate(entity.getIncarcerationDate());
        dto.setCrimeType(entity.getCrimeType());
        dto.setId(entity.getId());
        return dto;
    }
}
