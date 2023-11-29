package com.burgjetapi2.controllers;

import com.burgjetapi2.models.PrisonDto;
import com.burgjetapi2.models.InmateReportStatusChangeDto;
import com.burgjetapi2.services.PrisonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prisons")
@CrossOrigin(origins = "*")
public class PrisonController {
    private final PrisonService prisonService;

    public PrisonController(PrisonService prisonService) {
        this.prisonService = prisonService;
    }

    @GetMapping
    public List<PrisonDto> getAllPrisons() {
        return prisonService.findAll();
    }

    @GetMapping("/{id}")
    public PrisonDto getById(@PathVariable long id) {
        return prisonService.findById(id);
    }

    @PostMapping
    public void addPrison(@RequestBody PrisonDto newPrison) {
        prisonService.add(newPrison);
    }

    @PutMapping("/{id}")
    public void updatePrison(@PathVariable long id, @RequestBody PrisonDto updatedPrison) {
        prisonService.modify(id, updatedPrison);
    }

    @PatchMapping("/{id}")
    public void changePrisonStatus(@PathVariable long id, @RequestBody InmateReportStatusChangeDto updatedPrison) {
        prisonService.changeStatus(id, updatedPrison);
    }

    @DeleteMapping("/{id}")
    public void deletePrison(@PathVariable long id) {
        prisonService.removeById(id);
    }
}
