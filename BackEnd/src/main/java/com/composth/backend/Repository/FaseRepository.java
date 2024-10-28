package com.composth.backend.Repository;

import com.composth.backend.entity.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fase", path = "fase")
public interface FaseRepository extends JpaRepository<Fase, Long> {
}
