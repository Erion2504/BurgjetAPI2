package com.burgjetapi2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prisons")
public class PrisonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String inmateDescription;
    private String crimeType;
    private String prisonLocation;
    private String arrestingOfficer;
    @Column(nullable = true)
    private boolean isInmateActive;
    private LocalDateTime incarcerationDate;
    private LocalDateTime admissionDate = LocalDateTime.now();

    public void setIsInmateActive(boolean active) {
    }
}
