package com.burgjetapi2.services.impls;

import com.burgjetapi2.mappers.PrisonMapper;
import com.burgjetapi2.models.PrisonDto;
import com.burgjetapi2.models.InmateReportStatusChangeDto;
import com.burgjetapi2.repositories.PrisonRepository;
import com.burgjetapi2.services.PrisonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrisonServiceImpl implements PrisonService {

    private final PrisonRepository repository;
    private final PrisonMapper prisonMapper;

    public PrisonServiceImpl(PrisonRepository repository, PrisonMapper prisonMapper) {
        this.repository = repository;
        this.prisonMapper = prisonMapper;
    }

    @Override
    public void add(PrisonDto prisonDto) {
        var entity = prisonMapper.toEntity(prisonDto);
        repository.save(entity);
    }

    @Override
    public void modify(long id, PrisonDto updatedPrisonDto) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new RuntimeException("Inmate report not found");

        var entity = optionalEntity.get();
        entity.setCrimeType(updatedPrisonDto.getCrimeType());
        entity.setInmateDescription(updatedPrisonDto.getInmateDescription());
        entity.setArrestingOfficer(updatedPrisonDto.getArrestingOfficer());
        entity.setIncarcerationDate(updatedPrisonDto.getIncarcerationDate());
        entity.setPrisonLocation(updatedPrisonDto.getPrisonLocation());
        entity.setIsInmateActive(updatedPrisonDto.isActive());

        repository.save(entity);
    }

    @Override
    public void removeById(long id) {
        repository.deleteById(id);
    }

    @Override
    public PrisonDto findById(long id) {
        var entity = repository.findById(id);
        if (entity.isEmpty())
            throw new RuntimeException("Inmate report not found");

        return prisonMapper.toDto(entity.get());
    }

    @Override
    public List<PrisonDto> findAll() {
        return repository.findAll().stream().map(prisonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void changeStatus(long id, InmateReportStatusChangeDto statusChangeDto) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new EntityNotFoundException("Entity not found with id: " + id);
        var entity = optionalEntity.get();
        entity.setIsInmateActive(statusChangeDto.isInmateActive());
        repository.save(entity);
    }
}
