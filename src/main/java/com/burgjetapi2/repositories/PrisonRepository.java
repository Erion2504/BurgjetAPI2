package com.burgjetapi2.repositories;

import com.burgjetapi2.entities.PrisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrisonRepository extends JpaRepository<PrisonEntity, Long> {
}
